package metier;

import base.ClientDao;
import base.OffreDao;
import domaine.Client;
import domaine.Offre;

/**
 * Module 634.1 - TP Série P03
 * 
 * Liste de clients (dans l'ordre des nom et prénom) s'étant inscrits à une offre
 *
 * @author VOTRE NOM
 */
public class ListeClients extends ListeObjects {
  
  private Offre offre;

  /** Constructeur */
  public ListeClients (Offre offre) {this.offre = offre; liste = ClientDao.getListeClients(offre);}

  /** Retourne le client courant, null si la position courante est NO_POS */
  public Client getCourant () {return (Client)super.getCourant();}

  /** Retourne le client d'indice k, null si k n'est pas correctement défini */
  public Client get (int k) {return (Client)super.get(k);}
  
  /* Trie*/
  public int insertTri(Client client){
       int pos = 0;
       while ((pos < liste.size()) && (((Client)liste.get(pos)).compareTo(client) >= 0)) {
           pos++;
       }
       return pos;
  }
  
  /** Ajoute un client (dans l'ordre des nom et prénom) à cette liste */
  public void addClient (Client client) {
    liste.add(insertTri(client),client);
    client.setIdClient(ClientDao.insertClient(client));
    OffreDao.addClientOffre(client, offre);
  } // addClient

} // ListeClients
