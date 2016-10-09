package fr.adaming.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Agent;


@Stateless
public class AgentDAO implements IAgentDAO{

	@PersistenceContext(unitName="PU")
	EntityManager em;
	
	

	@Override
	public int isExist(String mail, String mdp) {
		System.out.println("--------------------------je suis dans la couche dao\n");
//		String req="SELECT COUNT(a.id) "
//                + " FROM agents a"
//                + " WHERE a.mail="+mail;
//		Query query=em.createNativeQuery(req,Agent.class);
		Agent a=null;
		
	a=(Agent) em.find(Agent.class, 1);
		System.out.println(a);
		if (a!=null){
			System.out.println("______________________________ on a trouvé un utilisateur____________________");
			return 1;
			
		}else{
			System.out.println("\n______________________________ on n'a pas trouvé un utilisateur____________________");
			return 0;
		}
	}
	
	
}
