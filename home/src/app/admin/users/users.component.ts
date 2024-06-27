import { Component, OnInit } from '@angular/core';
import { UserInterface } from '../../interfaces/interfaces';
import { UsersService } from '../../services/users.service';
import { ErrormessageComponent } from '../../core/errormessage/errormessage.component';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-users',
  standalone: true,
  imports: [ErrormessageComponent, RouterLink],
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent implements OnInit{

  usuarios: UserInterface[] = [];
  public errorMessage!:string;

  constructor(private usersService: UsersService) {}

  ngOnInit() {
    this.usersService.getUsuarios().subscribe((response: UserInterface[]) => {
      this.usuarios = response;
    }, error => {
      this.errorMessage = error;
    });
  }


}
