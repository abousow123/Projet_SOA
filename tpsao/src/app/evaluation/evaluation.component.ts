import { Component, OnInit } from '@angular/core';
import { Evaluation } from '../models/evaluation';
import { EvaluationServiceService } from '../services/evaluation-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-evaluation',
  templateUrl: './evaluation.component.html',
  styleUrls: ['./evaluation.component.css']
})
export class EvaluationComponent implements OnInit {

  listeEvaluations: Evaluation[] = [] ;
  evaluation: Evaluation ;


  constructor(private servicesEvaluation: EvaluationServiceService,private router:Router) { }

  ngOnInit() {
    this.servicesEvaluation.getEvaluations().subscribe(data => {
      this.listeEvaluations = data;
    }, err => {
      console.log(err);
    });
  }

  listeEva() {
    
    return this.listeEvaluations;
  }

  saveEva(){
    this.servicesEvaluation.saveEvaluation(this.evaluation).subscribe(data => {
      console.log(this.evaluation);
    }, err => {
      console.log(err);
    });
  }
   
  routerNote(code :string){
    this.router.navigate(['note',code]);
  }


}
