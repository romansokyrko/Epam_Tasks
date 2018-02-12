package trains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketService {
	List<Train> trains;
	
	public TicketService() {
		trains = new ArrayList<Train>();
	}
	
	public void addTrain(Train train) {
		trains.add(train);
	}
	
	public List<Train> searchTrainsByLocation(String from, String to) {
		int fromInx;
		int toInx;
		List<Train> searchResult = new ArrayList<Train>();
		for(Train train: trains) {
			fromInx=-1;
			toInx=-1;
			List<Station> stations = train.getStations();
			int i=0;
			for(Station station: stations) {
				i++;
				if(station.getLocation().equals(from)) {
					fromInx=i;
				}
				if(station.getLocation().equals(to)) {
					toInx=i;
				}
			}
			if(fromInx>-1 && toInx>fromInx) {
				searchResult.add(train);
			}

		}
		return searchResult;
	}
	
	public List<Train> searchTrainsByDate(String from, Time dispTime){
		List<Train> searchResult = new ArrayList<Train>();
		for(Train train: trains) {
			List<Station> stations = train.getStations();
			for(Station station: stations) {
				if(station.getLocation().equals(from) && station.getDispatchTime().compareTo(dispTime)>0) {
					searchResult.add(train);
					break;
				}
			}
		}
		return searchResult;
	}
	
	public List<Train> searchNearestTrains(String from, int freeSeats){
		List<Train> searchResult = new ArrayList<Train>();
		
		for(Train train: trains) {
			Date currDate = new Date(System.currentTimeMillis());
			Time currTime = new Time(currDate.getHours(), currDate.getMinutes());
			if(train.getStationByLocation(from)!=null && 
					train.getStationByLocation(from).getDispatchTime().compareTo(currTime)>0 &&
					freeSeats<train.getFreeSeats()) {
				searchResult.add(train);
			}
				
		}
		for(int i=0; i<searchResult.size()-1; i++) {
			for(int j=i+1; j<searchResult.size(); j++) {
				if(searchResult.get(i).getStationByLocation(from).getDispatchTime().compareTo(searchResult.get(j).getStationByLocation(from).getDispatchTime())>0) {
					Train temp = searchResult.get(i);
					searchResult.set(i, searchResult.get(j));
					searchResult.set(j, temp);
				}
			}
		}
		return searchResult;
	}
}
