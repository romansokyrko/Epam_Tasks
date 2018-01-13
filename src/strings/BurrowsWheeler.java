package strings;

import java.util.Scanner;

public class BurrowsWheeler {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String inputSrting = in.nextLine();
		in.close();
		String[] words = shiftWord(inputSrting);
		System.out.println("Shifted words:" );
		for(String word: words) {
			System.out.println(word);
		}
		words = sort(words);
		System.out.println("Sorted words:" );
		for(String word: words) {
			System.out.println(word);
		}
		System.out.println("Last letters:" );
		for(String word: words) {
			System.out.println(word.charAt(word.length()-1));
		}

	}

	private static String[] sort(String[] words) {
		for(int i = 0; i<words.length-1; i++) {
			for(int j = i+1; j<words.length; j++) {
				if(words[i].compareTo(words[j])>1) {
					String temp = words[i];
					words[i] = words[j];
					words[j]=temp;
				}
			}
		}
		return words;
	}

	private static String[] shiftWord(String inputSrting) {
		StringBuilder wordBuilder = new StringBuilder(inputSrting);
		String[] words = new String[inputSrting.length()];
		words[0]=inputSrting;
		for(int i = 1; i<words.length; i++) {
			wordBuilder.append(wordBuilder.charAt(0));
			wordBuilder.deleteCharAt(0);
			words[i]=wordBuilder.toString();
			
		}
		return words;
	}

}
