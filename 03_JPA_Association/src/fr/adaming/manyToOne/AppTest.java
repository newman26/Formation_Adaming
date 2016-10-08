package fr.adaming.manyToOne;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppTest {

    public static void main(String[] args) {

        //fabrique 
        EntityManagerFactory emFactory
                = Persistence.createEntityManagerFactory("PU_ASSOCIATIONS");
        //em
        EntityManager em = emFactory.createEntityManager();

        //transaction 
        EntityTransaction transaction = em.getTransaction();

        //ouverture d'une tx 
        transaction.begin();

        //def des commandes
        Commande cmd1 = new Commande(new Date(), 20000);
        Commande cmd2 = new Commande(new Date(), 30000);
        Commande cmd3 = new Commande(new Date(), 45000);
        Commande cmd4 = new Commande(new Date(), 50000);
        Commande cmd5 = new Commande(new Date(), 60000);

        Commande cmd6 = new Commande(new Date(), 40000);

       

        //client 
        Client client1 = new Client("dupond", "michel", "debiteur");
        Client client2 = new Client("nomane", "boulmerdj", "debiteur");
        cmd1.setClient(client1);
        cmd2.setClient(client2);
        cmd3.setClient(client1);
        cmd4.setClient(client1);
        cmd5.setClient(client1);
        cmd6.setClient(client2);
        
        
        //liste de commandes
//        ArrayList<Commande> listeCommandes1 = new ArrayList<>();
//        ArrayList<Commande> listeCommandes2 = new ArrayList<>();
//        listeCommandes1.add(cmd1);
//        listeCommandes2.add(cmd2);
//        listeCommandes1.add(cmd3);
//        listeCommandes1.add(cmd4);
//        listeCommandes1.add(cmd5);
//        listeCommandes2.add(cmd6);
        //association des commandes au client
//        client1.setCommandes(listeCommandes1);
//        client2.setCommandes(listeCommandes2);
        
        //Ajout des commandes 
        em.persist(cmd1);
        em.persist(cmd2);
        em.persist(cmd3);
        em.persist(cmd4);
        em.persist(cmd5);
        em.persist(cmd6);
      
        //ajout du client 
        em.persist(client1);
        em.persist(client2);
       

        //commit
        em.getTransaction().commit();

        //fermeture de la factory et de em
        em.close();
        emFactory.close();
    }
}
