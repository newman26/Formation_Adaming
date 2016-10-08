package fr.adaming.manyToMany;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppTest {

    public static void main(String[] args) {

        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("PU_ASSOCIATIONS");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        //classe 
        Classe salle1 = new Classe("1ere");
        Classe salle2 = new Classe("2eme");
        Classe salle3 = new Classe("3eme");

        //ajout des classes
        em.persist(salle1);
        em.persist(salle2);
        em.persist(salle1);

        //ensembles des classes 
        Set<Classe> ensemble1 = new HashSet<>();
        ensemble1.add(salle3);
        ensemble1.add(salle2);
        ensemble1.add(salle1);

        Set<Classe> ensemble2 = new HashSet<>();
        ensemble2.add(salle1);
        ensemble2.add(salle2);
        ensemble2.add(salle3);

        Set<Classe> ensemble3 = new HashSet<>();
        ensemble1.add(salle2);
        ensemble1.add(salle3);
        ensemble1.add(salle1);

        //formateurs 
        Formateur formateur1 = new Formateur("françois", "COBOL");
        formateur1.setClasses(ensemble3);

        Formateur formateur2 = new Formateur("marie-pierre", "MAIN-FRAME");
        formateur2.setClasses(ensemble1);

        Formateur formateur3 = new Formateur("laurent", "JAVAEE");
        formateur3.setClasses(ensemble2);

        //ajout des formateurs 
        em.persist(formateur1);
        em.persist(formateur2);
        em.persist(formateur3);

        em.getTransaction().commit();

        em.close();
        factory.close();

    }
}
