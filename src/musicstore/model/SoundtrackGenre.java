package musicstore.model;

public class SoundtrackGenre implements Genre {
	
	private String movieName;

	public SoundtrackGenre(String movieName) {
		this.movieName = movieName;
	}

	@Override
	public String getName() {
		return "OST";
	}
	
	public String getMovieName() {
		return movieName;
	}

}
