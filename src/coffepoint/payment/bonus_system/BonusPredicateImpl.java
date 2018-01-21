package coffepoint.payment.bonus_system;
public class BonusPredicateImpl implements BonusPredicate{
	
	private static final int FACTOR = 50;

	@Override
	public int bonusesToCents(int bonuses) {
		return bonuses*FACTOR;
	}

	@Override
	public int centsToBonuses(int cents) {
		return cents/FACTOR;
	}
		
}
