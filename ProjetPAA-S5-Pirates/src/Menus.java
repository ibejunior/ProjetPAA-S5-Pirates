import java.util.Scanner;

public class Menus {
    private Scanner sc;
    private int n;
    private Distribution distrib;

    public Menus() {
        this.distrib = null;
        this.n = 0;
        sc = new Scanner(System.in);
    }

    public void initialisations() {
        System.out.println("wsh bien ou quoi ?");
        System.out.println("Combien de pirates constituent l'équipage ?");
        n = sc.nextInt();
        while(n < 2 || n > 26) {
            System.out.println("Vous avez donné un nombre de pirates inférieur à 2 ou supérieur à 26. Veuillez donner un "
                    + "nombre de pirates adéquat");
            n = sc.nextInt();
        }
        System.out.println("L'équipage est composé de " + n + " pirates et ils ont trouvé " + n + " objets.");
    }

    public void gestionPirate() {
        System.out.println("Veuillez choisir une option :");
        String s1, s2;
        Pirate p1,p2;
        Objet o;
        int menu;
        int tmp;
        distrib = new Distribution(n);
        distrib.initPirates();
        distrib.initRelations();
        distrib.initObjets();
        do {
            System.out.println("\t1) Ajouter une relation");
            System.out.println("\t2) Ajouter des préférences");
            System.out.println("\t3) Fin");
            menu = sc.nextInt();
            switch(menu) {
            case 1 :
        		System.out.println("Veuillez donner les deux pirates");
        		s1 = sc.next();
        		s2 = sc.next();
        		p1 = distrib.cherchePirate(s1);
        		p2 = distrib.cherchePirate(s2);
        		if (p1 == null)
        			System.out.println("Le pirate " + s1 + " n'existe pas");
        		else if (p2 == null)
        			System.out.println("Le pirate " + s2 + " n'existe pas");
        		else
        			System.out.println("Les deux pirates donnés existent");
        		//distrib.gestionRelations(p1, p2);
        		break;
            case 2 :
        		System.out.println("Veuillez donner le nom du pirate puis la liste des objets dans l'ordre de ses préférences");
        		System.out.println("Exemple : A 1 2 3");
        		s1 = sc.next();
        		s2 = "" + s1.charAt(0);
        		p1 = distrib.cherchePirate(s2);
        		System.out.println(s2);
        		while(!distrib.getListePirates().contains(p1)) {
        			System.out.println("ERREUR");
        			System.out.println("Veuillez donner le nom du pirate puis la liste des objets dans l'ordre de ses préférences");
        			System.out.println("Exemple : A 1 2 3");
        			s1 = sc.next();
        			s2 = "" + s1.charAt(0);
        			p1 = distrib.cherchePirate(s2);
        		}
        		for(int i = 2; i < s1.length(); i += 2) {
        			s2 = "" + s1.charAt(i);
        			tmp = Integer.parseInt(s2);
        			o = distrib.getListeObjets().get(tmp-1);
        			p1.getPrefs(n).add(o);
        		}
        		break;
            case 3 :
        		/*for(int i = 0; i < n; i++) {
        			
        		}
        		if() {
        			
        			menu = 86;
        		}
        		else 
        			System.out.println("Vous passez au menu suivant");**/
            default : 
        		System.out.println("La valeur donnée n'est pas adéquate");
            }
        }while(menu != 3);
    }
}