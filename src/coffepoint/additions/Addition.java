package coffepoint.additions;

public abstract class Addition {

	String name;
	int priceInCents;
	
	public String getName() {
		return name;
	}
	public int getPriceInCents() {
		return priceInCents;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + priceInCents;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Addition other = (Addition) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priceInCents != other.priceInCents)
			return false;
		return true;
	}
	
	
	
}
