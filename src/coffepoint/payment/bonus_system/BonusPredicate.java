package coffepoint.payment.bonus_system;

public interface BonusPredicate {
	public int bonusesToCents(int bonuses);
	public int centsToBonuses(int cents);
}
