import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class PromotionServiceService {

  constructor(public http: Http) { }

  getPromotions() {
    return this.http.get("http://localhost:8080/listPromotion/").map(resp => resp.json());
   }

}
