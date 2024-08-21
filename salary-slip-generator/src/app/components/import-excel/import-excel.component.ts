import { Component } from '@angular/core';
import { SalaryService } from '../../services/salary.service';
import { Employee } from '../../models/employee.model';

@Component({
  selector: 'app-import-excel',
  templateUrl: './import-excel.component.html'
})
export class ImportExcelComponent {
  employees: Employee[] = [];

  constructor(private salaryService: SalaryService) {}

  importData(filePath: string) {
    this.salaryService.importEmployeeData(filePath).subscribe((data) => {
      this.employees = data;
    });
  }
}
