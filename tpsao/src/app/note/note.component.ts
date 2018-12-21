import { Component, OnInit } from '@angular/core';
import { Evaluation } from '../models/evaluation';
import { ActivatedRoute, Router } from '@angular/router';
import { NoteServiceService } from '../services/note-service.service';
import { EvaluationServiceService } from '../services/evaluation-service.service';
import { Etudiant } from '../models/etudiant';
import { EtudiantServiceService } from '../services/etudiant-service.service';
import { Note } from '../models/note';
import { not } from '@angular/compiler/src/output/output_ast';
import { Http } from '@angular/http';

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent implements OnInit {

  codeEval:string="";
  evaluation:Evaluation = new Evaluation();
  listeEvaluations: Evaluation[] = [] ;
  listesEtudiant: Etudiant[] = [];
  note: Note ;
  numetudiant: string="" ;
  etudiant1:Etudiant = new Etudiant();

  notes:Note ={
    codenote:"", etudiant: this.etudiant1, 
    evaluation:this.evaluation,  note:0
  }
  
  

  constructor(public noteService:NoteServiceService,public evalua:EvaluationServiceService
    ,public etudiantService: EtudiantServiceService,private router:Router,public http: Http) { 
      //this.codeEval=this.activeRoute.snapshot.params['id'] ;
    }

  ngOnInit() {
    this.evalua.getEvaluations().subscribe(data => {
      this.listeEvaluations = data;
      
      }, err => {
      console.log(err);
    });

    this.etudiantService.getEtudiants().subscribe(data => {
      this.listesEtudiant = data;

    }, err => {
      console.log(err);
    });
  }

  getEtu(){

      
      this.http.get("http://localhost:8080/etudiant/"+parseInt(this.numetudiant)).map(resp => resp.json())
      .subscribe(data1 => {
        this.notes.etudiant = data1;
        console.log(this.notes.etudiant);
      }, err => {
        console.log(err);
      });
      //return this.notes.etudiant ;
  }

  getEvalu(){
 
    this.http.get("http://localhost:8080/evaluation/"+parseInt(this.codeEval)).map(resp => resp.json())
    .subscribe(data2 => {
      this.notes.evaluation = data2;
      console.log(this.notes.evaluation);
    }, err => {
      console.log(err);
    });
    //return this.notes.etudiant ;
}

  saveNote(){
    // this.note.etudiant = this.etudiant1
      // this.note.etudiant = this.getEtu(code) ; 
       this.getEtu();
       this.getEvalu();
       
    this.noteService.saveNote(this.notes).subscribe(data=>{
      console.log(this.notes);

    }, err => {
      console.log(err);
    });

  }

  listeEva() {
    
    return this.listeEvaluations;
  }

  listeEtudiants() {
    
    return this.listesEtudiant;
  }

  getEtudiant(dataForm){
    return this.etudiantService.getOneEtudiant(dataForm).subscribe(data=>{
      console.log();
      
    }, err => {
      console.log(err);
    });
  }


  selectedOption: string;
  printedOption: string;

  options = [
    { name: "option1", value: 1 },
    { name: "option2", value: 2 }
  ]
  print() {
    this.printedOption = this.selectedOption;
  }


}
