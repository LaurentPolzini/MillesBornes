package jeu;

import cartes.Carte;

public class Joueur {
	
	String nom;
	ZoneDeJeu zone;
	
	MainJoueur main = new MainJoueur();

	public Joueur(String nom, ZoneDeJeu zone) {
		this.nom = nom;
		this.zone = zone;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Joueur joueur) {
			return (joueur.toString()).equals(this.nom);
		}
		return false;
	}


	@Override
	public String toString() {
		return this.nom;
	}
	
	
	public void donner(Carte carte) {
		this.main.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		Carte cartePiochee = sabot.piocher();
		
		if (cartePiochee != null) {
			this.main.prendre(cartePiochee);
		}
		
		return cartePiochee;
	}
	
	public int donnerKmParcourus() {
		return zone.donnerKmParcourus();
	}

}
