package cartes;

public class Attaque extends Bataille {
	
	public Attaque(Type type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return getType().getAttaque();
	}
	
	@Override
	public boolean equals(Object o) {
		if (super.equals(o)) {
			return (o instanceof Attaque);
		}
		return false;
	}

}
