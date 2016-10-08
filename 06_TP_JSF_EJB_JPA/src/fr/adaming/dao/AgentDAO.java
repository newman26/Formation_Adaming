package fr.adaming.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.adaming.util.DbUtilitaire;

public class AgentDAO implements IAgentDAO{
	
	 private Connection connection;
	/**
    *
    * @param login
    * @param mdp
    * @return
    */
   @Override
   public int isExist(String login, String mdp) {

       PreparedStatement ps = null;

       try {
           connection = DbUtilitaire.getConnection();

           //verif de l'existence de l'utilisateur
           String existReq = "SELECT COUNT(id) "
                   + " FROM agents "
                   + " WHERE mail=? AND password=?";
           ps = connection.prepareStatement(existReq);
           ps.setString(1, login);
           ps.setString(2, mdp);

           ResultSet result = ps.executeQuery();
           result.next();

//           ps.close();
//           connection.close();
           
       System.out.println("resultatDao :"+result.getInt(1));   
           return result.getInt(1);

       } catch (SQLException ex) {
           System.out.println("je suis dans l'exception : " );
           ex.printStackTrace();
       } finally {
  //         try {
//              
//               if (connection != null) {
//                   connection.close();
//                   if (ps != null) {
//                       ps.close();
//                   }
//               }
//           } catch (SQLException ex) {
//               Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
//
//           }

       }
       return 0;
   }
}
