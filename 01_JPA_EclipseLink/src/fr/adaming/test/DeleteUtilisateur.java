package fr.adaming.test;

import fr.adaming.entities.Utilisateur;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author INTI0261
 */
public class DeleteUtilisateur {

    public static void main(String[] args) {

        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("PU_DB_TEST_JPA");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Utilisateur user = entityManager.find(Utilisateur.class, 6);

        entityManager.remove(user);

        entityManager.getTransaction().commit();

        System.out.println("==== delete OK !!! ");

        entityManager.close();
        factory.close();
    }
}
