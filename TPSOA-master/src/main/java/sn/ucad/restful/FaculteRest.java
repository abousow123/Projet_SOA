package sn.ucad.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sn.ucad.dao.FaculteRepository;
import sn.ucad.entites.Faculte;

@RestController
@RequestMapping("/facultes")
@CrossOrigin
public class FaculteRest {

	@Autowired
	private FaculteRepository faculteRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Faculte> listContacts(){
		return faculteRepository.findAll();
	}
	
	@RequestMapping(value = "/{ref}",method=RequestMethod.GET)
	public Faculte getContactByRef(@PathVariable("ref")String codefaculte){
		return faculteRepository.findOne(codefaculte);
	}
	
	@RequestMapping(value = "/save",method=RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Faculte saveContact(@RequestBody Faculte c){
		return faculteRepository.save(c);
	}
	
	@RequestMapping(value = "/update/{ref}",method=RequestMethod.PUT)
	public Faculte updateContact(@RequestBody Faculte c,@PathVariable("ref") String codefaculte){
		c.setCodefaculte(codefaculte);
		return faculteRepository.saveAndFlush(c);
	}
	
	@RequestMapping(value = "/delete/{ref}", method = RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable("ref") String codefaculte){		
		faculteRepository.delete(codefaculte);
		return true;
	}
}
