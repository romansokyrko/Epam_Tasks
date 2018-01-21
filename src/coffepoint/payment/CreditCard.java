package coffepoint.payment;

public class CreditCard {
	
	private int cashInCents;

	public CreditCard(int cashInCents) {
		this.cashInCents = cashInCents;
	}

	public int getCashInCents() {
		return cashInCents;
	}
	
	public void withdraw(int cents) {
		cashInCents-=cents;
	}
	
}
