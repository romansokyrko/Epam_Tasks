package coffepoint.products.foods;

import coffepoint.products.Product;

public class Food extends Product {
	
	public Food(String name, int priceInCents) {
		super(name, priceInCents);
	}

	@Override
	public int getPriceInCents() {
		return priceInCents;
	}



}
