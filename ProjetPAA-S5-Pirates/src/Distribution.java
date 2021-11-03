import java.util.ArrayList;
import java.util.HashMap;

/**
*
*
* @author El-Mougharti Hanafi
* @author Vallée Arthur
* @author Stefanos Alexandre
*
*/
public class Distribution {
    private HashMap<Pirate, ArrayList<Pirate>> relations;
    private ArrayList<Objet> listeObjets;
    private ArrayList<Pirate> listePirates;
    private int n;

    /**
     * Constructeur de la classe
     *
     * @param n		le nombre de Pirates
     */
    public Distribution(int n) {
        this.n = n;
        listePirates = new ArrayList<Pirate>(n);
        listeObjets = new ArrayList<Objet>();
        relations = new HashMap<Pirate, ArrayList<Pirate>>(n);
    }

    /**
     * Getter de la liste des Objets
     *
     * @return la liste d'Objets
     */
    public ArrayList<Objet> getListeObjets() {
    	return(listeObjets);
    }
    
    /**
     * Getter de la liste des Pirates
     *
     * @return la liste des Pirates
     */
    public ArrayList<Pirate> getListePirates() {
    	return(listePirates);
    }
    
    /**
     * Permet d'initialiser la liste des Pirates
     */
    public void initPirates() {
        for(int i = 0; i < n; i++) {
            String convertedChar = Character.toString((char)65+i);
            Pirate pirate = new Pirate(convertedChar);
            listePirates.add(pirate);
        }
    }
    
    /**
     * Permet d'initialiser la liste des Objets
     *
     * @return la liste des Objets
     */
    public ArrayList<Objet> initObjets() {
    	for(int i = 0; i < n; i++) {
    		Objet obj = new Objet("o" + (i+1));
        	listeObjets.add(obj);
    	}
    	return(listeObjets);
    }

    /**
     * Permet d'initialiser le dictionnaire(HashMap) des relations entre les Pirates
     */
    public void initRelations() {
        for(int i = 0; i < n; i++) {
            ArrayList<Pirate> mauvaisesRelations = new ArrayList<Pirate>(n);
            relations.put(listePirates.get(i), mauvaisesRelations);
        }
    }
    
    /**
     * Permet d'afficher le dictionnaire(HashMap) des relations entre les Pirates
     */
    public void afficherRelations() {
    	for (Pirate p : relations.keySet()) {
	        System.out.println(" Liste " + p.getNom());
	        for(int i = 0; i < relations.get(p).size();i++) {
	        	System.out.println(" Element " + i + " : " + relations.get(p).get(i));
	        }
	    }
    }

    /**
     * Permet de retourner un Pirate à partir d'une chaîne
     * de caractères
     *
     * @param p1	le nom du Pirate recherché
     * @return le Pirate recherché
     */
    public Pirate cherchePirate(String p1) {
        Pirate tmp = null;
        for(Pirate p : relations.keySet()) {
            if(p.getNom().equals(p1))
                tmp = p;
        }
        return(tmp);
    }

    /**
     * Permet de retourner un Objet à partir d'une chaîne
     * de caractères
     *
     * @param o1	le nom de l'Objet recherché
     * @return l'Objet recherché
     */
    public Objet chercheObjet(String o1) {
    	Objet tmp = null;
    	for(Objet o : listeObjets) {
    		if(o.getNom().equals(o1))
    			tmp = o;
    	}
    	return(tmp);
    }
    
    /**
     * Permet d'ajouter des relations entre 2 pirates
     *
     * @param p1	le premier Pirate impliqué
     * @param p2	le second Pirate impliqué
     */
    public void gestionRelations(Pirate p1, Pirate p2) {
        if(!relations.get(p1).contains(p2))
            relations.get(p1).add(p2);
        if(!relations.get(p2).contains(p1))
            relations.get(p2).add(p1);
    }
    
    /**
     * Permet de trouver la solution naïve lors de la
     * répartition des objets entre les pirates
     */
    public void solutionNaive() {
    	ArrayList<Objet> listeObjetsAttribues = new ArrayList<Objet>(n);
    	System.out.println("Voici la solution naîve : ");
    	for(int i=0 ; i<n ; i++) {
    		for(int j=0 ; j<n ; j++) {
    			if(!listeObjetsAttribues.contains(listePirates.get(i).getPrefs().get(j)) && listePirates.get(i).getObjet() == null) {
        			listeObjetsAttribues.add(listePirates.get(i).getPrefs().get(j));
        			listePirates.get(i).setObjet(listePirates.get(i).getPrefs().get(j));
        		}
    		}
    	}
    }
  
    /**
     * Permet d'afficher l'Objet d'un Pirate
     */
    public void afficherObjPirates() {
    	for (int i=0; i<n; i++) {
			System.out.println(listePirates.get(i).getNom() + " : " + listePirates.get(i).getObjet().getNom());
    	}
    }
    
    /**
     * Permet d'échanger les Objets de 2 Pirates
     *
     * @param p1	le premier Pirate impliqué
     * @param p2	le second Pirate impliqué
     */
    public void echangeObj(Pirate p1 , Pirate p2) {
    	Objet tmp = p2.getObjet();
    	p2.setObjet(p1.getObjet());
    	p1.setObjet(tmp);
    }
    
    /**
     * Permet de gérer le coût des échanges
     * 
     * @return le coût
     */
    public int cout() {
    	int index, cpt = 0;
    	ArrayList<Objet> objets = new ArrayList<>(n);  
    	boolean coutUnique = false;
    	for(Pirate p : relations.keySet()) {
    		objets.clear();
    		coutUnique = true;
    		index = p.getPrefs().indexOf(p.getObjet());
    		for(int i = 0 ; i < index; i++) {
    			objets.add(p.getPrefs().get(i));
    		}
    		for(int i = 0; i < relations.get(p).size(); i++) {
    			if(objets.contains(relations.get(p).get(i).getObjet()) && coutUnique) {
    				cpt++;
    				coutUnique = false;
    			}
    		}
    	}
    	return cpt;
    }
}