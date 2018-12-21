import { Injectable } from '@angular/core';
import { Http ,Response, RequestOptions } from '@angular/http';
import "rxjs/add/operator/map"
import { Etudiant } from '../models/etudiant';

@Injectable()
export class EtudiantServiceService {

  constructor(public http: Http) { 

  }
  getEtudiants() {
   return this.http.get("http://localhost:8080/listEtudiant/").map(resp => resp.json());
  }

  getOneEtudiant(code:number){
    return this.http.get("http://localhost:8080/etudiant/"+code,null).map(resp => resp.json());
  }

  save(etudiant:Etudiant) {
    return this.http.post("http://localhost:8080/saveEtudiant/",etudiant).map(resp => resp.json());
   }
}
