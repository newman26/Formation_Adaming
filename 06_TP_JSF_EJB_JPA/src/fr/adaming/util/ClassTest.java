package fr.adaming.util;

import fr.adaming.dao.IUtilisateurDAO;
import fr.adaming.dao.UtilisateurDAO;
import fr.adaming.model.Utilisateur;

public class ClassTest {

	public static void main(String[] args) {
Utilisateur u=new Utilisateur("sNom","sPrenom","sMail","sMdp");
		
		// instancier un objet  de type UtilisateurDaoImpl pour pouvoir appeler ses methodes 
		IUtilisateurDAO userDao=new UtilisateurDAO();
		
		
		// appeler la methode ajouterUserDao de userDao 
		userDao.ajouterUserDao(u);
		

	}

}
