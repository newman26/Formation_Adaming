package fr.adaming.manyToOne;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "client")
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    private int id;

    @Column(name = "nom", length = 50)//length = 50 : VARCHAR(50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @Column(name = "etat_client", length = 50)
    private String etatClient; //debiteur ...

    /*===============================================================*/
    /*======== ASSOCIATION: one client to Many commandes ============*/
    /*================================================================*/
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Commande> commandes;

    /**
     * ctor
     */
    public Client() {
    }

    public Client(String nom, String prenom, String etatClient) {
        this.nom = nom;
        this.prenom = prenom;
        this.etatClient = etatClient;
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
     * @return the etatClient
     */
    public String getEtatClient() {
        return etatClient;
    }

    /**
     * @param etatClient the etatClient to set
     */
    public void setEtatClient(String etatClient) {
        this.etatClient = etatClient;
    }

    /**
     * @return the commandes
     */
    public Collection<Commande> getCommandes() {
        return commandes;
    }

    /**
     * @param commandes the commandes to set
     */
    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

}
