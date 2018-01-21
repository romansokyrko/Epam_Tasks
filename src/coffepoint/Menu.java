package coffepoint;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import coffepoint.additions.Addition;
import coffepoint.exceptions.NoSuchItemException;
import coffepoint.order.Order;
import coffepoint.products.Product;
import coffepoint.products.drinks.Drink;
import coffepoint.products.foods.Food;

public class Menu {
	
	private Set<Product> items;
	private Set<Addition> additions;
	
	public Menu() {
		this(new HashSet<Product>(), new HashSet<Addition>());
	}

	public Menu(Set<Product> items) {
		this(items, new HashSet<Addition>());
	}
	
	public Menu(Set<Product> items, Set<Addition> additions) {
		this.items = items;
		this.additions = additions;
	}
	
	public Set<Addition> getAdditions() {
		return additions;
	}

	public void setAdditions(Set<Addition> additions) {
		this.additions = additions;
	}

	public Set<Product> getItems() {
		return items;
	}

	public void setItems(Set<Product> items) {
		this.items = items;
	}
	
	public void add(Product product) {
		items.add(product);
	}
	
	public void add(Addition addition) {
		additions.add(addition);
	}
	
	public void remove(Product product) {
		items.remove(product);
	}
	
	public void remove(Addition addition) {
		additions.remove(addition);
	}

	public boolean contains(Product product) {
		return items.contains(product);
	}
	
	public boolean contains(Addition addition) {
		return additions.contains(addition);
	}
	
	public void checkOrder(Order order) throws NoSuchItemException {
		List<Product> items  = order.getItems();
		for(Product each: items) {
			if(!contains(each)){
				throw new NoSuchItemException("No " + each.getName() + " in menu");
			}
			if(each instanceof Drink) {
				Set<Addition> additions = ((Drink) each).getAdditions();
				for(Addition addition: additions) {
					if(!contains(addition)){
						throw new NoSuchItemException("No " + addition.getName() + " in menu");
					}
				}
			}
		}
	}
	
	public String statement() {
		StringBuilder result = new StringBuilder("Available items: \n");
		result.append("Drinks: \n");
		for(Product each: items) {
			if(each instanceof Drink) {
				result.append(String.format("\t%-10s ", each.getName()))
					.append(each.getPriceInCents()/100 + ".")
					.append(each.getPriceInCents()%100 + "$\n");
			}
		}
		result.append("Additions: \n");
		for(Addition each: additions) {
			if(each instanceof Addition) {
				result.append(String.format("\t%-10s ", each.getName()))
					.append(each.getPriceInCents()/100 + ".")
					.append(each.getPriceInCents()%100 + "$\n");
			}
		}
		result.append("Food: \n");
		for(Product each: items) {
			if(each instanceof Food) {
				result.append(String.format("\t%-10s ", each.getName()))
					.append(each.getPriceInCents()/100 + ".")
					.append(each.getPriceInCents()%100 + "$\n");
			}
		}
		return result.toString();
	}
}
