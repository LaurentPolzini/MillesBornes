package cartes;

public abstract class Carte {

	@Override
	public boolean equals(Object o) {
		if (o instanceof Carte carte) {
			return (carte.toString()).equals(this.toString());
		}
		return false;
	}
	
}
