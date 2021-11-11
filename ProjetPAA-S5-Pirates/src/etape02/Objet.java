package etape02;
/**
 * 
 * Classe qui permet de d�finir un objet Objet 
 * 
 * @author El-Mougharti Hanafi
 * @author Vall�e Arthur
 * @author Stefanos Alexandre
 *
 *
 */
public class Objet {
	private String nom;
	
	/**
	 * Constructeur de la classe Objet
	 * 
	 * @param nom	le nom de l'Objet d�fini
	 */
	public Objet(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Getter du nom de cet Objet
	 * 
	 * @return le nom de cet Objet
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Setter du nom de cet Objet
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
}
