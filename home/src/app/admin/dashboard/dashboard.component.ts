import { Component } from '@angular/core';
import { environment } from '../../../environments/environment';


@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  creados = 45;
  aprobados = 35;
  entorno = environment;
}
