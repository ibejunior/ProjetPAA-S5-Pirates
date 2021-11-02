import java.util.ArrayList;

public class Pirate {
	private String nom;
	private ArrayList<Objet> prefs;
	private Objet butin;
	
	public Pirate(String nom) {
		this.nom = nom;
		butin = null;
		prefs = null;
	}
	
	public String getNom() {
		return(nom);
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void initPrefs(int n) {
		prefs = new ArrayList<Objet>(n);
	}
	
	public ArrayList<Objet> getPrefs() {
		return(prefs);
	}
	
	public void setObjet(Objet obj) {
		this.butin = obj;
	}
	
	public Objet getObjet() {
		return(this.butin);
	}
	public String toString() {
		return this.nom;
	}
}
