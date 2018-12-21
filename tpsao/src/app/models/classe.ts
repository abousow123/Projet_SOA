import { Departement } from "./departement";

export class Classe {
    constructor(public codeclasse:string, public departement:Departement
        , public libelleClasse:string, public nombreeEtudiant:number) {
    }
}