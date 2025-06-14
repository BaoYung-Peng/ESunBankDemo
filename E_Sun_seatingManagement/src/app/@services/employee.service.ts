import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../@models/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  // 本地端
  IP: string = 'localhost';

  // IP位址 cmd => ipconfig:???.??.??.??
  //IP: string = 'localhost';

  employeeList: Employee[] = [];

  constructor(private httpClient: HttpClient) { }

  // 取得所有員工編號 => 下拉式選單
  getAllEmployees() {
    const url = `http://${this.IP}:8080/employee/getAllEmployees`;
    return this.httpClient.get<Employee[]>(url);
  }
}
