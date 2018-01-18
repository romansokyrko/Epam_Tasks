package generics;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class NumberOfElements {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(2);
		list.add(10);
		list.add(7);
		System.out.println(countIf(list, new OddPredicate()));

	}

	public static <T> int countIf(Collection<T> col, UnaryPredicate<T> predicate) {
		int result = 0;
		for (T element : col) {
			if (predicate.test(element))
				result++;
		}
		return result;
	}
}
