package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	protected Probleme(Type type) {
		this.type = type;
	}
	
	protected Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o != null) {
			return this.getClass().equals(((Probleme) o).getClass());
		}
		return false;
	}
	
}
