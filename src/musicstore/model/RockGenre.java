package musicstore.model;

public class RockGenre implements Genre {
	
	private String album;

	public RockGenre() {
		album="";
	}
	
	public RockGenre(String album) {
		this.album = album;
	}
	
	@Override
	public String getName() {
		return "Rock music";
	}



	public String getAlbum() {
		return album;
	}




}
