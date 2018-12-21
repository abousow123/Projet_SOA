import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from "@angular/forms";
import { AppComponent } from './app.component';
import { ClasseComponent } from './classe/classe.component';
import { DepartementComponent } from './departement/departement.component';
import { FacComponent } from './fac/fac.component';
import { EcComponent } from './ec/ec.component';
import { EtudiantComponent } from './etudiant/etudiant.component';
import { EvaluationComponent } from './evaluation/evaluation.component';
import { NoteComponent } from './note/note.component';
import { PromotionComponent } from './promotion/promotion.component';
import { HttpModule } from '@angular/http';
import { EtudiantServiceService } from './services/etudiant-service.service';
import { ClasseServiceService } from './services/classe-service.service';
import { FaculteServiceService } from './services/faculte-service.service';
import { EditfaculteComponent } from './editfaculte/editfaculte.component';
import { NewfaculteComponent } from './newfaculte/newfaculte.component';
import { EvaluationServiceService } from './services/evaluation-service.service';
import { NewEvaluationComponent } from './new-evaluation/new-evaluation.component';
import { PromotionServiceService } from './services/promotion-service.service';
import { NoteServiceService } from './services/note-service.service';
const appRoutes: Routes = [
  {path: 'home',component:AppComponent},
  {path: 'classes',component:ClasseComponent},
  {path: 'departements',component:DepartementComponent},
  {path: 'newfaculte',component:NewfaculteComponent},
  {path: 'facultes',component:FacComponent},
  {path: 'ec',component:EcComponent},
  {path: 'newEvaluation',component:NewEvaluationComponent},
  {path: 'etudiants',component:EtudiantComponent},
  {path: 'editfaculte/:id',component:EditfaculteComponent},
  {path: 'evaluation',component:EvaluationComponent},
  {path: 'promotion',component:PromotionComponent},
  {path: 'note',component:NoteComponent},
  {path: '',redirectTo:'/departements',pathMatch:'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    ClasseComponent,
    DepartementComponent,
    FacComponent,
    EcComponent,
    EtudiantComponent,
    EvaluationComponent,
    NoteComponent,
    PromotionComponent,
    EditfaculteComponent,
    NewfaculteComponent,
    NewEvaluationComponent
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(appRoutes),HttpModule,FormsModule
  ],
  providers: [EtudiantServiceService,ClasseServiceService,FaculteServiceService,EvaluationServiceService,
    PromotionServiceService,NoteServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
