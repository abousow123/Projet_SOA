package sn.ucad.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sn.ucad.dao.DepartementRepository;
import sn.ucad.entites.Departement;

@RestController
@RequestMapping("/departements")
public class DepartementRest {
	@Autowired
	private DepartementRepository departementRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Departement> listContacts(){
		return departementRepository.findAll();
		
	}
	
	@RequestMapping(value = "/{ref}",method=RequestMethod.GET)
	public Departement getContactByRef(@PathVariable("ref")String ref){
		return departementRepository.findOne(ref);
	}
	@RequestMapping(value = "/save",method=RequestMethod.POST)
	public Departement saveContact(@RequestBody Departement c){
		//Faculte fac = new Faculte("FST");
		//c.setFaculte(fac);
		return departementRepository.save(c);
	}
	@RequestMapping(value = "/update/{ref}",method=RequestMethod.PUT)
	public Departement updateContact(@RequestBody Departement d,@PathVariable("ref") String codefaculte){
		d.setCodedepartement(codefaculte);
		return departementRepository.saveAndFlush(d);
	}
	@RequestMapping(value = "/delete/{ref}", method = RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable("ref") String id){		
		departementRepository.delete(id);
		return true;
	}
}
