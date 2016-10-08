package fr.adaming.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.adaming.entities.Cadre;

public class ClassTest {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("PU_ASSOCIATIONS");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		
		//Employees
		//Employee employee1=new Employee("BOULMERDJ", "Nomane");
		//Employee employee2=new Employee("fhghff", "fgfjfjf");
	//Cadres
		Cadre cd1=new Cadre("DUPOIT", "JEAN", "Gerant");
		
		//em.persist(employee1);
		//em.persist(employee2);
	em.persist(cd1);
	
	em.getTransaction().commit();
	em.close();
	factory.close();

	}

}
