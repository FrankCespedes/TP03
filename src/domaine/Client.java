package domaine;

/**
 * Module 634.1 - TP Série P03
 * 
 * Modélisation d'un client
 *
 * @author VOTRE NOM
 */
public class Client implements Comparable {

  private int idClient;  /* Numéro du client: identifiant */
  private String nom;    /* Nom */
  private String prenom; /* Prénom */
  private String eMail;  /* Adresse e-mail */

  /** Constructeurs */
  public Client (int idClient, String nom, String prenom, String eMail) {
    this(nom, prenom, eMail);
    this.idClient = idClient;
  } // Constructeur

  public Client (String nom, String prenom, String eMail) {
    this.nom = nom; this.prenom = prenom; this.eMail = eMail;
  } // Constructeur

  public void setIdClient(int idClient) {
        this.idClient = idClient;
  }

  /** Accesseurs */
  public int getIdClient () {return idClient;}
  public String getNom () {return nom;}
  public String getPrenom () {return prenom;}
  public String getEMail () {return eMail;}

  public boolean equals (Object obj) {return ((Client)obj).idClient == idClient;}
  
  /**** À COMPLÉTER SI NÉCESSAIRE ****/
  @Override
  public String toString () {
    return  nom + " "  + prenom + " [" + eMail + ']';
  }

    /*** Interface Comparable ***/
    /** L'ordre défini par cette méthode est indépendant de la casse */
    public int compareTo(Object obj) {
        Client c = (Client)obj;
        int res = c.nom.toUpperCase().compareTo(nom.toUpperCase());
        if (res != 0) {return res;}
            res = c.prenom.toUpperCase().compareTo(prenom.toUpperCase());
        if (res != 0) {return res;}
        return 0;
    } // compareTo
} // Client
