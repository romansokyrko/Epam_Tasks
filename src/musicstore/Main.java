package musicstore;

import musicstore.comparator.ComparatorByGenre;
import musicstore.model.ClassicGenre;
import musicstore.model.Composition;
import musicstore.model.RockGenre;
import musicstore.model.SoundtrackGenre;
import musicstore.service.MusicStore;

public class Main {
	public static void main(String[] args) {
		MusicStore ms = new MusicStore();
		initTest(ms);
		System.out.println(ms.getCompositions());
		ms.setSortStrategy(new ComparatorByGenre());
		System.out.println(ms.getCompositions());
		System.out.println(ms.getCDFormatCompositionsbyGenre("Rock music"));
	}

	private static void initTest(MusicStore ms) {
		ms.addComposition(new Composition(new RockGenre("Highway 61 Revisited"), "Bob Dylan", "Like a Rolling Stone", 300));
		ms.addComposition(new Composition(new RockGenre(), "Bob Dylan", "Blowing in the Wind", 700));
		ms.addComposition(new Composition(new SoundtrackGenre("La-la-land"), "Ryan Gosling", "Sity of Stars", 200));
		ms.addComposition(new Composition(new ClassicGenre(), "Richard Wagner", "Ride of the Valkyries", 350));

	}
}
