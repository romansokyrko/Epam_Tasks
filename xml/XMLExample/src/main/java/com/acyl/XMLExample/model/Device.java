package com.acyl.XMLExample.model;

public class Device {
	private String name;
	private String origin;
	private int price;
	private Type type;
	private boolean critical;
	
	public Device() {

	}
	
	public Device(String name, String origin, int price, Type type, boolean critical) {
		super();
		this.name = name;
		this.origin = origin;
		this.price = price;
		this.type = type;
		this.critical = critical;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isCritical() {
		return critical;
	}

	public void setCritical(boolean critical) {
		this.critical = critical;
	}

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", type='" + type + '\'' +
                ", critical=" + critical +
                ", price=" + price +
                '}';
    }

}
