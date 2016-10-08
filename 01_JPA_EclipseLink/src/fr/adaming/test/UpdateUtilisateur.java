package fr.adaming.test;

import fr.adaming.entities.Utilisateur;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateUtilisateur {

    public static void main(String[] args) {

        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("PU_DB_TEST_JPA");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Utilisateur user = entityManager.find(Utilisateur.class, 1);

        //MAJ de user 
        System.out.println("user before update ==== " + user);
        user.setMail("malandrino@hotmail.com");

        entityManager.persist(user);

        entityManager.getTransaction().commit();

        System.out.println("user after update ==== " + user);

        entityManager.close();
        factory.close();

    }
}
