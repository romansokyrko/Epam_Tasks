package coffepoint.test;


import coffepoint.CoffeePoint;
import coffepoint.Menu;
import coffepoint.additions.*;
import coffepoint.exceptions.NoSuchItemException;
import coffepoint.exceptions.NotEnoughMoneyException;
import coffepoint.order.Order;
import coffepoint.order.OrderBuilder;
import coffepoint.payment.bonus_system.BonusCard;
import coffepoint.products.drinks.Americano;
import coffepoint.products.drinks.Cappuccino;
import coffepoint.products.drinks.Espresso;
import coffepoint.products.foods.HotDog;

public class Test {

	public static void main(String[] args) {
		CoffeePoint cp = initCoffeePoint();
		System.out.println(cp.getMenu().statement());

		Espresso es = new Espresso(SugarLevel.MEDIUM, new Milk(), new Cream());
		HotDog hd = new HotDog();
		
		Order order = new OrderBuilder()
			.addItem(es)
			.addItem(hd, 2)
			.build();
		System.out.println(order.statement());
		
		try {
			cp.bill(order, 10000);
		} catch (NoSuchItemException e) {
			e.printStackTrace();
		} catch (NotEnoughMoneyException e) {
			e.printStackTrace();
		}
		
		Order order2 = new OrderBuilder()
			.addItem(new Cappuccino())
			.build();
		System.out.println(order2.statement());
		

		try {
			cp.bill(order2, new BonusCard(50));
		} catch (NoSuchItemException e) {
			e.printStackTrace();
		} catch (NotEnoughMoneyException e) {
			e.printStackTrace();
		}
		
		System.out.println(cp.incomeStatement());
	}

	private static CoffeePoint initCoffeePoint() {
		Menu menu = new Menu();
		menu.add(new Americano());
		menu.add(new Espresso());
		menu.add(new HotDog());
		menu.add(new Cappuccino());
		menu.add(new Milk());
		menu.add(new Cream());
		return new CoffeePoint(menu);
	}

}
