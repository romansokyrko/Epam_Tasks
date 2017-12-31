package trains;

public class Station implements Comparable<Station>{

	private String location;
	private Time dispatchTime;
	private Time arriveTime;
	
	public Station(String location, Time arriveTime, Time dispatchTime) {
		this.location = location;
		this.dispatchTime = dispatchTime;
		this.arriveTime = arriveTime;
	}
	
	@Override
	public int compareTo(Station o) {
		return dispatchTime.compareTo(o.dispatchTime);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		if (!location.equals(other.location))
			return false;
		if (!dispatchTime.equals(other.dispatchTime))
			return false;
		if (!arriveTime.equals(other.arriveTime))
			return false;
		return true;
	}




	public String getLocation() {
		return location;
	}


	public Time getDispatchTime() {
		return dispatchTime;
	}

	public Time getArriveTime() {
		return arriveTime;
	}

}
