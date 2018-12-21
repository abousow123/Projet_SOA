import { Injectable } from '@angular/core';
import { Http,Response,RequestOptions } from '@angular/http';
import "rxjs/add/operator/map"
import { Faculte } from '../models/faculte';
@Injectable()
export class FaculteServiceService {

  constructor(public http:Http) {

   }
   getFacultes(){
    return this.http.get('http://localhost:8080/facultes').map(response=>response.json());
   }
   getFaculte(code:string){
    return this.http.get('http://localhost:8080/facultes/'+code).map(response=>response.json());
   }
   deleteFaculte(code:string){
    return this.http.delete('http://localhost:8080/facultes/delete/'+code).map(response=>response.json());
   }
   savefaculte(faculte:Faculte){
     return this.http.post('http://localhost:8080/facultes/save',faculte).map(response=>response.json());
   }

   updatefaculte(faculte:Faculte){
     return this.http.put('http://localhost:8080/facultes/update/'+faculte.codefaculte,faculte).map(response=>response.json());
   }

   
}
