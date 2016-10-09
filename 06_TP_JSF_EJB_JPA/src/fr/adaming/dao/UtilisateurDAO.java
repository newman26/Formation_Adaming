/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.model.Utilisateur;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;

/**
 *
 * @author INTI0261
 */
@Stateless
@Local(fr.adaming.dao.IUtilisateurDAO.class)
public class UtilisateurDAO implements IUtilisateurDAO {

	@PersistenceContext(unitName="PU")
	private EntityManager em;
	
	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		String req="select c from Utilisateur c";
		
		Query query=em.createQuery(req);
		
		List<Utilisateur> liste=query.getResultList();
		return liste;
	}

	@Override
	public Utilisateur getUserByIdDao(int id_u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterUserDao(Utilisateur u) {
		System.out.println(u);
		System.out.println(em);
		em.persist(u);
		
	}

	@Override
	public void modifierUserDao(Utilisateur u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerUserDao(int id_u) {
		// TODO Auto-generated method stub
		
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	
}
