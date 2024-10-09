package cartes;

public class FinLimite extends Limite {

	public FinLimite() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Fin limite";
	}
	
	@Override
	public boolean equals(Object o) {
		if (super.equals(o)) {
			return (o instanceof FinLimite);
		}
		return false;
	}
}
