package sn.ucad.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sn.ucad.dao.ECRepository;
import sn.ucad.entites.Ec;

@RestController
public class ECRest {
	@Autowired
	private ECRepository ecRepository;
	
	@RequestMapping(value = "/listEC",method=RequestMethod.GET)
	public List<Ec> listContacts(){
		return ecRepository.findAll();
		
	}
	
	@RequestMapping(value = "/ec/{ref}",method=RequestMethod.GET)
	public Ec getContactByRef(@PathVariable("ref")String ref){
		return ecRepository.findOne(ref);
	}
	@RequestMapping(value = "/saveEC",method=RequestMethod.POST)
	public Ec saveContact(@RequestBody Ec c){
		return ecRepository.save(c);
	}
	@RequestMapping(value = "/editEC",method=RequestMethod.PUT)
	public Ec updateContact(@RequestBody Ec c){
		return ecRepository.saveAndFlush(c);
	}
	@RequestMapping(value = "/deleteEC/{ref}", method = RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable("ref") String id){		
		ecRepository.delete(id);
		return true;
	}
}
