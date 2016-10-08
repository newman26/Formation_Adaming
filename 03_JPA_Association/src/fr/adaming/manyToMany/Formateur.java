package fr.adaming.manyToMany;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "formateur")
@Table(name = "formateurs")
public class Formateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formateur")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "sujet")
    private String sujet;

    /**
     * ASSOCIATION : Many to Many
     */
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
   //@JoinColumn(name = "classe_id", referencedColumnName = "id_classe")
    @JoinTable(name = "formateur_classe",
    joinColumns = @JoinColumn(name = "formateur_id"),//cote proprio
    inverseJoinColumns = @JoinColumn(name = "classe_id")//cote non proprio
)
    private Set<Classe> classes;

    public Set<Classe> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classe> classes) {
        this.classes = classes;
    }

    /**
     * ctors
     */
    public Formateur() {
    }

    public Formateur(String nom, String sujet) {
        this.nom = nom;
        this.sujet = sujet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

}
