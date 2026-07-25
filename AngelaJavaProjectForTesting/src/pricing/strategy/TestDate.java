package pricing.strategy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) throws Exception {
		System.out.println(getProcessDate());

	}
	public static String getProcessDate() throws Exception {
		String currDt = getCurrDate();
		int hour = Integer.parseInt(getCurrentHour());
//		System.out.println(hour); 
		//after 2pm, consider it next day
//		if(hour>14)
//			return addDays(1, currDt);
//		else
			return currDt;
	}
	public static String getCurrentHour() {
		String rv = null;
		SimpleDateFormat OutFormat = new SimpleDateFormat("HH");
		rv = OutFormat.format(new Date());
		return rv;
	}
	public static String getCurrDate() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currDate = new Date();
		String currDtFmt = dateFormat.format(currDate);
		return currDtFmt;
	}	
}
