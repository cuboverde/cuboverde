import { Component, OnInit } from '@angular/core';
import { PublicationInterface } from '../../interfaces/interfaces';
import { PublicationsService } from '../../services/publications.service';
import { ErrormessageComponent } from '../../core/errormessage/errormessage.component';



@Component({
  selector: 'app-publications',
  standalone: true,
  imports: [ErrormessageComponent],
  templateUrl: './publications.component.html',
  styleUrl: './publications.component.css'
})
export class PublicationsComponent implements OnInit{

  publications: PublicationInterface[] = [];
  public errorMessage!:string;

  constructor(private publicationsService: PublicationsService){}


  ngOnInit(): void {
    this.publicationsService.getPublications().subscribe((response: PublicationInterface[]) => {
      this.publications = response;
      console.log(this.publications);
    }, error => {
      this.errorMessage = error;
    });
      
  }

}
