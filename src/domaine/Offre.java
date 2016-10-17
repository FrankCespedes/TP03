package domaine;

/**
 * Module 634.1 - TP Série P03
 * 
 * Modélisation d'une offre
 *
 * @author VOTRE NOM
 */
public class Offre {

  private int idOffre;     /* Numéro de l'offre: identifiant */
  private String libelle;  /* Libellé de l'offre */
  private int prix;        /* Prix en francs */
  private int minInscrits; /* Nombre minimum d'inscrits pour que l'offre soit validée */
  private int maxInscrits; /* Nombre maximum d'inscrits */

  /** Constructeur */
  public Offre (int idOffre, String libelle, int prix, int minInscrits, int maxInscrits) {
    this.idOffre = idOffre;
    this.libelle = libelle; this.prix = prix; 
    this.minInscrits = minInscrits; this.maxInscrits = maxInscrits;
  } // Constructeur

  /** Accesseurs */
  public int getIdOffre () {return idOffre;}
  public String getLibelle () {return libelle;}
  public int getPrix () {return prix;}
  public int getMinInscrits () {return minInscrits;}
  public int getMaxInscrits () {return maxInscrits;}

  public boolean equals (Object obj) {return ((Offre)obj).idOffre == idOffre;}

    @Override
    public String toString() {
        return libelle;
    }
  
  /**** À COMPLÉTER SI NÉCESSAIRE ****/
  
  
} // Offre
