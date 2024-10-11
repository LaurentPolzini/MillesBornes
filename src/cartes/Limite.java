package cartes;

public abstract class Limite extends Carte {
	
	@Override
	public boolean equals(Object o) {
		if (o != null) {
			return this.getClass().equals(o.getClass());
		}
		return false;
	}
}
