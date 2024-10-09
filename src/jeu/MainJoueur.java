package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public class MainJoueur {
	
	List<Carte> main = new ArrayList<>();

	
	public void prendre(Carte carte) {
		if (carte != null) {
			this.main.add(carte);
		}
	}
	
	public void jouer(Carte carte) {
		assert (main.contains(carte));
		main.remove(carte);
	}
	
	
	public String toString() {
		StringBuilder mainString = new StringBuilder();
		
		for (int i = 0 ; i < this.main.size() ; i++) {
			mainString.append(this.main.get(i).toString());
		}
		
		
		return main.toString();
	}

}
