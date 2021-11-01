import java.util.ArrayList;

public class Pirate {
	private String nom;
	private ArrayList<Objet> prefs;
	
	public Pirate(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return(nom);
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void initPref(int n) {
		prefs = new ArrayList<Objet>(n);
	}
	
	public ArrayList<Objet> getPrefs() {
		return(prefs);
	}
}
