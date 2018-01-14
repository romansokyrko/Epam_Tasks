package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StringFormating {
	

	public static void main(String[] args) {
		int lineSize = 20;
		Scanner in = new Scanner(System.in);
		String inputSrting = null;
		StringBuilder sb = new StringBuilder("");
		while(in.hasNextLine()) {
			inputSrting = in.nextLine();
//			if(inputSrting.isEmpty()) break;
			sb = sb.append(inputSrting+ "\n");
		}
		in.close();
		 
		List<String> lines = rightAlignment(sb.toString(), lineSize);
				
		for(String line: lines) {
			System.out.println(line);
		}
	} 
	
	public static List<String> rightAlignment(String text, int lineSize){
		String[] inputLines = text.split("\n");
		List<String> lines = new ArrayList<String>();
		for(String inputLine: inputLines) {
			int beginIndx=0;
			int endIndx=lineSize;
			while(beginIndx<inputLine.length()) { 
				if(endIndx>=inputLine.length()) {
					endIndx=inputLine.length();
				}
				else if(inputLine.charAt(endIndx)!=' ') {
					while(inputLine.charAt(endIndx-1)!=' ') {
						endIndx--;
						if(endIndx==beginIndx) {
							endIndx=beginIndx+lineSize;
							break;
						}
					}
				} 
				if(beginIndx>=inputLine.length()-1) break;
				String line = inputLine.substring(beginIndx, endIndx);
				StringBuilder lineBuilder = new StringBuilder(line.trim());
				
				lineBuilder = fillLineWithSpaces(lineBuilder, lineSize);
				lines.add(lineBuilder.toString());
				beginIndx = endIndx;
				endIndx=lineSize+beginIndx;
				
			}
		}
		return lines;
	}
	
	public static StringBuilder fillLineWithSpaces(StringBuilder sb, int lineSize) {
		int spaces = lineSize-(sb.length());
		for(int i =0; i<=spaces-1; i++) {
			sb.insert(0, ' ');
		}
		return sb;
	}
   
}
