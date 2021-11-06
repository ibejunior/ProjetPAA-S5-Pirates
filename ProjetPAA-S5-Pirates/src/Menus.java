import java.util.Scanner;

/**
 * Classe qui permet de gérer l'affichage des différents menus
 * et de récupérer les demandes à l'utilisateur à l'aide d'un Scanner
 *
 * @author El-Mougharti Hanafi
 * @author Vallée Arthur
 * @author Stefanos Alexandre
 *
 */
public class Menus {
    private Scanner sc;
    private int n;
    private Distribution distrib;

    /**
     * Constructeur de la classe Menus
     */
    public Menus() {
        this.distrib = null;
        this.n = 0;
        sc = new Scanner(System.in);
    }

    /**
     * Premier Menu permettant à l'utilisateur le nombre de Pirates
     */
    public void initialisations() {
        System.out.println("Bienvenue !");
        System.out.println("Combien de pirates constituent l'équipage ?");
        n = sc.nextInt();
        while(n < 2 || n > 26) {
            System.out.println("Vous avez donné un nombre de pirates inférieur à 2 ou supérieur à 26. Veuillez donner un "
                    + "nombre de pirates adéquat");
            n = sc.nextInt();
        }
        System.out.println("L'équipage est composé de " + n + " pirates et ils ont trouvé " + n + " objets.");
    }

    /**
     * Second Menu permettant à l'utilisateur d'ajouter une relation
     * entre 2 pirates et d'ajouter des préférences d'Objets d'un Pirate.
     * Lorsque l'utilisateur a fini, il peut passer au menu Suivant
     */
    public void gestionPirate() {
        System.out.println("Veuillez choisir une option :");
        String s1, s2;
        Pirate p1,p2;
        Objet o;
        int menu, tmp;
        
        distrib = new Distribution(n);
        distrib.initPirates();
        distrib.initRelations();
        distrib.initObjets();
        Scanner scCase = new Scanner(System.in);
        do {
            System.out.println("\t1) Ajouter une relation");
            System.out.println("\t2) Ajouter des préférences");
            System.out.println("\t3) Menu Suivant");
            menu = scCase.nextInt();
            switch(menu) {
            case 1 :
        		System.out.println("Veuillez donner les deux pirates");
        		s1 = sc.next();
        		s2 = sc.next();
        		p1 = distrib.cherchePirate(s1);
        		p2 = distrib.cherchePirate(s2);
        		if (p1 == null)
        			System.out.println("Le pirate " + s1 + " n'existe pas");
        		if (p2 == null)
        			System.out.println("Le pirate " + s2 + " n'existe pas");
        		else if(p1.getNom() == p2.getNom())
        			System.out.println("Vous ne pouvez pas créer une relation entre " + p1.getNom() + " et " + p2.getNom());
        		else {
        			System.out.println("La relation entre " + p1.getNom() + " et " + p2.getNom() + " a été créée");
        			distrib.gestionRelations(p1, p2);
        		}
        		break;
            case 2 :
        		System.out.println("Veuillez donner le nom du pirate puis la liste des objets dans l'ordre de ses préférences");
        		System.out.println("Exemple : A 1 2 3");
        		s1 = sc.next();
        		s2 = "" + s1.charAt(0);
        		p1 = distrib.cherchePirate(s2);
        		while(!distrib.getListePirates().contains(p1)) {
        			System.out.println("ERREUR");
        			System.out.println("Veuillez donner le nom du pirate puis la liste des objets dans l'ordre de ses préférences.\n"
        					+ "Il est nécessaire que vous indiquiez précisément " + n + " objets");
        			System.out.println("Exemple : A 1 2 3");
        			s1 = sc.next();
        			p1 = distrib.cherchePirate(s1);
        		}
        		p1.initPrefs(n);
        		for(int i = 0; i < n; i++) {
        			tmp = sc.nextInt();
        			o = distrib.getListeObjets().get(tmp-1);
        			p1.getPrefs().add(o);
        		}
        		break;
            case 3 :
        		for(int i = 0; i < n; i++) {
        			if(distrib.getListePirates().get(i).getPrefs() == null) {
        				System.out.println("Le Pirate " + distrib.getListePirates().get(i).getNom() + " n'a pas encore sa liste de préférences");
        				menu = 2677;
        			}
        		}
        		break;
            default : 
        		System.out.println("La valeur donnée n'est pas adéquate");
        		break;
            }
        }while(menu != 3);
    }
   
    /**
     * Troisième et dernier Menu permettant à l'utilisateur
     * d'échanger les objets entre pirates et d'afficher
     * le coût
     */
    public void menuSuivant() {
    	distrib.afficherRelations();
    	System.out.println("Vous passez au menu suivant");
    	distrib.solutionNaive();
    	distrib.afficherObjPirates();
    	int menuSuiv;
    	String s1 , s2;
    	Pirate p1 , p2;
        Scanner scSuiv = new Scanner(System.in);
        Scanner scNouv = new Scanner(System.in);
        do {
        	System.out.println("\t1) Echanger objets entre pirate");
        	System.out.println("\t2) Afficher le cout");
        	System.out.println("\t3) Fin");
        	menuSuiv = scSuiv.nextInt();
        	switch(menuSuiv) {
        	case 1:
        		System.out.println("Selectionner 2 Pirates");
        		s1 = sc.next();
        		s2 = sc.next();
        		p1 = distrib.cherchePirate(s1);
        		p2 = distrib.cherchePirate(s2);
        		distrib.echangeObj(p1 , p2);
        		distrib.afficherObjPirates();
        		break;
        	case 2:
        		System.out.println("Coût :");
        		System.out.println("Le coût est : " + distrib.cout());
        		break;
        	case 3:
        		System.out.println("FIN");
        		break;
        	default :
        		System.out.println("La valeur donnée n'est pas adéquate");
        		break;
        	}
         }while(menuSuiv != 3);
     }
}