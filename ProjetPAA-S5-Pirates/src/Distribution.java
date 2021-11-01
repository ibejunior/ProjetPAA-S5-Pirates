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

    public void initPirates() {
        for(int i = 0; i < n; i++) {
            Objet obj = new Objet("o" + (i+1));
            listeObjets.add(obj);

            String convertedChar = Character.toString((char)65+i);
            Pirate pirate = new Pirate(convertedChar);
            listePirates.add(pirate);
        }
        for(int i = 0; i < n ; i++) {
            System.out.println("Liste:"+listePirates.get(i).getNom() );
        }
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
            if(p.getNom() == p1) {
                tmp = p;
            }
        }
        return tmp;


    }

    public void gestionRelations(Pirate p1, Pirate p2) {
        if (!relations.get(p1).contains(p2)) {
            relations.get(p1).add(p2);
        }
        if(!relations.get(p2).contains(p1)) {
            relations.get(p2).add(p1);
        }

    } 



}