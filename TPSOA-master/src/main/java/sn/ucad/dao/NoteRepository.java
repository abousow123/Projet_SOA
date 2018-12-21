package sn.ucad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.ucad.entites.Note;

public interface NoteRepository extends JpaRepository<Note, String>{

}
