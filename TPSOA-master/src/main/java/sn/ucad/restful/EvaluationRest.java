package sn.ucad.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sn.ucad.dao.EvaluationRepository;
import sn.ucad.entites.Evaluation;


@CrossOrigin(origins="*")
@RestController
public class EvaluationRest {

	@Autowired
	private EvaluationRepository evaluationRepository;
	
	@RequestMapping(value = "/listEvaluation",method=RequestMethod.GET)
	public List<Evaluation> listContacts(){
		return evaluationRepository.findAll();
	}
	
	
	@RequestMapping(value = "evaluation/{ref}",method=RequestMethod.GET)
	public Evaluation getContactByRef(@PathVariable("ref")String codeeval){
		return evaluationRepository.findOne(codeeval) ;
	}
	
	@RequestMapping(value = "/saveEvaluation",method=RequestMethod.POST)
	public Evaluation saveContact(@RequestBody Evaluation c){
		return evaluationRepository.save(c);
	}
	
	@RequestMapping(value = "/editEvaluation",method=RequestMethod.PUT)
	public Evaluation updateContact(@RequestBody Evaluation c){
		return evaluationRepository.saveAndFlush(c);
	}
	
	@RequestMapping(value = "/deleteEvaluation/{ref}", method = RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable("ref") String id){		
		evaluationRepository.delete(id);
		return true;
	}
}
