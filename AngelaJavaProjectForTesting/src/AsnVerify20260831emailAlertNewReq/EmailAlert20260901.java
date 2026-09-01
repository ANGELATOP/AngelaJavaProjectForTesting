package AsnVerify20260831emailAlertNewReq;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailAlert20260901 {

	public static void main(String[] args) throws ParseException {
		System.out.println("isItTime:"+isProcessTime("2026-08-31 17:00"));
	}

	public static String isProcessTime(String runTime) {

		String currDateString = getCurrentDateTime();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime1 = LocalDateTime.parse(runTime, formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse(currDateString, formatter);

		// Calculate the difference in minutes
		long minutesDiff = Duration.between(dateTime1, dateTime2).toMinutes();

		// Output the result
		System.out.println("Difference between the two dates in minutes: " + minutesDiff);
		
		if (minutesDiff > 30)
			return "process";
		else
			return "notTime";
	}
	private static String getCurrentDateTime() {
		Date currentDate = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return fmt.format(currentDate);
	}
	private static String convertToStringDateFmt() {
		Date currentDate = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return fmt.format(currentDate);
	}



	private static String convertToStringDate(Date inputDate) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS");
		return fmt.format(inputDate);
	}
}
