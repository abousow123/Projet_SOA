import { Component, OnInit } from '@angular/core';
import { ClasseServiceService } from '../services/classe-service.service';
import { Classe } from '../models/classe';

@Component({
  selector: 'app-classe',
  templateUrl: './classe.component.html',
  styleUrls: ['./classe.component.css']
})
export class ClasseComponent implements OnInit {
listesClasses: Classe[]=[]
  constructor( public classeService:ClasseServiceService) { }

  ngOnInit() {
    this.classeService.getClasses().subscribe(data => {
      this.listesClasses=data;
    },err=>{
      console.log(err)
    });
  }

}
