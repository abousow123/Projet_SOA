import { Component, OnInit } from '@angular/core';
import { EtudiantServiceService } from '../services/etudiant-service.service';
import { Etudiant } from '../models/etudiant';

@Component({
  selector: 'app-etudiant',
  templateUrl: './etudiant.component.html',
  styleUrls: ['./etudiant.component.css']
})
export class EtudiantComponent implements OnInit {

  listes: Etudiant[] = [];
  etudiant: Etudiant;
  constructor(private etudiantService: EtudiantServiceService) { }

  ngOnInit() {
    this.etudiantService.getEtudiants().subscribe(data => {
      this.listes = data;
    }, err => {
      console.log(err);
    });
  }
  listeEtudiants() {
    
    return this.listes;
  }
  saveEtudiant() {
    this.etudiantService.save(this.etudiant).subscribe(data => {
      console.log(this.etudiant);
    }, err => {
      console.log(err);
    });
  }
}
