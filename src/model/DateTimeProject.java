package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeProject {
	
	static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static String getCurrentDate() {
		LocalDateTime myDateObj = LocalDateTime.now();
	    String formattedDate = myDateObj.format(myFormatObj);
		
		return formattedDate; 
	}
	
	public static LocalDateTime parseLocalDateTime(String t) {
		LocalDateTime myDateObj = LocalDateTime.parse(t, myFormatObj);
		return myDateObj; 
	}
	

}
