package cartes;

import java.util.Collections;

public class JeuDeCartes {
	int NB_CONFIG = 19;
	int NB_CARTES_TOTAL = 106;
	
	private Configuration[] typesDeCartes = new Configuration[]  {
			new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10),
			new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4),
			new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Attaque(Type.CREVAISON), 3),
			new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new Botte(Type.CREVAISON), 1),
			new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new Parade(Type.ACCIDENT), 6),
			new Configuration(new Botte(Type.ACCIDENT), 1),
			new Configuration(new DebutLimite(), 4),
			new Configuration(new FinLimite(), 6),
			new Configuration(new Attaque(Type.FEU), 5),
			new Configuration(new Parade(Type.FEU), 14),
			new Configuration(new Botte(Type.FEU), 1)
	};
	
	public String affichageJeuDeCartes() {
		StringBuilder retour = new StringBuilder();
		
		for (int i = 0 ; i < NB_CONFIG ; ++i) {
			retour.append(Integer.toString(typesDeCartes[i].getNbExemplaires()));
			retour.append(" ");
			retour.append(typesDeCartes[i].getCarte().toString());
			retour.append("\n");
		}
		
		return retour.toString();
	}
	
	public Carte[] donnerCartes() {
		Carte[] cardList = new Carte[this.nbCartesConfig()];
		
		for (int i = 0, indCarte = 0 ; i < NB_CONFIG ; i++) {
			for (int j = 0 ; j < typesDeCartes[i].nbExemplaires ; j++) {
				cardList[indCarte++] = typesDeCartes[i].getCarte();
			}
		}
		
		return cardList;
	}
	
	private int nbCartesConfig() {
		int nbCards = 0;
		for (Configuration config : this.typesDeCartes) {
			nbCards += config.getNbExemplaires();
		}
		
		return nbCards;
	}
	
	public boolean checkCount() {
		Carte[] cartes = donnerCartes();
		int cmpt = 0;
		
		Carte curCarte = null;
		int nbExemplaires = 0;
		
		for (int i = 0 ; i < NB_CONFIG ; i++ ) {
			curCarte = typesDeCartes[i].getCarte();
			nbExemplaires = typesDeCartes[i].getNbExemplaires();
			
			for ( int j = 0 ; j < cartes.length ; j++ ) {
				if (cartes[j] == curCarte) {
					cmpt++;
				}
			}
			if (cmpt != nbExemplaires) {
				return false;
			}
			
			cmpt = 0;
		}
		
		return true;
	}
	
	private static class Configuration extends Carte {
		private int nbExemplaires;
		private Carte carte;
		
		private Configuration(Carte carte, int nbExemplaires) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

		public Carte getCarte() {
			return carte;	
		}
	}
	
}
