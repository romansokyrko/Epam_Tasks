package coffepoint.products.drinks;

import java.util.HashSet;
import java.util.Set;

import coffepoint.additions.Addition;
import coffepoint.additions.SugarLevel;
import coffepoint.products.Product;

public abstract class Drink extends Product {
	
	SugarLevel sugarLevel;
	Set<Addition> additions;
	
	public Drink(String name, int priceInCents, SugarLevel sugarLevel, Set<Addition> additions) {
		super(name, priceInCents);
		this.sugarLevel=sugarLevel;
		this.additions=additions; 
	}
	
	public SugarLevel getSugarLevel() {
		return sugarLevel;
	}
	public void setSugarLevel(SugarLevel sugarLevel) {
		this.sugarLevel = sugarLevel;
	}
	public Set<Addition> getAdditions() {
		return additions;
	}
	public void setAdditions(Set<Addition> additions) {
		this.additions = new HashSet<Addition>(additions);
	}
	public void addAddition(Addition addition) {
		additions.add(addition);
	}

	@Override
	public int getPriceInCents() {
		int result = this.priceInCents + sugarLevel.getPriceInCents();
		for(Addition each: additions) {
			result+=each.getPriceInCents();
		}
		return result;
	}
}
