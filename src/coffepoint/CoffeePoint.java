package coffepoint;

import java.util.ArrayList;
import java.util.List;

import coffepoint.exceptions.NoSuchItemException;
import coffepoint.exceptions.NotEnoughMoneyException;
import coffepoint.order.Order;
import coffepoint.payment.CreditCard;
import coffepoint.payment.PaymentSystem;
import coffepoint.payment.bonus_system.BonusCard;

public class CoffeePoint {
	
	private Menu menu;
	private PaymentSystem payment;
	private List<Order> orders;

	public CoffeePoint(Menu menu) {
		this.menu = menu;
		orders = new ArrayList<Order>();
		payment = new PaymentSystem();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public boolean bill(Order order, int cents) throws NoSuchItemException, NotEnoughMoneyException {
			menu.checkOrder(order);
			payment.bill(order, cents);
			orders.add(order);
			return true;
	}

	public boolean bill(Order order, CreditCard card) throws NoSuchItemException, NotEnoughMoneyException {
			menu.checkOrder(order);
			payment.bill(order, card);
			orders.add(order);
			return true;
	}
	
	public void bill(Order order, BonusCard card) throws NoSuchItemException, NotEnoughMoneyException {
			menu.checkOrder(order);
			payment.bill(order, card);
			orders.add(order);
	}
	
	public String incomeStatement() {
		StringBuilder result = new StringBuilder("²ncome statement:\n");
		for(Order each: orders) {
			result.append(each.statement());
		}
		result.append("Total revenue: " + payment.getCash());
		return result.toString();
	}
	
}
