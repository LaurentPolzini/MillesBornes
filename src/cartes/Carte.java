package cartes;

public abstract class Carte {

	@Override
	public boolean equals(Object o) {
		if (o instanceof Carte) {
			return ((Carte) o).toString().equals(this.toString());
		}
		return false;
	}
	
}
