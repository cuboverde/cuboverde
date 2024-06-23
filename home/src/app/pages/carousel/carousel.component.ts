import { Component } from '@angular/core';

@Component({
  selector: 'app-carousel',
  standalone: true,
  imports: [],
  templateUrl: './carousel.component.html',
  styleUrl: './carousel.component.css'
})
export class CarouselComponent {
  carousels = [
  {
    id:1,
    imagen:'image5.jpg',
    titulo:'First slide label',
    subtitulo:'Some representative placeholder content for the first slide.',
  },{
    id:2,
    imagen:'image7.jpg',
    titulo:'Second slide label',
    subtitulo:'Some representative placeholder content for the second slide.',
  },{
    id:3,
    imagen:'image9.jpg',
    titulo:'Third slide label',
    subtitulo:'Some representative placeholder content for the third slide.',
  },{
    id:4,
    imagen:'FotoBoyaca.jpg',
    titulo:'Fourth slide label',
    subtitulo:'Some representative placeholder content for the fourth slide.',
  },{
    id:5,
    imagen:'image8.jpg',
    titulo:'Fifth slide label',
    subtitulo:'Some representative placeholder content for the fifth slide.',
  }
  ]
}
