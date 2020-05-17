package com.wpt.abhyas;

import java.util.ArrayList;

public class Tester {

	static String refValue = "";

	public static void main(String... strings) {

		System.out.println(bin(3));

	}

	static Long bin(long a) {

		for(long i=1;i<=a;i++)
		bin2(i);
		
		
		System.out.println(refValue);
		Long result = Long.parseLong(refValue, 2);
		return result;
	}

	static void bin2(long a) {

		if (a > 1)
			bin2(a / 2);

		refValue = refValue + a % 2;

	}

}