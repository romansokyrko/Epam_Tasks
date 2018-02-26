package musicstore.model;

public class Composition implements IComposition {
	
	private Genre genre;
	private String artist;
	private String name;
	private int duration; //TODO: may be separate class
	

	public Composition(Genre genre, String artist, String name, int duration) {
		this.genre = genre;
		this.artist = artist;
		this.name = name;
		this.duration = duration;
	}
	
	@Override
	public Genre getGenre() {
		return genre;
	}

	@Override
	public String getArtist() {
		return artist;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getDuration() {
		return duration;
	}

	@Override
	public String getGenreName() {
		return genre.getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + duration;
		result = prime * result + ((genre == null) ? 0 : genre.getName().hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Composition other = (Composition) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (duration != other.duration)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.getName().equals(other.genre.getName()))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Composition [artist=" + artist + ", name=" + name + ", duration=" + duration + ", genre="
				+ getGenreName() + "]";
	}
	


}
