package sn.ucad.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sn.ucad.dao.PromotionRepository;
import sn.ucad.entites.Etudiant;
import sn.ucad.entites.Promotion;

@CrossOrigin(origins="*")
@RestController
public class PromotionRest {

	@Autowired
	private PromotionRepository promotionRepository;
	
	@RequestMapping(value = "/listPromotion",method=RequestMethod.GET)
	public List<Promotion> listContact(){
		return promotionRepository.findAll();
	}
	
	@RequestMapping(value = "/savePromotion",method=RequestMethod.POST)
	public Promotion saveContact(@RequestBody Promotion c){
		return promotionRepository.save(c);
	}
	

	
	@RequestMapping(value = "/editPromotion",method=RequestMethod.PUT)
	public Promotion updateContact(@RequestBody Promotion c){
		return promotionRepository.saveAndFlush(c);
	}
	
	@RequestMapping(value = "/deletePromotion/{ref}", method = RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable("ref") String id){		
		promotionRepository.delete(id);
		return true;
	}
}
