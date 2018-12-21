import { Component, OnInit } from '@angular/core';
import { EvaluationServiceService } from '../services/evaluation-service.service';
import { Evaluation } from '../models/evaluation';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-evaluation',
  templateUrl: './new-evaluation.component.html',
  styleUrls: ['./new-evaluation.component.css']
})
export class NewEvaluationComponent implements OnInit {

  evaluation:Evaluation = new Evaluation();
  constructor(private servicesEvaluation: EvaluationServiceService,public router:Router) { }

  ngOnInit() {
  }

  saveEvaluation(dataForm){
    this.servicesEvaluation.saveEvaluation(dataForm).subscribe(data=>{
     this.router.navigate(['evaluation'])
    },err=>{
      console.log(err);
    })
  }

}
