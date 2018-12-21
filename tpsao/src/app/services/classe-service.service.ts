import { Injectable } from '@angular/core';
import { Http ,Response, RequestOptions} from '@angular/http';
import "rxjs/add/operator/map"
@Injectable()
export class ClasseServiceService {

  constructor(public http:Http) { }

  getClasses(){
   return this.http.get("http://localhost:8080/listClasse").map(response=>response.json());
  }
}
