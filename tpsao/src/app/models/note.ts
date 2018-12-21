import { Etudiant } from "./etudiant";
import { Evaluation } from "./evaluation";

export class Note {
    constructor(public  codenote:string, public etudiant:Etudiant, 
        public evaluation:Evaluation, public note:number) {
    }
}
