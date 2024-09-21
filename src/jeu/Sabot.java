package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot {
	
	Carte[] cartesList;
	int nbCartes;
	int nbOpe = 0;
	
	Iterateur ite = new Iterateur();
	

	public Sabot(Carte[] cartesList) {
		this.cartesList = cartesList;
		nbCartes = this.cartesList.length;
	}
	
	public Carte piocher() {
		Carte carteRetour = null;
		try {
			carteRetour = ite.next();
			ite.remove();
		} catch (NoSuchElementException | IllegalStateException | ConcurrentModificationException e) {
			e.printStackTrace();
		}
		
		return carteRetour;
	}

	public Boolean estVide() {
		return nbCartes == 0;
	}
	
	public Iterateur iterateur() {
		return new Iterateur();
	}
	
	public void ajouterCarte(Carte carteAAjouter) throws IllegalStateException {
		if (nbCartes >= 106) {
			throw new IllegalStateException("Le paquet est plein ! Vous ne pouvez pas ajouter de carte.");
		}
		cartesList[nbCartes - 1] = carteAAjouter;
		++nbCartes;
		++nbOpe;
	}
	
	public class Iterateur implements Iterator<Carte> {
		int indiceIT = 0;
		private int nbOpeRef = nbOpe;

		@Override
		public boolean hasNext() {
			return indiceIT < nbCartes;
		}

		@Override
		public Carte next() throws NoSuchElementException {
			if (hasNext()) {
				return cartesList[indiceIT++];
			}
			throw new NoSuchElementException("Il n'y a pas de cartes après !");
			
		}
		
		@Override
		public void remove() throws IllegalStateException, ConcurrentModificationException {
			verifConcurrence();
			
			if ( !(hasNext() || indiceIT > 0) ) {
				throw new IllegalStateException();
			}
			for (int i = indiceIT - 1 ; i < nbCartes - 1 ; ++i) {
				cartesList[i] = cartesList[i + 1];
			}
			--nbCartes;
			--indiceIT;
			
			++nbOpe;
			++nbOpeRef;
		}
		
		private void verifConcurrence() throws ConcurrentModificationException {
			if (nbOpe != nbOpeRef) {
				throw new ConcurrentModificationException("Plusieurs itérateurs !");
			}
		}
	}
	
}
