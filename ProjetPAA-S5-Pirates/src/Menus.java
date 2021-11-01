import java.util.Scanner;

public class Menus {
	private Scanner sc;
	private int n;
	
	public Menus() {
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
		Distribution distrib = new Distribution(n);
		distrib.initPirates(n);
	}
	
	public void gestionPirate() {
		System.out.println("Veuillez choisir une option :");
		System.out.println("\t\t1) ajouter une relation");
	}
}
