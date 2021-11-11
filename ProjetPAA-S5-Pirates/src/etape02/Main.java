package etape02;

import java.io.IOException;

/**
 * 
 * Classe main de l'ensemble du Projet
 * 
 * @author El-Mougharti Hanafi
 * @author Vallée Arthur
 * @author Stefanos Alexandre
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		Menus m = new Menus();
		m.initialisations();
		m.gestionPirate();
		m.menuSuivant();
		m.menuSuivant2();
	}
}
