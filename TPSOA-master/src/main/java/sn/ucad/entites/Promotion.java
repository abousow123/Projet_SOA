package sn.ucad.entites;
// Generated 16 avr. 2018 11:31:36 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Promotion generated by hbm2java
 */
@Entity
@Table(name = "promotion", schema = "public")
public class Promotion implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "annee", unique = true, nullable = false, length = 254)
	private String annee;
	//@JsonBackReference(value="8")
	//@JsonIgnoreProperties
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codeclasse", nullable = true)
	@JsonIgnore
	private Classe classe;
	//@JsonManagedReference
	//@JsonIgnoreProperties
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion")
	private Set<Etudiant> etudiants = new HashSet<Etudiant>(0);
	//@JsonManagedReference
	//@JsonIgnoreProperties
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion")
	private Set<Ec> ecs = new HashSet<Ec>(0);

	public Promotion() {
	}

	public Promotion(String annee, Classe classe) {
		this.annee = annee;
		this.classe = classe;
	}

	public Promotion(String annee, Classe classe, Set<Etudiant> etudiants, Set<Ec> ecs) {
		this.annee = annee;
		this.classe = classe;
		this.etudiants = etudiants;
		this.ecs = ecs;
	}

	public String getAnnee() {
		return this.annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}
	
	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	public Set<Etudiant> getEtudiants() {
		return this.etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	public Set<Ec> getEcs() {
		return this.ecs;
	}

	public void setEcs(Set<Ec> ecs) {
		this.ecs = ecs;
	}

}
