package testsFonctionnels;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;
import jeu.Sabot.Iterateur;


public class TestSabot {
	
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		
		Carte[] listeCartes = jeu.getListeCarte();
		
		Sabot sabot = new Sabot(listeCartes);
		
		Iterateur ite = sabot.iterateur();
		
		Boolean fin = false;
		
		while ( Boolean.FALSE.equals(fin) ) {
			try {
				sabot.ajouterCarte(new Botte(Type.CREVAISON));
				
				System.out.println("Je pioche " + ite.next().toString() );
				ite.remove();
				sabot.piocher();
			} catch (NoSuchElementException | ConcurrentModificationException | IllegalStateException e) {
				e.printStackTrace();
				fin = true;
			}
		}
			
		
		/*
		while ( Boolean.FALSE.equals(sabot.estVide()) ) {
			System.out.println("Je pioche " + sabot.piocher().toString() );
		}*/
	}
	

}
