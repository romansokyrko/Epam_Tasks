package strings;

import java.util.Scanner;

public class TwoEqualsLetters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String inputSrting = null;
		StringBuilder sb = new StringBuilder("");
		while(in.hasNextLine()) {
			inputSrting = in.nextLine()+"\n";
			//if(inputSrting.equals("")) break;
			sb = sb.append(inputSrting);
		}
		in.close();
		
		for(int i=0; i<sb.length()-1; i++) {
			if(sb.charAt(i)==sb.charAt(i+1)) {
				sb.deleteCharAt(i+1);
				i--;
			}
		}
		System.out.println(sb);
	}

}
