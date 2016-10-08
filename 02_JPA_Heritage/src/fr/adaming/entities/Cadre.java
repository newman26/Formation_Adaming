package fr.adaming.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue( value="CD" )
public class Cadre extends Employee{

	private String responsabilite;

	/**
	 * 
	 */
	public Cadre() {
		super();
	}
	
	

	



	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param responsabilite
	 */
	public Cadre(int id, String nom, String prenom, String responsabilite) {
		super(id, nom, prenom);
		this.responsabilite = responsabilite;
	}




	/**
	 * @param nom
	 * @param prenom
	 * @param responsabilite
	 */
	public Cadre(String nom, String prenom, String responsabilite) {
		super(nom, prenom);
		this.responsabilite = responsabilite;
	}







	/**
	 * @return the responsabilite
	 */
	public String getResponsabilite() {
		return responsabilite;
	}

	/**
	 * @param responsabilite the responsabilite to set
	 */
	public void setResponsabilite(String responsabilite) {
		this.responsabilite = responsabilite;
	}
	
	
	
}
