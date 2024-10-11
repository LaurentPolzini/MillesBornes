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
		if ( (super.equals(o)) && (o instanceof Attaque att) ) {
			return this.getType().equals(att.getType());
		}
		return false;
	}

}
