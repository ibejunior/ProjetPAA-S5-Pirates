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
		System.out.println("Combien de pirates constituent l'�quipage ?");
		n = sc.nextInt();
		while(n < 2 || n > 26) {
			System.out.println("Vous avez donn� un nombre de pirates inf�rieur � 2 ou sup�rieur � 26. Veuillez donner un "
					+ "nombre de pirates ad�quat");
			n = sc.nextInt();
		}
		System.out.println("L'�quipage est compos� de " + n + " pirates et ils ont trouv� " + n + " objets.");
		Distribution distrib = new Distribution(n);
		distrib.initPirates(n);
	}
	
	public void gestionPirate() {
		System.out.println("Veuillez choisir une option :");
		System.out.println("\t\t1) ajouter une relation");
	}
}
