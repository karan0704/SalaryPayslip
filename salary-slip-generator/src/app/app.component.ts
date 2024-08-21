import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ImportExcelComponent } from './components/import-excel/import-excel.component';
import { genera}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'salary-slip-generator';
}
