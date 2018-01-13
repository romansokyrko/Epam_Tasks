package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StringFormating {
	

	public static void main(String[] args) {
		int lineSize = 10;
		Scanner in = new Scanner(System.in);
		String inputSrting = null;
		StringBuilder sb = new StringBuilder("");
		while(in.hasNextLine()) {
			inputSrting = in.nextLine();
//			if(inputSrting.isEmpty()) break;
			sb = sb.append("\n" +inputSrting);
		}
		in.close();
		
		// TODO: Доробити умови і розбити на методи
		List<String> lines = new ArrayList<String>();
		int beginIndx=0;
		int endIndx=lineSize-1;
		while(beginIndx<sb.length()) {
			
			if(endIndx>=sb.length()) {
				endIndx=sb.length();
			}
			else if(sb.charAt(endIndx)!=' ') {
				while(sb.charAt(endIndx-1)!=' ') {
					endIndx--;
					if(endIndx==beginIndx) {
						endIndx=beginIndx+lineSize-1;
						break;
					}
				}
			}
			if(beginIndx>=sb.length()-1) break;
			String line = sb.substring(beginIndx, endIndx);
			StringBuilder lineBuilder = new StringBuilder(line.trim());
			
			int spaces = lineSize-(lineBuilder.length());
			for(int i =0; i<=spaces; i++) {
				lineBuilder.insert(0, ' ');
			}
			lines.add(lineBuilder.toString());
			beginIndx = endIndx;
			endIndx=lineSize+beginIndx;
			
		}
		
		for(String line: lines) {
			System.out.println(line);
		}
	}

}
