package com.wpt.abhyas.model;
import java.util.Calendar;
import java.util.HashMap;

public class UniqueId {

	public static void main(String...str) {
		HashMap<Integer, Character> cMap = new HashMap<>();
		cMap.put(0, 'a');
		cMap.put(1, 'b');		 
		cMap.put(2, 'c');
		cMap.put(3, 'd');
		cMap.put(4, 'e');
		cMap.put(5, 'f');
		cMap.put(6, 'g');
		cMap.put(7, 'h');
		cMap.put(8, 'i');
		cMap.put(9, 'k');
		cMap.put(10, 'l');		 
		cMap.put(11, 'm');
		cMap.put(12, 'n');
		cMap.put(13, 'o');
		cMap.put(14, 'p');
		cMap.put(15, 'q');
		cMap.put(16, 'r');
		cMap.put(17, 's');
		cMap.put(18, 't');
		cMap.put(19, 'u');
		cMap.put(20, 'v');		 
		cMap.put(21, 'w');
		cMap.put(22, 'x');
		cMap.put(23, 'y');
		cMap.put(24, 'z');
		cMap.put(25, 'j');
		cMap.put(26, 'A');
		cMap.put(27, 'B');
		cMap.put(28, 'C');
		cMap.put(29, 'D');
		cMap.put(30, 'E');		 
		cMap.put(31, 'F');
		cMap.put(32, 'G');
		cMap.put(33, 'H');
		cMap.put(34, 'I');
		cMap.put(35, 'J');
		cMap.put(36, 'K');
		cMap.put(37, 'L');
		cMap.put(38, 'M');
		cMap.put(39, 'N');
		cMap.put(40, 'O');		 
		cMap.put(41, 'P');
		cMap.put(42, 'Q');
		cMap.put(43, 'R');
		cMap.put(44, 'S');
		cMap.put(45, 'T');
		cMap.put(46, 'U');
		cMap.put(47, 'V');
		cMap.put(48, 'W');
		cMap.put(49, 'X');
		cMap.put(50, 'Y');		 
		cMap.put(51, 'Z');
		cMap.put(52, '!');
		cMap.put(53, '@');
		cMap.put(54, '#');
		cMap.put(55, '$');
		cMap.put(56, '%');
		cMap.put(57, '^');
		cMap.put(58, '&');
		cMap.put(59, '*');
		
		Calendar calendar = Calendar.getInstance();
		
		System.out.println(cMap.get(calendar.get(Calendar.DAY_OF_MONTH)));
		System.out.println(cMap.get(calendar.get(Calendar.MONTH)));
		System.out.println(cMap.get(Integer.parseInt(new String(calendar.get(Calendar.YEAR)+"").substring(0,2))));
		System.out.println(cMap.get(Integer.parseInt(new String(calendar.get(Calendar.YEAR)+"").substring(2,4))));
		System.out.println(cMap.get(calendar.get(Calendar.HOUR)));
		System.out.println(cMap.get(calendar.get(Calendar.MINUTE)));
		System.out.println(cMap.get(calendar.get(Calendar.SECOND)));
	}
	
}
