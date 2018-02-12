package trains;

public class Test {

	public static void main(String[] args) {
		TicketService ts = new TicketService();
		initTicketServiceTest(ts);
		System.out.println(ts.searchTrainsByDate("Lviv", new Time(15, 00)));
		System.out.println(ts.searchTrainsByLocation("Ternopil", "Khmelnitsky"));
		System.out.println(ts.searchNearestTrains("Lv", 5));

	}

	private static void initTicketServiceTest(TicketService ts) {
		TrainBuilder tb = new TrainBuilder();
		tb.setNumber(345);
		tb.setNextStation("Lviv", new Time(17, 00), new Time(17, 15));
		tb.setNextStation("Ternopil", new Time(19, 30), new Time(19, 40));
		tb.setNextStation("Khmelnitsky", new Time(21, 00), new Time(22, 00));
		tb.setFreeSeats(2);
		ts.addTrain(tb.build());

		tb.clear();
		tb.setNumber(321);
		tb.setNextStation("Kherson", new Time(14, 00), new Time(14, 15));
		tb.setNextStation("Mykolayiv", new Time(17, 00), new Time(17, 05));
		tb.setNextStation("Kyiv", new Time(23, 00), new Time(00, 45));
		tb.setFreeSeats(10);
		ts.addTrain(tb.build());

		tb.clear();
		tb.setNumber(123);
		tb.setNextStation("Lviv", new Time(14, 00), new Time(14, 15));
		tb.setNextStation("Zhytomyr", new Time(20, 00), new Time(20, 05));
		tb.setNextStation("Kyiv", new Time(23, 00), new Time(00, 45));
		tb.setFreeSeats(10);
		ts.addTrain(tb.build());
	}

}
