/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.model.Utilisateur;
import fr.adaming.util.DbUtilitaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INTI0261
 */
public class UtilisateurDAO implements IUtilisateurDAO {

	private Connection connection;

	/**
	 *
	 * @return
	 */
	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		try {
			connection = DbUtilitaire.getConnection();
			String getAllReq = "SELECT * FROM utilisateurs";
			PreparedStatement getAllPs = connection.prepareStatement(getAllReq);
			ResultSet resultList = getAllPs.executeQuery();
			Utilisateur user = null;
			List<Utilisateur> userList = new ArrayList<>();
			while (resultList.next()) {
				user = new Utilisateur(resultList.getInt(1),
						resultList.getString(2), resultList.getString(3),
						resultList.getString(4), resultList.getString(5));
				userList.add(user);
			}
			return userList;

		} catch (SQLException ex) {
			Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,
					null, ex);
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur getUserByIdDao(int id_u) {
		try {
			connection = DbUtilitaire.getConnection();
			String getAllReq = "SELECT * FROM utilisateurs where id=?";
			PreparedStatement getAllPs = connection.prepareStatement(getAllReq);
			getAllPs.setInt(1, id_u);
			
			ResultSet resultList = getAllPs.executeQuery();
			
			resultList.next();
			Utilisateur user = new Utilisateur(resultList.getInt(1),
						resultList.getString(2), resultList.getString(3),
						resultList.getString(4), resultList.getString(5));
			
			return user;

		} catch (SQLException ex) {
			Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,
					null, ex);
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void ajouterUserDao(Utilisateur u) {
		try {
			connection = DbUtilitaire.getConnection();
			String ajoutReq = "insert into utilisateurs (nom,prenom,mail,password) values (?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(ajoutReq);

			ps.setString(1, u.getNom());
			ps.setString(2, u.getPrenom());
			ps.setString(3, u.getMail());
			ps.setString(4, u.getPassword());
			
			ps.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifierUserDao(Utilisateur u) {
		try {
			connection = DbUtilitaire.getConnection();
			String ajoutReq = "update utilisateurs set nom=?,prenom=?,mail=?,password=? where id=?";
			PreparedStatement ps = connection.prepareStatement(ajoutReq);

			ps.setString(1, u.getNom());
			ps.setString(2, u.getPrenom());
			ps.setString(3, u.getMail());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getId());
			ps.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void supprimerUserDao(int id_u) {
		try {
			connection = DbUtilitaire.getConnection();
			String ajoutReq = "delete from utilisateurs where id=?";
			PreparedStatement ps = connection.prepareStatement(ajoutReq);

			ps.setInt(1, id_u);

			ps.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
