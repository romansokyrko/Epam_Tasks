package coffepoint.order;

import java.util.List;

import coffepoint.products.Product;

public class Order {
	public static int amount = 0;
	
	private List<Product> items;
	private int id;

	public Order(List<Product> items) {
		this.items = items;
		amount++;
		id=amount;
	}
	
	public List<Product> getItems() {
		return items;
	}

	public int getId() {
		return id;
	}
	
	public int getTotalPriceInCents() {
		int result = 0;
		for(Product each: items) {
			result += each.getPriceInCents();
		}
		return result;
	}
	
	public String statement() {
		StringBuilder result = new StringBuilder("Order #" + getId()+ "\n");
		result.append(String.format("%-10s Price\n", "Item"));
		for(Product each: items) {
			result.append(String.format("%-10s ", each.getName()))
				.append(each.getPriceInCents()/100 + ".")
				.append(each.getPriceInCents()%100 + "$\n");
		}
		result.append("Total price: " + getTotalPriceInCents()/100 + "."
				+ getTotalPriceInCents()%100 + "$\n");
		return result.toString();
		
	}
	
}
