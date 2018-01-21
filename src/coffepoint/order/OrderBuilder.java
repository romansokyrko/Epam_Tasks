package coffepoint.order;

import java.util.ArrayList;
import java.util.List;

import coffepoint.products.Product;

public class OrderBuilder {
	private List<Product> items;
	
	public OrderBuilder(List<Product> items) {
		this.items = items;
	}
	
	public OrderBuilder() {
		this(new ArrayList<Product>());
	}
	
	public OrderBuilder addItem(Product prod) {
		items.add(prod);
		return this;
	}
	
	public OrderBuilder addItem(Product prod, int amount) {
		for (int i = 0; i < amount; i++) {
			items.add(prod);
		}
		return this;
	}

	public List<Product> getItems() {
		return items;
	}

	public OrderBuilder setItems(List<Product> items) {
		this.items = items;
		return this;
	}
	
	public Order build() {
		return new Order(items);
	}
}
