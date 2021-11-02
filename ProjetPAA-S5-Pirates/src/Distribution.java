import java.util.ArrayList;
import java.util.HashMap;

public class Distribution {
    private HashMap<Pirate, ArrayList<Pirate>> relations;
    private ArrayList<Objet> listeObjets;
    private ArrayList<Pirate> listePirates;
    private int n;

    public Distribution(int n) {
        this.n = n;
        listePirates = new ArrayList<Pirate>(n);
        listeObjets = new ArrayList<Objet>();
        relations = new HashMap<Pirate, ArrayList<Pirate>>(n);
    }

    public ArrayList<Objet> getListeObjets() {
    	return(listeObjets);
    }
    
    public ArrayList<Pirate> getListePirates() {
    	return(listePirates);
    }
    
    public void initPirates() {
        for(int i = 0; i < n; i++) {
            String convertedChar = Character.toString((char)65+i);
            Pirate pirate = new Pirate(convertedChar);
            listePirates.add(pirate);
        }
    }
    
    public ArrayList<Objet> initObjets() {
    	for(int i = 0; i < n; i++) {
    		Objet obj = new Objet("o" + (i+1));
        	listeObjets.add(obj);
    	}
    	return(listeObjets);
    }

    public void initRelations() {
        for(int i = 0; i < n; i++) {
            ArrayList<Pirate> mauvaisesRelations = new ArrayList<Pirate>(n);
            relations.put(listePirates.get(i), mauvaisesRelations);
        }
    }

    public Pirate cherchePirate(String p1) {
        Pirate tmp = null;
        for(Pirate p : relations.keySet()) {
            if(p.getNom().equals(p1))
                tmp = p;
        }
        return(tmp);
    }

    public Objet chercheObjet(String o1) {
    	Objet tmp = null;
    	for(Objet o : listeObjets) {
    		if(o.getNom().equals(o1))
    			tmp = o;
    	}
    	return(tmp);
    }
    
    public void gestionRelations(Pirate p1, Pirate p2) {
        if(!relations.get(p1).contains(p2))
            relations.get(p1).add(p2);
        if(!relations.get(p2).contains(p1))
            relations.get(p2).add(p1);
    }
    
    public void solutionNaive() {
    	ArrayList<Objet> listeObjetsAttribues = new ArrayList<Objet>(n);
    	for(int i = 0; i < n; i++) {
    		if()
    	}
    }
}