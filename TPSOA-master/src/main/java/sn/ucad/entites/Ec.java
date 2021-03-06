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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Ec generated by hbm2java
 */
@Entity
@Table(name = "ec", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "libelle_matiere"))
public class Ec implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "codematiere", unique = true, nullable = false, length = 254)
	private String codematiere;
	//@JsonBackReference(value="1")
	//@JsonIgnoreProperties
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "annee", nullable = true)
	@JsonIgnore
	private Promotion promotion;
	@Column(name = "libelle_matiere", unique = true, length = 254)
	private String libelleMatiere;
	//@JsonManagedReference
	//@JsonIgnoreProperties
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ec")
	private Set<Evaluation> evaluations = new HashSet<Evaluation>(0);

	public Ec() {
	}

	public Ec(String codematiere, Promotion promotion) {
		this.codematiere = codematiere;
		this.promotion = promotion;
	}

	public Ec(String codematiere, Promotion promotion, String libelleMatiere, Set<Evaluation> evaluations) {
		this.codematiere = codematiere;
		this.promotion = promotion;
		this.libelleMatiere = libelleMatiere;
		this.evaluations = evaluations;
	}
	
	

	
	public Ec(String codematiere, Promotion promotion, String libelleMatiere) {
		super();
		this.codematiere = codematiere;
		this.promotion = promotion;
		this.libelleMatiere = libelleMatiere;
	}

	public String getCodematiere() {
		return this.codematiere;
	}

	public void setCodematiere(String codematiere) {
		this.codematiere = codematiere;
	}
	
	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	
	public String getLibelleMatiere() {
		return this.libelleMatiere;
	}

	public void setLibelleMatiere(String libelleMatiere) {
		this.libelleMatiere = libelleMatiere;
	}
	
	public Set<Evaluation> getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

}
