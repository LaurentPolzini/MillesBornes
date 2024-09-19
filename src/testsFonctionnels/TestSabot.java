package testsFonctionnels;

import cartes.Carte;
import cartes.JeuDeCartes;
import jeu.Sabot;


public class TestSabot {
	
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		
		Carte[] listeCartes = jeu.getListeCarte();
		
		Sabot sabot = new Sabot(listeCartes);
		
		while ( Boolean.FALSE.equals(sabot.estVide()) ) {
			System.out.println("Je pioche " + sabot.piocher().toString() );
		}
	}

}
