package coffepoint.products.drinks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import coffepoint.additions.Addition;
import coffepoint.additions.SugarLevel;

public class Cappuccino extends Drink {
	
	private static final String NAME = "Cappuccino";
	private static final int PRICE_IN_CENTS = 900;
	
	public Cappuccino() {
		this(SugarLevel.NONE, new HashSet<Addition>());
	}
	
	public Cappuccino(SugarLevel sugarLevel) {
		this(sugarLevel, new HashSet<Addition>());
	}
	
	public Cappuccino(Set<Addition> additions) {
		this(SugarLevel.NONE, additions);
	}
	
	public Cappuccino(SugarLevel sugarLevel, Set<Addition> additions) {
		super(NAME, PRICE_IN_CENTS, sugarLevel, additions);
	}
	
	public Cappuccino(SugarLevel sugarLevel, Addition ... additions) {
		super(NAME, PRICE_IN_CENTS, sugarLevel, new HashSet<Addition>(Arrays.asList(additions)));
	}
}
