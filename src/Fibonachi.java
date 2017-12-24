
public class Fibonachi {

	public static void main(String[] args) {
		printFibonachi(50);

	}

	private static void printFibonachi(int count) {
		long first = 1;
		long second = 1;
		System.out.println(first);
		System.out.println(second);
		for(int i =0; i<count; i++) {
			long third = first + second;
			first = second;
			second = third;
			System.out.println(second);
		}
		
	}
	
	

}
