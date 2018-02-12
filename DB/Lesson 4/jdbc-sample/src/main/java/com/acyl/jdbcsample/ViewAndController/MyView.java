package com.acyl.jdbcsample.ViewAndController;

import com.acyl.jdbcsample.model.*;
import com.acyl.jdbcsample.model.metadata.TableMetaData;
import com.acyl.jdbcsample.persistant.ConnectionManager;
import com.acyl.jdbcsample.service.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

public class MyView {
	private Map<String, String> menu;
	private Map<String, Printable> methodsMenu;
	private static Scanner input = new Scanner(System.in);

	public MyView() {
		menu = new LinkedHashMap<>();
		methodsMenu = new LinkedHashMap<>();
		menu.put("A", "   A - Select all table");
		menu.put("B", "   B - Select structure of DB");

		menu.put("1", "   1 - Table: Company");
		menu.put("11", "  11 - Create for Company");
		menu.put("12", "  12 - Update Company");
		menu.put("13", "  13 - Delete from Company");
		menu.put("14", "  14 - Select Company");
		menu.put("15", "  15 - Find Company by ID");

		menu.put("2", "   2 - Table: Passenger");
		menu.put("21", "  21 - Create for Passenger");
		menu.put("22", "  22 - Update Passenger");
		menu.put("23", "  23 - Delete from Passenger");
		menu.put("24", "  24 - Select Passenger");
		menu.put("25", "  25 - Find Passenger by ID");

		menu.put("3", "   3 - Table: Trip");
		menu.put("31", "  31 - Create for Trip");
		menu.put("32", "  32 - Update Trip");
		menu.put("33", "  33 - Delete from Trip");
		menu.put("34", "  34 - Select Trip");
		menu.put("35", "  35 - Find Trip by ID");

		menu.put("4", "   4 - Table: Pass_in_trip");
		menu.put("41", "  41 - Create for Pass_in_trip");
		menu.put("42", "  42 - Update Pass_in_trip");
		menu.put("43", "  43 - Delete from Pass_in_trip");
		menu.put("44", "  44 - Select Pass_in_trip");
		menu.put("45", "  45 - Find Pass_in_trip by ID");

		menu.put("Q", "   Q - exit");

		methodsMenu.put("A", this::selectAllTable);
		methodsMenu.put("B", this::takeStructureOfDB);

		methodsMenu.put("11", this::createForCompany);
		methodsMenu.put("12", this::updateCompany);
		methodsMenu.put("13", this::deleteFromCompany);
		methodsMenu.put("14", this::selectCompany);
		methodsMenu.put("15", this::findCompanyByID);

		methodsMenu.put("21", this::createForPassenger);
		methodsMenu.put("22", this::updatePassenger);
		methodsMenu.put("23", this::deleteFromPassenger);
		methodsMenu.put("24", this::selectPassenger);
		methodsMenu.put("25", this::findPassengerByID);

		methodsMenu.put("31", this::createForTrip);
		methodsMenu.put("32", this::updateTrip);
		methodsMenu.put("33", this::deleteFromTrip);
		methodsMenu.put("34", this::selectTrip);
		methodsMenu.put("35", this::findTripByID);

		methodsMenu.put("41", this::createForPassInTrip);
		methodsMenu.put("42", this::updatePassInTrip);
		methodsMenu.put("43", this::deleteFromPassInTrip);
		methodsMenu.put("44", this::selectPassInTrip);
	}

	private void selectAllTable() throws SQLException {
		selectCompany();
		selectPassenger();
		selectTrip();
		selectPassInTrip();
	}

	private void takeStructureOfDB() throws SQLException {
		Connection connection = ConnectionManager.getConnection();
		MetaDataService metaDataService = new MetaDataService();
		List<TableMetaData> tables = metaDataService.getTablesStructure();
		System.out.println("TABLE OF DATABASE: " + connection.getCatalog());

		for (TableMetaData table : tables) {
			System.out.println(table);
		}
	}

	private void deleteFromCompany() throws SQLException {
		System.out.println("Input ID(ID_comp) for Company: ");
		Integer id = input.nextInt();
		input.nextLine();
		CompanyService companyService = new CompanyService();
		int count = companyService.delete(id);
		System.out.printf("There are deleted %d rows\n", count);
	}

	private void createForCompany() throws SQLException {
		System.out.println("Input ID(ID_comp) for Company: ");
		Integer id = input.nextInt();
		input.nextLine();
		System.out.println("Input name for Company: ");
		String name = input.nextLine();
		CompanyEntity entity = new CompanyEntity(id, name);

		CompanyService companyService = new CompanyService();
		int count = companyService.create(entity);
		System.out.printf("There are created %d rows\n", count);
	}

	private void updateCompany() throws SQLException {
		System.out.println("Input ID(ID_comp) for Company: ");
		Integer id = input.nextInt();
		input.nextLine();
		System.out.println("Input name for Company: ");
		String name = input.nextLine();
		CompanyEntity entity = new CompanyEntity(id, name);

		CompanyService companyService = new CompanyService();
		int count = companyService.update(entity);
		System.out.printf("There are updated %d rows\n", count);
	}

	private void selectCompany() throws SQLException {
		System.out.println("\nTable: Company");
		CompanyService companyService = new CompanyService();
		List<CompanyEntity> companies = companyService.findAll();
		for (CompanyEntity entity : companies) {
			System.out.println(entity);
		}
	}

	private void findCompanyByID() throws SQLException {
		System.out.println("Input ID(ID_comp) for Company: ");
		Integer id = input.nextInt();
		input.nextLine();
		CompanyService companyService = new CompanyService();
		CompanyEntity entity = companyService.findById(id);
		System.out.println(entity);
	}


	// ------------------------------------------------------------------------

	private void deleteFromPassenger() throws SQLException {
		System.out.println("Input ID(ID_psg) for Passenger: ");
		Integer id = input.nextInt();
		input.nextLine();
		PassengerService passengerService = new PassengerService();
		int count = passengerService.delete(id);
		System.out.printf("There are deleted %d rows\n", count);
	}

	private void createForPassenger() throws SQLException {
		System.out.println("Input ID(ID_psg) for Passenger: ");
		Integer id = input.nextInt();
		input.nextLine();
		System.out.println("Input name for Passenger: ");
		String name = input.nextLine();
		PassengerEntity entity = new PassengerEntity(id, name);
		PassengerService passengerService = new PassengerService();

		int count = passengerService.create(entity);
		System.out.printf("There are created %d rows\n", count);
	}

	private void updatePassenger() throws SQLException {
		System.out.println("Input ID(ID_psg) for Passenger: ");
		Integer id = input.nextInt();
		input.nextLine();
		System.out.println("Input name for Passenger: ");
		String name = input.nextLine();
		PassengerEntity entity = new PassengerEntity(id, name);
		PassengerService passengerService = new PassengerService();

		int count = passengerService.update(entity);
		System.out.printf("There are updated %d rows\n", count);
	}

	private void selectPassenger() throws SQLException {
		System.out.println("\nTable: Passenger");
		PassengerService passengerService = new PassengerService();
		List<PassengerEntity> passengers = passengerService.findAll();
		for (PassengerEntity entity : passengers) {
			System.out.println(entity);
		}
	}

	private void findPassengerByID() throws SQLException {
		System.out.println("Input ID(ID_psg) for Passenger: ");
		Integer id = input.nextInt();
		input.nextLine();
		PassengerService passengerService = new PassengerService();
		PassengerEntity entity = passengerService.findById(id);
		System.out.println(entity);
	}


	// ------------------------------------------------------------------------

	private void updateTrip() throws SQLException {
		System.out.println("Input ID(trip_no) for Trip: ");
		Integer id = input.nextInt();
		input.nextLine();
		System.out.println("Input ID_comp for Trip: ");
		Integer idComp = input.nextInt();
		input.nextLine();
		System.out.println("Input plane for Trip: ");
		String plane = input.nextLine();
		System.out.println("Input town_from for Trip: ");
		String townFrom = input.nextLine();
		System.out.println("Input town_to for Trip: ");
		String townTo = input.nextLine();
		System.out.println("Input time_out for Trip: ");
		String strOut = input.nextLine();
		Date timeOut = Date.valueOf(strOut);
		System.out.println("Input time_in for Trip: ");
		String strIn = input.nextLine();
		Date timeIn = Date.valueOf(strIn);
		TripEntity entity = new TripEntity(id, idComp, plane, townFrom, townTo, timeOut, timeIn);

		TripService tripService = new TripService();
		int count = tripService.update(entity);
		System.out.printf("There are updated %d rows\n", count);
	}

	private void deleteFromTrip() throws SQLException {
		System.out.println("Input ID(trip_no) for Trip: ");
		Integer id = input.nextInt();
		input.nextLine();
		TripService tripService = new TripService();
		int count = tripService.delete(id);
		System.out.printf("There are deleted %d rows\n", count);
	}

	private void createForTrip() throws SQLException {
		System.out.println("Input ID(trip_no) for Trip: ");
		Integer id = input.nextInt();
		input.nextLine();
		System.out.println("Input ID_comp for Trip: ");
		Integer idComp = input.nextInt();
		input.nextLine();
		System.out.println("Input plane for Trip: ");
		String plane = input.nextLine();
		System.out.println("Input town_from for Trip: ");
		String townFrom = input.nextLine();
		System.out.println("Input town_to for Trip: ");
		String townTo = input.nextLine();
		System.out.println("Input time_out for Trip: ");
		String strOut = input.nextLine();
		Date timeOut = Date.valueOf(strOut);
		System.out.println("Input time_in for Trip: ");
		String strIn = input.nextLine();
		Date timeIn = Date.valueOf(strIn);
		TripEntity entity = new TripEntity(id, idComp, plane, townFrom, townTo, timeOut, timeIn);

		TripService tripService = new TripService();
		int count = tripService.create(entity);
		System.out.printf("There are created %d rows\n", count);
	}

	private void selectTrip() throws SQLException {
		System.out.println("\nTable: Trip");
		TripService tripService = new TripService();
		List<TripEntity> trips = tripService.findAll();
		for (TripEntity entity : trips) {
			System.out.println(entity);
		}
	}

	private void findTripByID() throws SQLException {
		System.out.println("Input ID(trip_no) for Trip: ");
		Integer id = input.nextInt();
		input.nextLine();
		TripService tripService = new TripService();
		TripEntity entity = tripService.findById(id);
		System.out.println(entity);
	}

	// ------------------------------------------------------------------------

	private void deleteFromPassInTrip() throws SQLException {
		System.out.println("Input ID(trip_no) for Pass_in_trip: ");
		Integer tripNo = input.nextInt();
		input.nextLine();
		System.out.println("Input ID(date) for Pass_in_trip: ");
		String str = input.nextLine();
		Date date = Date.valueOf(str);
		System.out.println("Input ID(ID_psg) for Pass_in_trip: ");
		Integer idPsg = input.nextInt();
		input.nextLine();
		PK_PassInTrip pk = new PK_PassInTrip(tripNo, date, idPsg);

		PassInTripService passInTripService = new PassInTripService();
		int count = passInTripService.delete(pk);
		System.out.printf("There are deleted %d rows\n", count);
	}

	private void createForPassInTrip() throws SQLException {
		System.out.println("Input ID(trip_no) for Pass_in_trip: ");
		Integer tripNo = input.nextInt();
		input.nextLine();
		System.out.println("Input ID(date) for Pass_in_trip: ");
		String str = input.nextLine();
		Date date = Date.valueOf(str);
		System.out.println("Input ID(ID_psg) for Pass_in_trip: ");
		Integer idPsg = input.nextInt();
		input.nextLine();
		PK_PassInTrip pk = new PK_PassInTrip(tripNo, date, idPsg);

		System.out.println("Input place for Pass_in_trip: ");
		String place = input.nextLine();

		PassInTripEntity entity = new PassInTripEntity(pk, place);
		PassInTripService passInTripService = new PassInTripService();
		int count = passInTripService.create(entity);
		System.out.printf("There are created %d rows\n", count);
	}

	private void updatePassInTrip() throws SQLException {
		System.out.println("Input ID(trip_no) for Pass_in_trip: ");
		Integer tripNo = input.nextInt();
		input.nextLine();
		System.out.println("Input ID(date) for Pass_in_trip: ");
		String str = input.nextLine();
		Date date = Date.valueOf(str);
		System.out.println("Input ID(ID_psg) for Pass_in_trip: ");
		Integer idPsg = input.nextInt();
		input.nextLine();
		PK_PassInTrip pk = new PK_PassInTrip(tripNo, date, idPsg);

		System.out.println("Input place for Pass_in_trip: ");
		String place = input.nextLine();

		PassInTripEntity entity = new PassInTripEntity(pk, place);
		PassInTripService passInTripService = new PassInTripService();
		int count = passInTripService.update(entity);
		System.out.printf("There are updated %d rows\n", count);
	}

	private void selectPassInTrip() throws SQLException {
		System.out.println("\nTable: Pass_in_trip");
		PassInTripService passInTripService = new PassInTripService();
		List<PassInTripEntity> pasees = passInTripService.findAll();
		for (PassInTripEntity entity : pasees) {
			System.out.println(entity);
		}
	}

	// -------------------------------------------------------------------------

	private void outputMenu() {
		System.out.println("\nMENU:");
		for (String key : menu.keySet())
			if (key.length() == 1)
				System.out.println(menu.get(key));
	}

	private void outputSubMenu(String fig) {

		System.out.println("\nSubMENU:");
		for (String key : menu.keySet())
			if (key.length() != 1 && key.substring(0, 1).equals(fig))
				System.out.println(menu.get(key));
	}

	public void show() {
		String keyMenu;
		do {
			outputMenu();
			System.out.println("Please, select menu point.");
			keyMenu = input.nextLine().toUpperCase();

			if (keyMenu.matches("^\\d")) {
				outputSubMenu(keyMenu);
				System.out.println("Please, select menu point.");
				keyMenu = input.nextLine().toUpperCase();
			}

			try {
				methodsMenu.get(keyMenu).print();
			} catch (Exception e) {
			}
		} while (!keyMenu.equals("Q"));
	}
}
