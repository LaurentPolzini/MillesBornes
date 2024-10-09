package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;
public class ZoneDeJeu {
	
	List<Limite> listLimite = new ArrayList<>();
	List<Bataille> listBataille = new ArrayList<>();
	List<Borne> listBorne = new ArrayList<>();
	
	
	public ZoneDeJeu() {
		// TODO Auto-generated constructor stub
	}
	
	public int donnerLimitationVitesse() {
		if ( (listLimite.isEmpty()) || 
			 ((listLimite.get(listLimite.size() - 1)) instanceof FinLimite) ) {
				return 200;
		}
		return 50;
	}
	
	public int donnerKmParcourus() {
		int kmParcourus = 0;
		
		for (int i = 0 ; i < listBorne.size() ; i++) {
			kmParcourus += listBorne.get(i).getKm();
		}
		
		return kmParcourus;
	}

	
	public void deposer(Carte carte) {
		if (carte instanceof Borne born) {
			this.listBorne.add(born);
		}
		if (carte instanceof Bataille bat) {
			this.listBataille.add(bat);
		}
		if (carte instanceof Limite lim) {
			this.listLimite.add(lim);
		}
	}
	
}
