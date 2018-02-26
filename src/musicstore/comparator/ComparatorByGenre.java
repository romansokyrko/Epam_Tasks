package musicstore.comparator;

import musicstore.model.IComposition;

public class ComparatorByGenre implements CompositionComparator{

	@Override
	public int compare(IComposition o1, IComposition o2) {
		return o1.getGenreName().compareTo(o2.getGenreName());
	}
	
}
