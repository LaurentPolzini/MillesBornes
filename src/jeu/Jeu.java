package jeu;

import java.util.Arrays;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	
	private Sabot sabot;
	private JeuDeCartes jeu = new JeuDeCartes();
	private Carte[] cartes;

	public Jeu() {
		cartes = jeu.donnerCartes();
		List<Carte> listCards = GestionCartes.melanger(Arrays.asList(cartes));
		this.sabot = new Sabot((Carte[]) listCards.toArray());
	}

}
