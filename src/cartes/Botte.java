package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return getType().getBotte();
	}
	
	@Override
	public boolean equals(Object o) {
		if ( (super.equals(o)) && (o instanceof Botte botte) ) {
			return this.getType().equals(botte.getType());
		}
		return false;
	}
	
}
