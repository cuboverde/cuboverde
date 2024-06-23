import { Component } from '@angular/core';
import { environment } from '../../../environments/environment';
import { MenuComponent } from '../menu/menu.component';
import { RouterLink } from '@angular/router';


MenuComponent
@Component({
  selector: 'app-header',
  standalone: true,
  imports: [MenuComponent, RouterLink],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  entorno = environment 
}
