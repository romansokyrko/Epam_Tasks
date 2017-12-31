package trains;

public class Time implements Comparable<Time>{
	private int hours;
	private int minutes;
	
	public Time(int hours, int minutes) {
		this.minutes=minutes%60;
		this.hours=hours%24+minutes/60;
	}

	@Override
	public int compareTo(Time o) {
		if(hours<o.hours) return -1;
		else if(hours>o.hours) return 1;
		else {
			if(minutes<o.minutes) return -1;
			else if(minutes>o.minutes) return 1; 
		}
		return 0;
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hours != other.hours)
			return false;
		if (minutes != other.minutes)
			return false;
		return true;
	}

	
	
}
