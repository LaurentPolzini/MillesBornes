package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return getType().getParade();
	}
	
	@Override
	public boolean equals(Object o) {
		if (super.equals(o)) {
			return (o instanceof Parade);
		}
		return false;
	}
	
}
