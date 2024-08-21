import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee.model';
import { SalarySlip } from '../models/salary-slip.model';

@Injectable({
  providedIn: 'root'
})
export class SalaryService {

  private apiUrl = 'http://localhost:8080/api/salary';

  constructor(private http: HttpClient) {}

  importEmployeeData(filePath: string): Observable<Employee[]> {
    return this.http.post<Employee[]>(`${this.apiUrl}/import`, { filePath });
  }

  generateSalarySlip(employeeName: string, month: string): Observable<SalarySlip> {
    return this.http.get<SalarySlip>(`${this.apiUrl}/generate`, {
      params: { employeeName, month }
    });
  }
}
