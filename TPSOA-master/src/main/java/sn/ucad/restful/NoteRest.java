package sn.ucad.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sn.ucad.dao.NoteRepository;
import sn.ucad.entites.Note;

@RestController
@CrossOrigin(origins="*")
public class NoteRest {

	@Autowired
	private NoteRepository noteRepository;
	
	@RequestMapping(value = "/listNote",method=RequestMethod.GET)
	public List<Note> listContacts(){
		return noteRepository.findAll();
	}
	
	@RequestMapping(value = "/saveNote",method=RequestMethod.POST)
	public Note saveContact(@RequestBody Note c){
		return noteRepository.save(c);
	}
	
	@RequestMapping(value = "/editNote",method=RequestMethod.PUT)
	public Note updateContact(@RequestBody Note c){
		return noteRepository.saveAndFlush(c);
	}
	
	@RequestMapping(value = "/deleteNote/{ref}", method = RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable("ref") String id){		
		noteRepository.delete(id);
		return true;
	}
}
