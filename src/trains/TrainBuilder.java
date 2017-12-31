package trains;

import java.util.ArrayList;
import java.util.List;

public class TrainBuilder {
	private List<Station> stations;
	private int number;
	
	public TrainBuilder() {
		stations = new ArrayList<Station>();
		number=0;
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
	
	public Train build() {
		return new Train(number, new ArrayList<Station>(stations));
	}
	
	public void clear() {
		stations = new ArrayList<Station>();
		number=0;
	}
}
