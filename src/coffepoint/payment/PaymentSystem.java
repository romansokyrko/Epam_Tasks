package coffepoint.payment;


import coffepoint.exceptions.NotEnoughMoneyException;
import coffepoint.order.Order;
import coffepoint.payment.bonus_system.BonusCard;
import coffepoint.payment.bonus_system.BonusPredicate;
import coffepoint.payment.bonus_system.BonusPredicateImpl;

public class PaymentSystem {

	private int cashInCents;
	private BonusPredicate bonusPredicate;

	public PaymentSystem() {
		this(0);
	}

	public PaymentSystem(int cashInCents) {
		this.cashInCents = cashInCents;
		bonusPredicate = new BonusPredicateImpl();
	}

	public int getCashInCents() {
		return cashInCents;
	}

	public String getCash(){
		return "" + cashInCents/100 +"." + cashInCents%100 + "$";
	}

	public int bill(Order order, int cents) throws NotEnoughMoneyException {
		int change = 0;
		if (order.getTotalPriceInCents() > cents)
			throw new NotEnoughMoneyException("" + cents/100 + "." + cents%100 + "$");
		cashInCents += order.getTotalPriceInCents();
		change = order.getTotalPriceInCents() - cents;
		return change;
	}

	public void bill(Order order, CreditCard card) throws NotEnoughMoneyException {
		if (order.getTotalPriceInCents() > card.getCashInCents())
			throw new NotEnoughMoneyException("" + card.getCashInCents()/100 + 
					"." + card.getCashInCents()%100 + "$");
		card.withdraw(order.getTotalPriceInCents());
		cashInCents += order.getTotalPriceInCents();
	}
	
	public void bill(Order order, BonusCard card) throws NotEnoughMoneyException {
		if (order.getTotalPriceInCents() > bonusPredicate.bonusesToCents(card.getBonuses()))
			throw new NotEnoughMoneyException("" + bonusPredicate.bonusesToCents(card.getBonuses())/100 + 
					"." + bonusPredicate.bonusesToCents(card.getBonuses())%100 + "$");
		card.withdrawBonuses(bonusPredicate.centsToBonuses(order.getTotalPriceInCents()));
		cashInCents += order.getTotalPriceInCents();
	}

}
