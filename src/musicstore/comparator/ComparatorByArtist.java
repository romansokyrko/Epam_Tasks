package musicstore.comparator;

import musicstore.model.IComposition;

public class ComparatorByArtist implements CompositionComparator{

	@Override
	public int compare(IComposition o1, IComposition o2) {
		return o1.getArtist().compareTo(o2.getArtist());
	}
	
}
