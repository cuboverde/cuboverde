import { Component } from '@angular/core';
import { environment } from '../../../environments/environment';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {
  entorno = environment;
  isLogin = false;
  isRol = 1;
  menus = [
    {
      id: 1,
      name:"Inicio",
      link:"/home",
    },{
      id: 2,
      name:"Acerca de",
      link:"/about",
    },{
      id: 3,
      name:"Nosotros",
      link:"/nosotros",
    },{
      id: 4,
      name:"Blog",
      link:"/blog",
    },{
      id: 5,
      name:"Galeria",
      link:"/gallery",
    },{
      id: 6,
      name:"Contacto",
      link:"/contact",
    },
  ]
}
