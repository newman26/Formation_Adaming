/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.test;

import fr.adaming.entities.Utilisateur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * requete statique
 *
 * @author INTI0261
 */
public class NamedQuery {

    public static void main(String[] args) {

        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("PU_DB_TEST_JPA");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        //def une requete 
        Query requete = entityManager.createNamedQuery("getAllUsers");
        
        //execution de la requete et recup du resultat
        List<Utilisateur> userList = requete.getResultList();
        
        System.out.println("====================================");
        System.out.println("Liste des utilisateurs :");
        for (Utilisateur user : userList) {
            System.out.println("\t- " + user.getNom());
        }
        System.out.println("====================================");

        System.out.println("Utilisateur par id : ");
        //def de la requete 
        Query requeteById = entityManager.createNamedQuery("getUserById");
        
        //passage de param a la requete 
        requeteById.setParameter("id", 1);
        
        //execution de la requete 
        List<Utilisateur> users = requeteById.getResultList();
        for (Utilisateur user : users) {
            System.out.println(user);
        }

    }
}
