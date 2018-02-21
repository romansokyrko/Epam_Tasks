package com.acyl.XMLExample.model;

public class Type {
	private String group;
	private boolean peripheral;
	private int energyConsumption;
	private String port;
	
	public Type() {

	}

	public Type(String group, boolean peripheral, int energyConsumption) {
		super();
		this.group = group;
		this.peripheral = peripheral;
		this.energyConsumption = energyConsumption;
	}
	
	public Type(String group, boolean peripheral, int energyConsumption, String port) {
		super();
		this.group = group;
		this.peripheral = peripheral;
		this.energyConsumption = energyConsumption;
		this.port = port;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public boolean isPeripheral() {
		return peripheral;
	}

	public void setPeripheral(boolean peripheral) {
		this.peripheral = peripheral;
	}

	public int getEnergyConsumption() {
		return energyConsumption;
	}

	public void setEnergyConsumption(int energyConsumption) {
		this.energyConsumption = energyConsumption;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}


	
    @Override
    public String toString() {
        return "Type{" +
                "group='" + group + '\'' +
                ", energyConsumption=" + energyConsumption +
                ", peripheral=" + peripheral +
                ", port='" + port + '\'' +
                '}';
    }
}
