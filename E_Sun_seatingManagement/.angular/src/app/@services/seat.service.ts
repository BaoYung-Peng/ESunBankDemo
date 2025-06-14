import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Seat } from '../@models/seat.model'; // 請確保路徑正確

@Injectable({
  providedIn: 'root'
})
export class SeatService {

  // 本地端
  IP: string = 'localhost';

  // IP位址 cmd => ipconfig:???.??.??.??
  //IP: string = 'localhost';

  constructor(private httpClient: HttpClient) { }

  // 顯示所有座位 => ngOnInit 起始畫面
  getAll() {
    const url = `http://${this.IP}:8080/seatChart/getAll`;
    return this.httpClient.get<Seat>(url);
  }

  // 員工更換座位 => 變更座位(使座位顯示員工編號EMP_ID)
  updateSeat(postData: any) {
    const url = `http://${this.IP}:8080/employee/updateSeat`;
    return this.httpClient.post(url, postData);
  }

  // 清除座位上的員工編號 => 清除座位上員工編號
  clearEmpSeat(postData: any) {
    const url = `http://${this.IP}:8080/employee/clearEmpSeat`;
    return this.httpClient.post(url, postData);
  }
}
