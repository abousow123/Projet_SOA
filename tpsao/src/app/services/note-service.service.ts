import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Note } from '../models/note';

@Injectable()
export class NoteServiceService {

  constructor(public http: Http) { }

  getNotes() {
    return this.http.get("http://localhost:8080/listNote").map(resp => resp.json());
   }

   saveNote(note:Note) {
    return this.http.post("http://localhost:8080/saveNote/",note
    ).map(resp => resp.json());
   }

   

}
