import { Component } from '@angular/core';
import { SalaryService } from '../../services/salary.service';
import { SalarySlip } from '../../models/salary-slip.model';

@Component({
  selector: 'app-generate-slip',
  templateUrl: './generate-slip.component.html'
})
export class GenerateSlipComponent {
  slip: SalarySlip | undefined;

  constructor(private salaryService: SalaryService) {}

  generateSlip(employeeName: string, month: string) {
    this.salaryService.generateSalarySlip(employeeName, month).subscribe((data) => {
      this.slip = data;
    });
  }
}
