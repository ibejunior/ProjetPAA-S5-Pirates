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
        distrib = new Distribution(n);
        distrib.initPirates();
    }

    public void gestionPirate() {
        System.out.println("Veuillez choisir une option :");
        String s1,s2;
        Pirate p1,p2;
        distrib.initRelations();
        System.out.println("\t\t1) ajouter une relation");
        n = sc.nextInt();
        switch(n) {
        case 1 : 
            System.out.println("Donner deux pirates qui s'aiment pas");
            s1 = sc.next();
            s2 = sc.next();
            p1 = distrib.cherchePirate(s1);
            if (p1 == null) {
                System.out.println("Le pirate "+s1+" n'existe pas");
            }
            p2 = distrib.cherchePirate(s2);
            if (p2 == null) {
                System.out.println("Le pirate "+s2+" n'existe pas");
            }
            distrib.gestionRelations(p1, p2);



        }
    }

}