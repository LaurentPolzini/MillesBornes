package testsFonctionnels;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;
import jeu.Sabot.Iterateur;

public class TestSabot {

	/*
	 * public static void main(String[] args) { JeuDeCartes jeu = new JeuDeCartes();
	 * 
	 * Carte[] listeCartes = jeu.donnerCartes();
	 * 
	 * Sabot sabot = new Sabot(listeCartes);
	 * 
	 * Iterateur ite = sabot.iterateur();
	 * 
	 * Boolean fin = false;
	 * 
	 * while ( Boolean.FALSE.equals(fin) ) { try { sabot.ajouterCarte(new
	 * Botte(Type.CREVAISON));
	 * 
	 * System.out.println("Je pioche " + ite.next().toString() ); ite.remove();
	 * sabot.piocher(); } catch (NoSuchElementException |
	 * ConcurrentModificationException | IllegalStateException e) {
	 * e.printStackTrace(); fin = true; } }
	 * 
	 * 
	 * 
	 * while ( Boolean.FALSE.equals(sabot.estVide()) ) {
	 * System.out.println("Je pioche " + sabot.piocher().toString() ); } }
	 */

	JeuDeCartes jeu = new JeuDeCartes();
	Sabot sabot = new Sabot(jeu.donnerCartes());

	// 4.2.a
	public void questionA() {

			while (!sabot.estVide()) {
				Carte carte = sabot.piocher();
				System.out.println("Je pioche " + carte);
			}
//			Console :
//			Je pioche Accident
//			Je pioche Accident
//			Je pioche Accident
//			Je pioche R�paration
//			Je pioche R�paration
//			Je pioche R�paration
//			Je pioche As du volant
	}

	// 4.2.b
	public void questionB() {
			for (Iterator<Carte> iterator = sabot.iterateur(); iterator.hasNext();) {
				System.out.println("Je pioche " + iterator.next());
				iterator.remove();
			}
	}

	// 4.2.c
	public void questionC() {
			Carte cartePiochee = sabot.piocher();
			System.out.println("Je pioche " + cartePiochee);
			for (Iterator<Carte> iterator = sabot.iterateur(); iterator.hasNext();) {
				Carte carte = iterator.next();
				System.out.println("Je pioche " + carte);
				iterator.remove();
				cartePiochee = sabot.piocher();
				sabot.ajouterCarte(new Botte(cartes.Type.ACCIDENT));
			}
			Iterator<Carte> iterator = sabot.iterateur();
			System.out.println("\nLa pioche contient encore des cartes ? " + iterator.hasNext());
	}

	public static void main(String[] args) {
		TestSabot testPioche = new TestSabot();
//			testPioche.questionA();
			testPioche.questionB();
//			testPioche.questionC();
	}

}
