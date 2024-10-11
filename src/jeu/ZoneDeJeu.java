package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;
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
	
	// liste pas vide et le sommet de la liste est un feu vert (parade de type feu)
	public boolean peutAvancer() {
		int sizeListBat = listBataille.size(); 
		return ( (sizeListBat != 0) && (listBataille.get(sizeListBat - 1).equals(new Parade(Type.FEU))) );
	}
	
	private boolean estDepotFeuVertAutorise() {
		if (listBataille.isEmpty()) {
			return true;
		}
		
		// liste vide
		int sizeListBat = listBataille.size();
		Bataille bat = getTopCardBataille();
		// sommet = feu rouge
		boolean sommetFeuRouge = bat.equals(new Attaque(Type.FEU));
		
		// Le sommet est une parade mais PAS de type feu (donc toutes les autres)
		boolean sommetParadePasFeuVert = bat.equals(new Parade(Type.ACCIDENT));
		sommetParadePasFeuVert = sommetParadePasFeuVert || bat.equals(new Parade(Type.CREVAISON));
		sommetParadePasFeuVert = sommetParadePasFeuVert || bat.equals(new Parade(Type.ESSENCE));
		
		
		return ( (sizeListBat == 0) || sommetFeuRouge || sommetParadePasFeuVert);
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {
		boolean borneAutorisee = peutAvancer();
		borneAutorisee = borneAutorisee && (sumBornes() < 1000);
		borneAutorisee = borneAutorisee && (borne.getKm() <= donnerLimitationVitesse());
		
		if (borne.getKm() == 200) {
			borneAutorisee = borneAutorisee && depotBorne200Possible();
		}
		
		return borneAutorisee;
	}
	
	private int sumBornes() {
		int sum = 0;
		
		for (int i = 0 ; i < listBorne.size() ; i++) {
			sum += listBorne.get(i).getKm();
		}
		
		return sum;
	}
	
	// 2 bornes de 200 maximum pour un joueur
	private boolean depotBorne200Possible() {
		int nbBorne200 = 0;
		for (int i = 0 ; i < listBorne.size() ; i++) {
			if (listBorne.get(i).getKm() == 200) {
				nbBorne200++;
			}
		}
		
		
		return nbBorne200 < 2;
	}
	
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		boolean depotPossible;
		Limite topCardLimite = getLastLimite();
		
		if (limite instanceof FinLimite) {
			depotPossible = topCardLimite instanceof DebutLimite;
		} else {
			depotPossible = ( (topCardLimite == null) || (topCardLimite instanceof FinLimite) );
		}
		
		return depotPossible;
	}
	
	private Limite getLastLimite() {
		Limite lim = null;
		if (!listLimite.isEmpty()) {
			lim = listLimite.get(listLimite.size() - 1);
		}
		return lim;
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		boolean depotPossible;
		
		if (bataille instanceof Attaque) {
			depotPossible = peutAvancer();
		} else {
			if (bataille.equals(new Parade(Type.FEU))) {
				depotPossible = estDepotFeuVertAutorise();
			} else {
				depotPossible = !listBataille.isEmpty();
				depotPossible = depotPossible && (getTopCardBataille().getType().equals(bataille.getType()));
			}
		}
		
		
		return depotPossible;
	}
	
	private Bataille getTopCardBataille() {
		Bataille bat = null;
		if (!listBataille.isEmpty()) {
			bat = listBataille.get(listBataille.size() - 1);
		}
		return bat;
	}
	
	public boolean estDepotAutorise(Carte carte) {
		boolean depotOK = false;
		if (carte instanceof Bataille bat) {
			depotOK = estDepotBatailleAutorise(bat);
		}
		if (carte instanceof Limite lim) {
			depotOK = estDepotLimiteAutorise(lim);
		}
		if (carte instanceof Borne born) {
			depotOK = estDepotBorneAutorise(born);
		}
		
		return depotOK;
	}
	
}
