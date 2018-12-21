import { Classe } from "./classe";
import { Etudiant } from "./etudiant";

export class Promotion {
    constructor(public annee:string, public etudiants:Etudiant) {
    }

    etu : Etudiant ;
}
