package sn.ucad.restful;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sn.ucad.dao.EtudiantRepository;
import sn.ucad.entites.Etudiant;
import sn.ucad.entites.Promotion;
@CrossOrigin(origins="*")
@RestController
public class EtudiantRest {
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@RequestMapping(value = "/listEtudiant",method=RequestMethod.GET)
	public List<Etudiant> listContacts(){
		List<Etudiant> list= new ArrayList<>();//.findAll();
//		for(Etudiant e:list) {
//			System.out.println(e);
//		}
		return etudiantRepository.findAll();
		
	}
	
	@RequestMapping(value = "/etudiant/{ref}",method=RequestMethod.GET)
	public Etudiant getContactByRef(@PathVariable("ref")String ref){
		return etudiantRepository.findOne(ref);
	}
	
	
	@RequestMapping(value = "/saveEtudiant",method=RequestMethod.POST)
	public Etudiant saveContact(@RequestBody Etudiant c){
		return etudiantRepository.save(c);
	}
	@RequestMapping(value = "/editEtudiant",method=RequestMethod.PUT)
	public Etudiant updateContact(@RequestBody Etudiant c){
		return etudiantRepository.saveAndFlush(c);
	}
	@RequestMapping(value = "/deleteEtudiant/{ref}", method = RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable("ref") String id){		
		etudiantRepository.delete(id);
		return true;
	}
}
