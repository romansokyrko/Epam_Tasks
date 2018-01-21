package coffepoint.payment.bonus_system;

public class BonusCard {
	
	private int bonuses;
	
	public BonusCard() {
		this(0);
	}

	public BonusCard(int bonuses) {
		this.bonuses = bonuses;
	}

	public int getBonuses() {
		return bonuses;
	}
	
	public void addBonuses(int bonuses) {
		this.bonuses+=bonuses;
	}
	
	public void withdrawBonuses(int bonuses) {
		this.bonuses-=bonuses;
	}

}
