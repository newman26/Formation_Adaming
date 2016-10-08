package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.adaming.dao.AgentDAO;
import fr.adaming.dao.IAgentDAO;
import fr.adaming.dao.IUtilisateurDAO;
import fr.adaming.dao.UtilisateurDAO;
import fr.adaming.model.Utilisateur;
@ManagedBean(name="userMB")
@SessionScoped
public class UtilisateurManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Utilisateur user;
	
	private List<Utilisateur> listeUsers;
	
	
	
	
	
	
	
	IUtilisateurDAO userDao=new UtilisateurDAO();
	IAgentDAO agentDao=new AgentDAO();
	
	public UtilisateurManagedBean() {
		this.user=new Utilisateur();
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public List<Utilisateur> getListeUsers() {
		return listeUsers;
	}

	public void setListeUsers(List<Utilisateur> listeUsers) {
		this.listeUsers = listeUsers;
	}

	
	//Methodes Ajouter
	
	public String ajouterUser(){
		userDao.ajouterUserDao(user);
		return "accueil";
	} 
	
	
}
