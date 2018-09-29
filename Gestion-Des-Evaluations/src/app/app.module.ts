import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { EtudiantsComponent } from './etudiants/etudiants.component';
import { PromotionsComponent } from './promotions/promotions.component';
import {Routes, RouterModule} from "@angular/router";
import { EvaluationsComponent } from './evaluations/evaluations.component';
import { NotesComponent } from './notes/notes.component';


const appRoutes:Routes=[
  {path:'etudiants', component:EtudiantsComponent},
  {path:'promotions', component:PromotionsComponent},
  {path:'',redirectTo:'/etudiants', pathMatch:'full'},

]

@NgModule({
  declarations: [
    AppComponent,
    EtudiantsComponent,
    PromotionsComponent,
    EvaluationsComponent,
    NotesComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
