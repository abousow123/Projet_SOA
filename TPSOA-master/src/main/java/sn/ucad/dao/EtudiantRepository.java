package sn.ucad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.ucad.entites.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,String>{

}
