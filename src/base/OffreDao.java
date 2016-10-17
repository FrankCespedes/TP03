package base;

import domaine.Client;
import domaine.Offre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;

/**
 * Module 634.1 - TP Série P03
 * 
 * Gestion des accès à la base de données pour l'entité Offre.
 *
 * @author VOTRE NOM
*/
public class OffreDao {
  
  /** Retourne la liste des offres, dans l'ordre des libellés. */
  public static ArrayList getListeOffres () {
    ArrayList listeO = new ArrayList();
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT*FROM offre ORDER BY Libelle");
            while(rs.next()){
                Offre o = new Offre (rs.getInt("IdOffre"),rs.getString("Libelle"),rs.getInt("Prix"),rs.getInt("MinInscrits"),rs.getInt("MaxInscrits"));
                listeO.add(o);
            }            
            stmt.close();        
        } 
        catch (SQLException e) {System.out.println("OffreDao.getListeOffres(): " + e.getMessage()); e.printStackTrace();}
        return listeO;
  } // getListeOffres

  /** Ajoute le client à l'offre. */
  public static void addClientOffre (Client client, Offre offre) {
    try{
        Connection con = ConnexionBase.get();
        PreparedStatement pstmt = con.prepareStatement("Insert into estInscrit (IdOffre,IdClient)Values(?,?)");
        pstmt.setInt(1, offre.getIdOffre());
        pstmt.setInt(2,client.getIdClient());
        pstmt.executeUpdate();
        pstmt.close();
    }
    catch (SQLException e) {System.out.println("OffreDao.addClientOffre(): " + e.getMessage()); e.printStackTrace();}
  } // addClientOffre  
  
} // OffreDao
