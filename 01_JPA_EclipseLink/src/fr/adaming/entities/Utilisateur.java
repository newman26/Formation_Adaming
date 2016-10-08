package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity(name = "user")
@Table(name = "utilisateurs")
//JPQL
@NamedQueries({
  @NamedQuery(name = "getAllUsers",
          query = "SELECT u FROM user u"),
  @NamedQuery(name = "getUserById",
          query = "SELECT u FROM user u WHERE u.id = :id")
})
public class Utilisateur implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

@Transient
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String mail;

    @Column(name = "password")
    private String motDePasse;

    public Utilisateur() {
    }

    public Utilisateur(int id, String nom, String prenom, String mail, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.motDePasse = motDePasse;
    }

    public Utilisateur(String nom, String prenom, String mail, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.motDePasse = motDePasse;
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

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the motDePasse
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * @param motDePasse the motDePasse to set
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id = " + id + ", nom = " + nom + ", prenom = " + prenom + ", mail = " + mail + ", motDePasse = " + motDePasse + '}';
    }

}
