package fr.adaming.manyToOne;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "commande")
@Table(name = "commandes")
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande", nullable = false)
    private int id;

    @Column(name = "date_commande", length = 50)
    @Temporal(TemporalType.DATE)
    private Date dateCommande;

    @Column(name = "total_commande")
    private double totalCommande;

    /*===============================================================*/
    /*======== ASSOCIATION : Many commandes to one Client ============*/
    /*==============================================================*/
    @ManyToOne
    @JoinColumn(name = "client_id",
            referencedColumnName = "id_client")
    private Client client;

    /**
     * ctors
     */
    public Commande() {
    }

    public Commande(int id, Date dateCommande, double totalCommande) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.totalCommande = totalCommande;
    }

    public Commande(Date dateCommande, double totalCommande) {
        this.dateCommande = dateCommande;
        this.totalCommande = totalCommande;
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
     * @return the dateCommande
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     * @param dateCommande the dateCommande to set
     */
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    /**
     * @return the totalCommande
     */
    public double getTotalCommande() {
        return totalCommande;
    }

    /**
     * @param totalCommande the totalCommande to set
     */
    public void setTotalCommande(double totalCommande) {
        this.totalCommande = totalCommande;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

}
