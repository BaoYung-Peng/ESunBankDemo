import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SeatService } from '../@services/seat.service';
import { Seat } from '../@models/seat.model';
import { EmployeeService } from '../@services/employee.service';
import { Employee } from '../@models/employee.model';

@Component({
  selector: 'app-seating-chart',
  imports: [
    CommonModule,
    FormsModule,
  ],
  templateUrl: './seating-chart.component.html',
  styleUrl: './seating-chart.component.scss'
})
export class SeatingChartComponent {

  // 所有座位清單
  seatList: Seat[] = [];

  // 所有員工清單
  employeeList: Employee[] = [];

  // 已指派座位的員工清單
  assignedEmployees: Employee[] = [];

  // 尚未指派座位的員工清單（給下拉選單使用）
  unassignedEmployees: Employee[] = [];

  // 當前選擇的座位與員工
  selectedSeatSeq: number | null = null;
  selectedEmpId: number | null = null;


  // 將座位分組成 2D 陣列（每列最多 4 個座位）
  groupedSeatList: Seat[][] = [];

  constructor(
    private seatService: SeatService,
    private employeeService: EmployeeService
  ) { }

  // 初始化時執行，載入所有資料
  ngOnInit(): void {
    this.refreshData();
  }

  // 重新載入座位和員工清單並同步狀態
  refreshData(): void {
    this.seatService.getAll().subscribe({
      next: (res: any) => {
        // 取得座位與已分派的員工
        this.seatList = res.seatingChartList;
        this.assignedEmployees = res.employeeList.map((emp: any) => ({
          ...emp,
          floorSeatSeq: emp.floorSeatSEQ, // 正規化命名
        }));

        // 將 empId 指派給座位物件 => 將員工編號填入座位資訊
        this.seatList.forEach(seat => {
          const assigned = this.assignedEmployees.find(emp => emp.floorSeatSeq === seat.floorSeatSEQ);
          seat.empId = assigned ? assigned.empId : null;
        });

        // 將座位分組成每列 4 個（畫面用）
        this.groupedSeatList = this.chunkArray(this.seatList, 4);

        // 取得所有員工，篩選出未指派員工
        this.employeeService.getAllEmployees().subscribe({
          next: (allEmployees: Employee[]) => {
            this.unassignedEmployees = allEmployees.filter(emp =>
              !this.assignedEmployees.some(ae => ae.empId === emp.empId)
            );
          },
          error: err => {
            console.error('取得員工失敗', err);
          }
        });
      },
      error: err => {
        console.error('取得座位失敗', err);
      }
    });
  }

  // 工具方法：將陣列分成 N 個一組
  chunkArray(arr: any[], size: number): any[][] {
    const result = [];
    for (let i = 0; i < arr.length; i += size) {
      result.push(arr.slice(i, i + size));
    }
    return result;
  }

  // 當點擊座位方塊時觸發
  seatClicked(seat: Seat): void {
    // 座位已被指派，詢問是否清除
    if (seat.empId) {
      const confirmClear = confirm(`座位已被員工編號 ${seat.empId} 使用。\n是否清除該員工的座位指派？`);
      if (!confirmClear) return;

      this.seatService.clearEmpSeat({ empId: seat.empId }).subscribe({
        next: (res: any) => {
          alert('已清除該座位的員工指派');
          this.refreshData(); // 清除後刷新整體畫面
        },
        error: (err) => {
          console.error('清除座位失敗', err);
          alert('清除失敗，請稍後再試');
        }
      });
      return; // 中斷後續選擇流程
    }

    // 尚未選擇員工
    if (this.selectedEmpId == null) {
      alert('請先選擇員工');
      return;
    }

    // 清除之前選擇的座位狀態（只在畫面）
    if (this.selectedSeatSeq !== null) {
      const prevSeat = this.seatList.find(s => s.floorSeatSEQ === this.selectedSeatSeq);
      if (prevSeat) {
        prevSeat.empId = null;
      }
    }

    // 設定新的選擇
    this.selectedSeatSeq = seat.floorSeatSEQ;
    seat.empId = this.selectedEmpId;

    console.log('選擇座位:', seat);
  }

  // 根據座位狀態設定 CSS class（供畫面顯示樣式）
  getCssClass(seat: Seat): string {
    if (seat.floorSeatSEQ === this.selectedSeatSeq) return 'selected';
    else if (seat.empId) return 'occupied';
    else return 'vacant';
  }

  // 送出指派座位
  submit(): void {
    if (this.selectedEmpId == null || this.selectedSeatSeq == null) {
      alert('請先選擇員工並點擊座位');
      return;
    }

    // 建立送出資料物件(API)
    const submitData = {
      empId: this.selectedEmpId,
      floorSeatSEQ: this.selectedSeatSeq
    };

    this.seatService.updateSeat(submitData).subscribe({
      next: (res: any) => {
        console.log('API 回應:', res);

        // 清除選擇狀態（避免還顯示綠色）
        this.selectedEmpId = null;
        this.selectedSeatSeq = null;

        // 重新載入資料
        this.refreshData();

        // 避免 alert 阻塞渲染
        setTimeout(() => {
          alert('座位分配成功！');
        }, 100);
      },
      error: (err) => {
        console.error('送出失敗:', err);
      }
    });
  }
}
