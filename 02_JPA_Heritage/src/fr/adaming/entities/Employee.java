package fr.adaming.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

//@Entity
//@Table
//@Inheritance( strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn( name = "fonction" )
//@DiscriminatorValue( value="Emp")
@MappedSuperclass
public abstract class Employee {
	
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY )
private int id;


private String nom;
private String prenom;
/**
 * 
 */
public Employee() {
	super();
}


/**
 * @param id
 * @param nom
 * @param prenom
 */
public Employee(int id, String nom, String prenom) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
}


/**
 * @param nom
 * @param prenom
 */
public Employee(String nom, String prenom) {
	super();
	this.nom = nom;
	this.prenom = prenom;
}



/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the nom
 */
public String getNom() {
	return nom;
}
/**
 * @param nom the nom to set
 */
public void setNom(String nom) {
	this.nom = nom;
}
/**
 * @return the prenom
 */
public String getPrenom() {
	return prenom;
}
/**
 * @param prenom the prenom to set
 */
public void setPrenom(String prenom) {
	this.prenom = prenom;
}




}
