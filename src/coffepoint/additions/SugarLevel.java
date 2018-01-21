package coffepoint.additions;

public enum SugarLevel {
	NONE(0), LOW(50), MEDIUM(100), HIGH(150);
	
	private int priceInCents;
	
	SugarLevel(int priceInCents){
		this.priceInCents=priceInCents;
	}
	
	public int getPriceInCents() {
		return priceInCents;
	}

}
