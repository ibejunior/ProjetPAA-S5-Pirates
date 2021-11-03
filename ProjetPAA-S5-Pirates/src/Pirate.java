import java.util.ArrayList;


/**
 * 
 * Classe qui permet de d�finir un objet Pirate
 * 
 * @author El-Mougharti Hanafi
 * @author Vall�e Arthur
 * @author Stefanos Alexandre
 *
 */
public class Pirate {
	private String nom;
	private ArrayList<Objet> prefs;
	private Objet butin;
	
	/**
	 * Constructeur de la classe Pirate
	 * 
	 * @param nom	le nom du Pirate d�fini
	 */
	public Pirate(String nom) {
		this.nom = nom;
		butin = null;
		prefs = null;
	}
	
	/**
	 * 
	 * Getter du nom de ce Pirate
	 * 
	 * @return le nom de ce Pirate
	 */
	public String getNom() {
		return(nom);
	}
	
	/**
	 * Setter du nom de ce Pirate
	 * 
	 * @param nom 	le nom de ce Pirate
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Permet d'initialiser la liste des pr�f�rences de ce Pirate
	 * 
	 * @param n		la taille de liste des pr�f�rences de ce Pirate
	 */
	public void initPrefs(int n) {
		prefs = new ArrayList<Objet>(n);
	}
	
	/**
	 * Getter de la liste de pr�f�rences de ce Pirate
	 * 
	 * @return la liste de pr�f�rences de ce Pirate
	 */
	public ArrayList<Objet> getPrefs() {
		return(prefs);
	}
	
	/**
	 * Setter de l'Objet donn� � ce Pirate
	 * 
	 * @param obj	l'Objet de ce Pirate
	 */
	public void setObjet(Objet obj) {
		this.butin = obj;
	}
	
	/**
	 * Getter de l'Objet donn� � ce Pirate
	 * 
	 * @return le butin de ce Pirate
	 */
	public Objet getObjet() {
		return(this.butin);
	}
}
