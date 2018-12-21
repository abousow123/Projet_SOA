import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Evaluation } from '../models/evaluation';

@Injectable()
export class EvaluationServiceService {

  constructor(public http: Http) { }

  getEvaluations() {
    return this.http.get("http://localhost:8080/listEvaluation").map(resp => resp.json());
   }

   saveEvaluation(evaluation:Evaluation) {
    return this.http.post("http://localhost:8080/saveEvaluation/",evaluation
    ).map(resp => resp.json());
   }

   getEval(code:String){
     
   }

}
