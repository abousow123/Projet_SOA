import { Component, OnInit } from '@angular/core';
import { Faculte } from '../models/faculte';
import { FaculteServiceService } from '../services/faculte-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fac',
  templateUrl: './fac.component.html',
  styleUrls: ['./fac.component.css']
})
export class FacComponent implements OnInit {
listeFacultes:Faculte [] = []
  constructor(public faculteService:FaculteServiceService,private router:Router) { }

  ngOnInit() {
    this.faculteService.getFacultes().subscribe(data=>{
      this.listeFacultes=data
    },err=>{
      console.log(err);
    });
  }
  routerEdite(code :string){
    this.router.navigate(['editfaculte',code]);
  }
  routerDelete(code :string){
    this.faculteService.deleteFaculte(code).subscribe(data=>{
      //this.listeFacultes=data;
      this.ngOnInit();
    },err=>{
      console.log(err);
    })
    //this.router.navigate(['facultes']);
  }
}
