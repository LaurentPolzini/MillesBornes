package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Bataille;
import cartes.Borne;
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
		if ( (listLimite.isEmpty())) {
			if ((listLimite.get(listLimite.size() - 1)) instanceof FinLimite) {
				return 200;
			}
		}
		return 50;
	}

}
