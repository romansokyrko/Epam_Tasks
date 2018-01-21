package coffepoint.products.drinks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import coffepoint.additions.Addition;
import coffepoint.additions.SugarLevel;

public class Espresso extends Drink {

	private static final String NAME = "Espresso";
	private static final int PRICE_IN_CENTS = 750;
	
	public Espresso() {
		this(SugarLevel.NONE, new HashSet<Addition>());
	}
	
	public Espresso(SugarLevel sugarLevel) {
		this(sugarLevel, new HashSet<Addition>());
	}
	
	public Espresso(Set<Addition> additions) {
		this(SugarLevel.NONE, additions);
	}
	
	public Espresso(SugarLevel sugarLevel, Set<Addition> additions) {
		super(NAME, PRICE_IN_CENTS, sugarLevel, additions);
	}
	
	public Espresso(SugarLevel sugarLevel, Addition ... additions) {
		super(NAME, PRICE_IN_CENTS, sugarLevel, new HashSet<Addition>(Arrays.asList(additions)));
	}
}
