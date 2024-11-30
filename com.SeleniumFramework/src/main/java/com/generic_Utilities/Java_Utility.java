package com.generic_Utilities;

import java.util.Date;

public class Java_Utility {

	public static String getCurentTime() {
		
		String time = new Date().toString().replace(' ', '_').replace(':', '_');
		return time;
	}
}