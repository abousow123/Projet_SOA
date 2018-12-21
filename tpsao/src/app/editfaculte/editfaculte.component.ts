import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FaculteServiceService } from '../services/faculte-service.service';
import { Faculte } from '../models/faculte';

@Component({
  selector: 'app-editfaculte',
  templateUrl: './editfaculte.component.html',
  styleUrls: ['./editfaculte.component.css']
})
export class EditfaculteComponent implements OnInit {
  codefaculte:string=''
  faculte:Faculte= new Faculte()
  constructor(public activeRoute: ActivatedRoute,public faculteservice:FaculteServiceService,private router:Router) {
    this.codefaculte=this.activeRoute.snapshot.params['id'];
    this.faculteservice.getFaculte(this.codefaculte).subscribe(data=>{
      this.faculte=data;
    },err=>{
      console.log(err);
    })
   }

  ngOnInit() {
  }
edit(){
  this.faculteservice.updatefaculte(this.faculte).subscribe(data=>{
    this.router.navigate(['facultes']);
  },err=>{
    console.log(err);
  }
  )
}
}
