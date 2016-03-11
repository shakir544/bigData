package org.sgooty.warmup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class TimeCoversion {
	
	// Given a time in AM/PM format, convert it to military (24-hour) time.
	
	public static void main(String args[]) throws ParseException { 
		Scanner scan = new Scanner(System.in);
		String date = scan.next();
		
		SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm");
		SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm aa");
		
		Date result = inputFormat.parse(date);
		
		System.out.println(outputFormat.format(result));
	}



}
