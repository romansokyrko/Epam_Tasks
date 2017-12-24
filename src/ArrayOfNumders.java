import java.util.Arrays;
import java.util.Scanner;

public class ArrayOfNumders {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array =  new int[5];
		

		for(int n =0; n<5; n++) {
			System.out.println("Enter " + (n+1) + " number");
			int i = scanner.nextInt();
			while(i<9999) {
				System.out.println("Enter number with at least 5 digitals!!!");
				i = scanner.nextInt();
			}
			array[n]=i;	
		}
		scanner.close();

		System.out.println("Sorted array: " +Arrays.toString(sort(array)));
		System.out.println("Numbers with sorted digatals:");
		for(int i = 0; i<array.length; i++) {
			if(isDigitalsSorted(array[i])) {
				System.out.println(array[i]);
			}
		}
		System.out.println("Numbers with simple digitals:");
		for(int i = 0; i<array.length; i++) {
			if(contentsSimpleNumders(array[i])) {
				System.out.println(array[i]);
			}
		}
		System.out.println("Numbers, divided by others:");
		dividedNumbers(array);
	}

	private static void dividedNumbers(int[] array) {
		for(int i = 1; i<array.length; i++) {
			for(int j= 0; j<i; j++) {
				if(array[i]%array[j]==0) {
					System.out.println(array[i]);
					break;
				}
			}

		}
		
	}

	private static boolean contentsSimpleNumders(int n) {
		int simpleNumbers[]= {2, 3, 5, 7};
		while(n!=0) {
			int mod = n%10;
			for(int i=0; i<simpleNumbers.length; i++) {
				if(mod==simpleNumbers[i]) return true;
			}
			n=n/10;
		}
		return false;
		
	}

	private static boolean isDigitalsSorted(int i) {
		int div=i/10;
		int mod = i%10;
		while(div!=0) {
			if(div%10>mod)
				return false;
			mod = div%10;
			div = div/10;
		}
		return true;
	}

	private static int[] sort(int[] array) {
		for(int i =0; i<array.length-1; i++) {
			for( int j =i+1; j <array.length; j++) {
				if(array[i]>array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;	
	}
	
	
	
	

}
