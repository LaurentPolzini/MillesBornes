package cartes;

public abstract class Limite extends Carte {
	
	@Override
	public boolean equals(Object o) {
		return this.getClass().equals(((Limite) o).getClass());
	}
}
