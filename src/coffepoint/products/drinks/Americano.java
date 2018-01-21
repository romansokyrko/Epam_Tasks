package coffepoint.products.drinks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import coffepoint.additions.Addition;
import coffepoint.additions.SugarLevel;

public class Americano extends Drink {
	
	private static final String NAME = "Americano";
	private static final int PRICE_IN_CENTS = 900;
	
	public Americano() {
		this(SugarLevel.NONE, new HashSet<Addition>());
	}
	
	public Americano(SugarLevel sugarLevel) {
		this(sugarLevel, new HashSet<Addition>());
	}
	
	public Americano(Set<Addition> additions) {
		this(SugarLevel.NONE, additions);
	}
	
	public Americano(SugarLevel sugarLevel, Set<Addition> additions) {
		super(NAME, PRICE_IN_CENTS, sugarLevel, additions);
	}
	
	public Americano(SugarLevel sugarLevel, Addition ... additions) {
		super(NAME, PRICE_IN_CENTS, sugarLevel, new HashSet<Addition>(Arrays.asList(additions)));
	}
}
