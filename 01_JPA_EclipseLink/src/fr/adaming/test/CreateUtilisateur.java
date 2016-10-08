package fr.adaming.test;

import fr.adaming.entities.Utilisateur;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateUtilisateur {

    public static void main(String[] args) {

        //def de fabrique de l'entity manager a partir du PU
        EntityManagerFactory fabrique
                = Persistence.createEntityManagerFactory("PU_DB_TEST_JPA");

        //def l'entity manager 
        EntityManager entityManager = fabrique.createEntityManager();

        //recup d'une transaction 
        entityManager.getTransaction().begin();

        //def les utilisateurs a ajouter a la BDD
        Utilisateur user1 = new Utilisateur("MALANDRINO", "pier-jean", "mal@gmail.com", "123");
        Utilisateur user2 = new Utilisateur("BRISSON", "jimmy", "bri@gmail.com", "456");
        Utilisateur user3 = new Utilisateur("ROSTAGNAT", "philippe", "rost@gmail.com", "365");
        Utilisateur user4 = new Utilisateur("DESIGAUD", "thomas", "desi@gmail.com", "789");
        Utilisateur user5 = new Utilisateur("VIGNON", "fabien", "vignon@gmail.com", "589");
        Utilisateur user6 = new Utilisateur("ROPARS", "julien", "ropa@gmail.com", "654");

        //ajout des utilisateurs avec l'entity manager
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.persist(user4);
        entityManager.persist(user5);
        entityManager.persist(user6);

        //commit :  sauvegarde physique dans la bdd 
        entityManager.getTransaction().commit();

        //liberation de la ressources 
        entityManager.close();
        fabrique.close();

    }
}
