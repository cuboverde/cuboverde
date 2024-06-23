import { Component } from '@angular/core';

@Component({
  selector: 'app-nosotros',
  standalone: true,
  imports: [],
  templateUrl: './nosotros.component.html',
  styleUrl: './nosotros.component.css'
})
export class NosotrosComponent {
  nosotros = [{
    id:1,
    nombre: 'Daniel Ibarra',
    correo: 'daniel.ibarra.talentotech@usa.edu.co',
    foto:  'user-03-290x290.jpg',
    facebook: '',
    twitter: '',
    linkedid: ''
  },{
    id:2,
    nombre: 'Jaime Duran',
    correo: 'jaime.duran.talentotech@usa.edu.co',
    foto:  'user-04-290x290.jpg',
    facebook: '',
    twitter: '',
    linkedid: ''
  },{
    id:3,
    nombre: 'Maribel Ramirez',
    correo: 'maribel.ramirez.talentotech@usa.edu.co',
    foto:  'user-05-290x290.jpg',
    facebook: '',
    twitter: '',
    linkedid: ''
  },{
    id:4,
    nombre: 'Jorge Armando Dottor',
    correo: 'jorge.dottor.talentotech@usa.edu.co',
    foto:  'user-06-290x290.jpg',
    facebook: '',
    twitter: '',
    linkedid: ''
  },{
    id:5,
    nombre: 'Rafael Barahona Beltran',
    correo: 'rafael.barahona.talentotech@usa.edu.co',
    foto:  'user-07-290x290.jpg',
    facebook: '',
    twitter: '',
    linkedid: ''
  }
  ]

}
