package trains;

import java.util.ArrayList;
import java.util.List;

public class TrainBuilder {
	private List<Station> stations;
	private int number;
	private int freeSeats;
	
	public TrainBuilder() {
		stations = new ArrayList<Station>();
		number=0;
		freeSeats=0;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setNextStation(Station station) {
		stations.add(station);
	}
	
	public void setNextStation(String location, Time arriveTime, Time dispatchTime) {
		stations.add(new Station(location, arriveTime, dispatchTime));
	}
	
	public int getFreeSeats() {
		return freeSeats;
	}

	public void setFreeSeats(int freeSeats) {
		this.freeSeats = freeSeats;
	}

	public Train build() {
		return new Train(number, new ArrayList<Station>(stations), freeSeats);
	}
	
	public void clear() {
		stations = new ArrayList<Station>();
		number=0;
		freeSeats=0;
	}
}
