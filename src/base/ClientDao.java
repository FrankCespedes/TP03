package base;

import domaine.Client;
import domaine.Offre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Module 634.1 - TP Série P03
 * 
 * Gestion des accès à la base de données pour l'entité Client.
 *
 * @author VOTRE NOM
*/
public class ClientDao {
  
  /** Retourne la liste des clients d'une offre, dans l'ordre des nom et prénom. */
  public static ArrayList getListeClients (Offre offre) {
    ArrayList listeC = new ArrayList();
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM client,estinscrit,offre where client.IdClient=estinscrit.IdClient and offre.IdOffre=estinscrit.IdOffre and offre.IdOffre ="+ offre.getIdOffre()+" order by Nom,Prenom");
            while(rs.next()){
                Client c = new Client (rs.getInt("IdClient"),rs.getString("Nom"),rs.getString("Prenom"),rs.getString("eMail"));
                listeC.add(c);
            }            
            stmt.close();        
        } 
        catch (SQLException e) {System.out.println("OffreDao.getListeOffres(): " + e.getMessage()); e.printStackTrace();}
        return listeC;
  } // getListeClients
  
  /** Insère le client dans la base de donnée; retourne l'identifiant qui lui a été attribué. 
      Retourne -1 en cas d'erreur. */
  public static int insertClient (Client client) {
    try{
        Connection con = ConnexionBase.get();
        PreparedStatement pstmt = con.prepareStatement("Insert into Client (Nom,Prenom,eMail) Values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, client.getNom());
        pstmt.setString(2, client.getPrenom());
        pstmt.setString(3, client.getEMail());
        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        pstmt.close();
        return id;
    }
    catch (SQLException e) {System.out.println("OffreDao.insertClient(): " + e.getMessage()); e.printStackTrace();}
    return -1;
  } // insertClient  

} // ClientDao
