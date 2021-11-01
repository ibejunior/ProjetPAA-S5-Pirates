import java.util.ArrayList;
import java.util.HashMap;

public class Distribution {
	private HashMap<Pirate, ArrayList<Pirate>> relations;
	private ArrayList<Objet> listeObjets;
	private ArrayList<Pirate> listePirates;
	
	public Distribution(int n) {
		listePirates = new ArrayList<Pirate>(n);
		listeObjets = new ArrayList<Objet>();
		relations = new HashMap<Pirate, ArrayList<Pirate>>(n);
	}
	
	public void initPirates(int n) {
		for(int i = 0; i < n; i++) {
			Objet obj = new Objet("o" + (i+1));
			listeObjets.add(obj);
			
			String convertedChar = Character.toString((char)65+i);
			Pirate pirate = new Pirate(convertedChar);
			listePirates.add(pirate);
		}
	}
}
