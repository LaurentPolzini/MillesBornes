package cartes;

public class Borne extends Carte {
	
	private int km;

	public Borne(int km) {
		this.km = km;
	}

	public int getKm() {
		return km;
	}
	
	@Override
	public String toString() {
		return Integer.toString(this.km) + "KM";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Borne borne) {
			return this.km == borne.getKm();
		}
		return false;
	}
	
}
