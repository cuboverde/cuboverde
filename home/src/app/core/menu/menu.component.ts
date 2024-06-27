import { Component } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Router, RouterLink } from '@angular/router';
import { LoginService } from '../../services/login.service';

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
  isRol = 0;

  constructor(private loginService: LoginService, private router: Router ){

    loginService.getLoggelnName.subscribe(name => this.changeName(name));
    if(this.loginService.isLoggedIn()){
      this.isLogin = true;
    }else{
      this.isLogin = false;
    }
  }

  private changeName(name: boolean):void{
    this.isLogin = name;
  }

  logout(){
    // this.dataService.deleteToken();
    this.isLogin = false;
    this.router.navigate(['home']);

    // window.location.href ='home';
  }


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
