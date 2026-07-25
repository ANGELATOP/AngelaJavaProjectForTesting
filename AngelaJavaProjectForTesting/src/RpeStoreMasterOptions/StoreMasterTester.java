package RpeStoreMasterOptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreMasterTester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String test = "";
		System.out.println("size is "+test.length());
		
		
		System.out.println(getCurrHourMinsSec());

	}
	public static String getCurrHourMinsSec() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

		Date currDate = new Date();
		String currDtFmt = dateFormat.format(currDate);

		return currDtFmt;
	}
}
