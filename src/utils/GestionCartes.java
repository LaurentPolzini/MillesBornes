package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GestionCartes {

	private static Random rand = new Random();
	
	public GestionCartes() {
		// TODO Auto-generated constructor stub
	}

	public static <E> E extraire1(List<E> listeAExtraire) {
		int indRand = rand.nextInt(listeAExtraire.size());
		
		System.out.println(listeAExtraire.get(indRand).toString());
		
		return listeAExtraire.remove(indRand);
	}
	
	public static <E> E extraire2(List<E> listeAExtraire) {
		int indRand = rand.nextInt(listeAExtraire.size());
		Iterator<E> ite = listeAExtraire.iterator();
		
		E elem = null;
		
		for (; indRand > 0 && ite.hasNext() ; indRand--) {
			elem = ite.next();
		}
		ite.remove();
		
		System.out.println(elem.toString());
		
		return elem;
	}
	
	public static <E> List<E> melanger(List<E> lOriginal) {
		List<E> lMelangee = new ArrayList<>(lOriginal.size());
		
		E elemExtrait;
		
		while ( lOriginal.size() > 0 ) {
			elemExtrait = extraire1(lOriginal);
			lMelangee.add(elemExtrait);
		}
		
		return lMelangee;
	}
	
	public static <E> boolean verifierMelange(List<E> l1, List<E> l2) {
		boolean sameList = true;
		
		if (l1.size() != l2.size()) {
			return false;
		}
		Iterator<E> ite = l1.iterator();
		E currentElem;
		
		while ( ite.hasNext() ) {
			currentElem = ite.next();
			if ( Collections.frequency(l1, currentElem) != Collections.frequency(l2, currentElem)) {
				sameList = false;
			}
		}
		
		return sameList;
	}
		
	
	public static <E> List<E> rassembler(List<E> listeAAssembler) {
		List<E> listeRassemblee = new ArrayList<>(listeAAssembler.size());
		
		Iterator<E> ite = listeAAssembler.iterator();
		
		E curElem;
		
		while ( ite.hasNext() ) {
			curElem = ite.next();
			if ( !listeRassemblee.contains(curElem) ) {
				for (int i = 0 ; i < Collections.frequency(listeAAssembler, curElem) ; i++) {
					listeRassemblee.add(curElem);
				}
			}
		}
		
		
		return listeRassemblee;
	}
	
	public static <E> boolean verifierRassemblement(List<E> l1) {
		boolean rassemblerOK = true;
		
		E lastElem = null;
		E curElem = null;
		int indIte1 = 0; // to know where to begin with ite2.
		int indIte2 = 0;
		
		Iterator<E> ite1 = l1.iterator();
		
		while ( ite1.hasNext() ) {
			curElem = ite1.next();
			if ( !(curElem.equals(lastElem)) ) {
				Iterator<E> ite2 = l1.iterator();
				for ( indIte2 = 0 ; indIte2 < indIte1 ; indIte2++, ite2.next());
				
				while ( ite2.hasNext() ) {
					if ( ite2.next().equals(lastElem) ) {
						return false;
					}
				}
				lastElem = curElem;
			}
			indIte1++;
		}
		
		
		return rassemblerOK;
	}
	
	
}
