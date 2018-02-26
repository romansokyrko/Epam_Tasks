package musicstore.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import musicstore.comparator.CompositionComparator;
import musicstore.model.IComposition;

public class MusicStore {
	private Set<IComposition> compositions;
	private CompositionComparator sortStrategy;

	public MusicStore(Set<IComposition> compositions) {
		this.compositions = new LinkedHashSet<>(compositions);
		this.sortStrategy = null;
	}
	
	public MusicStore() {
		compositions = new LinkedHashSet<>();
	}

	public void addComposition(IComposition composition) {
		compositions.add(composition);
	}
	
	public Set<IComposition> getCompositionsbyArtist (String artist){
		Set<IComposition> result = new HashSet<>();
		for(IComposition each: compositions) {
			if(each.getArtist().equals(artist)) {
				result.add(each);
			}
		}
		return result;
	}
	
	public Set<IComposition> getCompositionsbyGenre (String genre){
		Set<IComposition> result = new HashSet<>();
		for(IComposition each: compositions) {
			if(each.getGenreName().equals(genre)) {
				result.add(each);
			}
		}
		return result;
	}
	
	public Set<IComposition> getCompositionsbyName (String name){
		Set<IComposition> result = new HashSet<>();
		for(IComposition each: compositions) {
			if(each.getName().equals(name)) {
				result.add(each);
			}
		}
		return result;
	}
	
	
	public List<IComposition> getCompositions(Comparator<IComposition> comparator){
		List<IComposition> result = new ArrayList<>(compositions);
		Collections.sort(result, comparator);
		return result;
	}
	
	public List<IComposition> getCompositions(){
		List<IComposition> result = new ArrayList<>(compositions);
		if(sortStrategy != null) {
			Collections.sort(result, sortStrategy);
		}
		return result;
	}


	
	public Set<IComposition> getCDFormatCompositionsbyGenre(String genre){ 
		Set<IComposition> result = new HashSet<>();
		for(IComposition each: compositions) {
			if(each.getGenreName().equals(genre) && each.getDuration()<=600) {
				result.add(each);
			}
		}
		return result;
	}
	
	public void setSortStrategy(CompositionComparator sortStrategy) {
		this.sortStrategy = sortStrategy;
	}
	
}
