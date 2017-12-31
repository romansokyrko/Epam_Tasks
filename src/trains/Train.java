package trains;

import java.util.ArrayList;
import java.util.List;

public class Train {
	
	private List<Station> stations;
	private int number;
	private int freeSeats;

	public Train(int number, List<Station> stations, int freeSeats) {
		this.number = number;
		this.stations = stations;
		this.freeSeats = freeSeats;
	}

	public List<Station> getStations() {
		return new ArrayList<Station>(stations);
	}
	
	public Station getStationByLocation(String location) {
		for(Station station: stations) {
			if(station.getLocation().startsWith(location)) {
				return station;
			}
		}
		return null;
	}
	
	public int getFreeSeats() {
		return freeSeats;
	}
	
	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "¹" + number + " (" + stations.get(0).getLocation() + " - " 
				+ stations.get(stations.size()-1).getLocation() + ")";
	}	
	
	

}
