package refactoring;

public class Movie {
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private Price _price;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public void setPriceCode(int arg) {
		switch (arg) {
		case Movie.REGULAR:
			_price=new RegularPrice();
			break;
		case Movie.NEW_RELEASE:
			_price=new NewReleasePrice();
		case Movie.CHILDREN:
			_price=new ChildrensPrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
		
	}

	public String getTitle() {
		return _title;
	}
	
	public double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}
	
	public int getFrequentRenterPoints(int daysRented) {
		return _price.getFrequentRenterPoints(daysRented);
	}
}