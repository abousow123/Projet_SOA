package sn.ucad.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sn.ucad.dao.ClasseRepository;
import sn.ucad.entites.Classe;
@CrossOrigin(origins="*")
@RestController
public class ClasseRest {
	@Autowired
	private ClasseRepository classeRepository;
	
	@RequestMapping(value = "/listClasse",method=RequestMethod.GET)
	public List<Classe> listContacts(){
		return classeRepository.findAll();
		
	}
	
	@RequestMapping(value = "/classe/{ref}",method=RequestMethod.GET)
	public Classe getContactByRef(@PathVariable("ref")String ref){
		return classeRepository.findOne(ref);
	}
	@RequestMapping(value = "/saveClasse",method=RequestMethod.POST)
	public Classe saveContact(@RequestBody Classe c){
		return classeRepository.save(c);
	}
	@RequestMapping(value = "/editClasse",method=RequestMethod.PUT)
	public Classe updateContact(@RequestBody Classe c){
		return classeRepository.saveAndFlush(c);
	}
	@RequestMapping(value = "/deleteClasse/{ref}", method = RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable("ref") String id){		
		classeRepository.delete(id);
		return true;
	}
}
