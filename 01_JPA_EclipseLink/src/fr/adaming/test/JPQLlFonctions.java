package fr.adaming.test;

import fr.adaming.entities.Utilisateur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPQLlFonctions {

    public static void main(String[] args) {

        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("PU_DB_TEST_JPA");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        //BETWEEN avec une requete dynamique  
        String betJpqlReq = "SELECT u FROM utilisateur u WHERE u.id BETWEEN 1 AND 3";
        Query requeteBet = entityManager.createQuery(betJpqlReq);
        List<Utilisateur> users = requeteBet.getResultList();
        System.out.println("=================== BETWEEN ===============");
        for (Utilisateur user : users) {
            System.out.println(user);
        }

        System.out.println("============ LIKE ==================");
        String likeJpqlReq = "SELECT u FROM utilisateur u WHERE u.nom LIKE 'm%'";
        Query requetelike = entityManager.createQuery(likeJpqlReq);
        List<Utilisateur> liste = requetelike.getResultList();
        for (Utilisateur user : liste) {
            System.out.println(user);
        }

        System.out.println("============ COUNT ==================");
        String countReq = "SELECT COUNT(u.id) FROM utilisateur u ";
        Query reqCount = entityManager.createQuery(countReq);
        long nombreUsers = (long) reqCount.getSingleResult();
        System.out.println("nombre d'utilisateurs ====> :" + nombreUsers);
    }
}
