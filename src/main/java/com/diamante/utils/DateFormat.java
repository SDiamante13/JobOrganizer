package com.diamante.utils;

import java.time.LocalDate;

public class DateFormat {
	
	public static LocalDate DateConverter(String dateStr) {
		LocalDate date = null;
		String [] datesSplit = dateStr.split("-");
		if(datesSplit.length == 3) {
			date = LocalDate.of(Integer.parseInt(datesSplit[0]), Integer.parseInt(datesSplit[1]), Integer.parseInt(datesSplit[2]));
		}
		return date;	
	}
	
	public static LocalDate DateConverterAdd(String dateStr) {
		LocalDate date = null;
		String [] datesSplit = dateStr.split("-");
		if(datesSplit.length < 3) { // date is not formatted correctly
			datesSplit = dateStr.split("/");
		}
		if(datesSplit.length == 3) {
			date = LocalDate.of(Integer.parseInt(datesSplit[0]), Integer.parseInt(datesSplit[1]), Integer.parseInt(datesSplit[2]));
		}
		return date;	
	}
}
