package fr.adaming.onteToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author INTI0261
 */
public class AppTest {

    public static void main(String[] args) {

        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("PU_ASSOCIATIONS");

        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        //adresse 
        Adresse adresse1 = new Adresse("rue benoit frachon", "44000", "St herblain", "france");
        //ajout de l'adresse 
        em.persist(adresse1);

        //Personne 
        Personne pax = new Personne("borez", "fabien");
        //assoc de l'adresse a la personne 
        pax.setAdresse(adresse1);
        //ajout de la personne 
        em.persist(pax);

        //commit 
        em.getTransaction().commit();

        em.close();
        factory.close();

    }
}
