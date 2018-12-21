package sn.ucad;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sn.ucad.dao.ClasseRepository;
import sn.ucad.dao.DepartementRepository;
import sn.ucad.dao.ECRepository;
import sn.ucad.dao.EtudiantRepository;
import sn.ucad.dao.EvaluationRepository;
import sn.ucad.dao.FaculteRepository;
import sn.ucad.dao.NoteRepository;
import sn.ucad.dao.PromotionRepository;
import sn.ucad.entites.Classe;
import sn.ucad.entites.Departement;
import sn.ucad.entites.Ec;
import sn.ucad.entites.Etudiant;
import sn.ucad.entites.Evaluation;
import sn.ucad.entites.Faculte;
import sn.ucad.entites.Note;
import sn.ucad.entites.Promotion;

@SpringBootApplication
public class TpsoaApplication implements CommandLineRunner {

	@Autowired
	private FaculteRepository faculteRepository;
	@Autowired
	private ClasseRepository classeRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private DepartementRepository departementRepository;
	@Autowired
	private ECRepository ecRepository;
	@Autowired
	private EvaluationRepository evaluationRepository;

	@Autowired
	private NoteRepository noteRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpsoaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Faculte fac = faculteRepository.save(new Faculte("CODE1", "FST"));
		// faculteRepository.save(new Faculte("CODE7","FST"));
		faculteRepository.save(new Faculte("CODE2", "FMPO"));
		faculteRepository.save(new Faculte("CODE3", "SES"));
		faculteRepository.save(new Faculte("CODE4", "FSHLM"));
		faculteRepository.save(new Faculte("CODE5", "FASEG"));
		faculteRepository.save(new Faculte("CODE6", "FSPJ"));
		Departement departement = departementRepository.save(new Departement("DEP01", fac, "ANGLAIS"));
		departementRepository.save(new Departement("DEP02", fac, "MATH-INFO"));
		departementRepository.save(new Departement("DEP03", fac, "PHYSIQUE"));
		departementRepository.save(new Departement("DEP04", fac, "MEDECINE"));
		Classe classe = classeRepository.save(new Classe("CLASSE1", departement, "PC", 10));
		classeRepository.save(new Classe("CLASSE2", departement, "MP", 10));
		classeRepository.save(new Classe("CLASSE3", departement, "LICENSE 1", 10));
		classeRepository.save(new Classe("CLASSE4", departement, "LICENSE 2", 10));
		classeRepository.save(new Classe("CLASSE5", departement, "LICENSE 3", 10));
		classeRepository.save(new Classe("CLASSE6", departement, "MASTER 1", 10));
		classeRepository.save(new Classe("CLASSE7", departement, "MASTER 2", 10));
		Promotion promotion = promotionRepository.save(new Promotion("2018", classe));
		Promotion promotion1 = promotionRepository
				.save(new Promotion("2018", new Classe("CLASSE2", departement, "MP", 10)));
		Promotion promotion2 = promotionRepository
				.save(new Promotion("2017", new Classe("CLASSE3", departement, "LICENSE 1", 10)));
		etudiantRepository.save(new Etudiant("2221", promotion, "mamadou", "SECK", "seck@gmail.com"));
		etudiantRepository.save(new Etudiant("2222", promotion, "Saliou", "NDAO", "ndao@gmail.com"));
		etudiantRepository.save(new Etudiant("2223", promotion, "mamadou", "KIND", "kind@gmail.com"));
		etudiantRepository.save(new Etudiant("2224", promotion, "mamadou", "SAKINE", "sakine@gmail.com"));
		etudiantRepository.save(new Etudiant("2225", promotion2, "Salimata", "SARR", "sarr@gmail.com"));
		etudiantRepository.save(new Etudiant("2226", promotion, "mamadou", "KHABANE", "khabane@gmail.com"));

		ecRepository.save(new Ec("base de donnes", promotion, "BD"));
		ecRepository.save(new Ec("Algo", promotion, "progammation"));
		ecRepository.save(new Ec("BI", promotion, "BDe"));

		evaluationRepository.save(new Evaluation("eval1", ecRepository.getOne("base de donnes"), "bd", new Date()));
		evaluationRepository.save(new Evaluation("eval2", ecRepository.getOne("Algo"), "alg", new Date()));

		noteRepository.save(new Note("note123", etudiantRepository.findOne("2221"),
				evaluationRepository.findOne("eval1"), 10));
		noteRepository.save(new Note("note12", etudiantRepository.findOne("2221"),
				evaluationRepository.findOne("eval2"), 13));
		noteRepository.save(new Note("note1", etudiantRepository.findOne("2222"),
				evaluationRepository.findOne("eval1"), 11));
		noteRepository.save(new Note("note2", etudiantRepository.findOne("2222"),
				evaluationRepository.findOne("eval2"), 12));
		
		//System.out.println(evaluationRepository.findOne("eval1").getCodeevaluation());
	}
}
