import { Component, OnInit } from '@angular/core';
import { PromotionServiceService } from '../services/promotion-service.service';
import { Promotion } from '../models/promotion';
import { Etudiant } from '../models/etudiant';

@Component({
  selector: 'app-promotion',
  templateUrl: './promotion.component.html',
  styleUrls: ['./promotion.component.css']
})
export class PromotionComponent implements OnInit {

 listes : Promotion[] = [] ;
 ltetudiant : Etudiant[] = [] ;
 promotion: Promotion;

  constructor(public promotionService: PromotionServiceService) { }

  ngOnInit() {
    this.promotionService.getPromotions()
    .subscribe(data => {
      this.listes = data;
      this.ltetudiant = data.etudiants;
      
    }, err => {
      console.log(err);
    })
  }

  listePromotions() {
    
    return this.listes;
  }

  listeEtudiants(){
  return this.ltetudiant ;
  }

  

}
