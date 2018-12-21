import { Component, OnInit } from '@angular/core';
import { FaculteServiceService } from '../services/faculte-service.service';
import { Faculte } from '../models/faculte';
import { Router } from '@angular/router';

@Component({
  selector: 'app-newfaculte',
  templateUrl: './newfaculte.component.html',
  styleUrls: ['./newfaculte.component.css']
})
export class NewfaculteComponent implements OnInit {
  faculte:Faculte=new Faculte();
  constructor(public faculterService:FaculteServiceService,public router:Router) { }

  ngOnInit() {
  }
  onSavefaculte(dataForm){
    this.faculterService.savefaculte(dataForm).subscribe(data=>{
    
    this.router.navigate(['facultes']);
    },err=>{
      console.log(err);
    })
    }
}
