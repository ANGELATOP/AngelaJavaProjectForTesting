package warehouse.prod20260802laptop;

import java.util.ArrayList;
import java.util.List;

public class ParseFile202600802 {

//	static String directory = "C:\\Users\\atopp\\Downloads\\googleMsgs\\input\\";
	
	static String directory = "C:\\Users\\atopp\\Documents\\eclipseWorkspace202607_git\\AngelaJavaProjectForTesting\\AngelaJavaProjectForTesting\\src\\warehouse\\prod20260802laptop\\";
	static String outputDir = "C:\\Users\\atopp\\Documents\\eclipseWorkspace202607_git\\AngelaJavaProjectForTesting\\AngelaJavaProjectForTesting\\src\\warehouse\\prod20260802laptop\\";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("start");
		process("ASN Verify PO 65069.json");
		
//		getKeyInfoAsnVerify("asnVerifyMsg3_po_23962_hasDeletedPoLines.json");

//		getKeyInfoAsnVerifySpecificMessages("2026-04-07 group 2b asn manhattan msg-soapUI.json","\"AsnSequenceNumber\": \"001\"");

//		getKeyInfoInvAdjust("2026-04-02 group 1b - invAdjust manhattan msg.json");	
		System.out.println("stop");
		
	}
	public static String rightPadd(String inputValue, int maxSize) {
		int inputValueSize = inputValue.length();
		StringBuilder newValue = new StringBuilder();
		int diff = maxSize-inputValueSize;
		for(int i=0;i<diff;i++)
			newValue.append(" ");
		
		return inputValue+newValue.toString();
	}
	public static void process(String googleFileNm) throws Exception {
		
		List<String> output = RetrieveTextFile.retrieveTextFile(directory+googleFileNm);
		List<String> temp = new ArrayList<String>();
		
		boolean currRec = false;
		String currMsg="";
		int counter=100;
		int elementCnter=0;
		
		List<String> list = new ArrayList<String>();
		
		StringBuilder text = new StringBuilder();
		int totalAttributes=1;
		
		String previousItemId="none";
		
	    for(String x:output){
	    	temp = new ArrayList<String>();
	    	
	    	if(x.contains("ASN_Level")) {
	    		//skip
	    	}else
	    	if(x.contains("ITEM_Level") || x.contains("LPN_Level") )   
	    	{
	    		System.out.println( text.toString());
	    		text = new StringBuilder();
	    		
	    		if(x.contains("CatchWeight_ITEM_Level"))
	    		    text.append(x.trim()+"  ");
	    		else
	    		if(x.contains("ITEM_Level"))
	    		    text.append(x.trim()+"              ");
	    		else
	    		if(x.contains("LPN_Level"))
		    		text.append(x.trim()+"               ");
	    		else
	    		    text.append("Unknown Message Type");

	    		
	    		list.add(x.trim());
	    		currRec=true;
	    		currMsg=x.trim();
	    		
	    		

	    	}
	    	
	    	if(x.contains("ASN_Level")) {
	    		//skip
	    	}else
	    	if(currRec==true) {
	    		if(x.contains("ItemId")){
	    			if(x.contains(previousItemId)) {
		    		text.append(x.trim()+"    ");
	    			}
	    			else {
	    				System.out.println(""); //blank line break
	    				previousItemId=x;
			    		text.append(x.trim()+"    ");
	    			}
	    			
	    		}
		    	if(x.contains("ItemId") || 
//		    	   x.contains("AsnSequenceNumber")  ||        //commented out so I can focuse on the fields I care about
//		    	   x.contains("AsnId")  || 
//   	    	   x.contains("AttributeName")  || 
//		    	   x.contains("AttributeValue")  || 
//		    	   x.contains("AttributeUom")  || 
//		    	   x.contains("UnitsShipped")  || 
		    	   x.contains("UnitsReceived")) {
		    		elementCnter=elementCnter+1;

		    		text.append(rightPadd(x.trim(),30));
		    		list.add(x.trim());
		    		totalAttributes=totalAttributes+1;
		    	}
		    	if(x.contains("AsnSequenceNumber")) {
		    		if(currMsg.contains("LPN_Level")) {
			    		elementCnter=elementCnter+1;

			    		text.append(rightPadd(x.trim(),30));
			    		list.add(x.trim());
			    		totalAttributes=totalAttributes+1;
		    			
		    		}else
		    		{
			    		elementCnter=elementCnter+1;

			    		text.append(rightPadd(x.trim(),30));
			    		list.add(x.trim());
			    		totalAttributes=totalAttributes+1;
		    			
		    		}
		    	} 
	    	}
   	  }
	    
	    
    	//display last row
		System.out.println(text.toString());

		
//    	for(String t:list)
//    		System.out.println(t);
	}
	public static void getKeyInfoAsnVerify(String googleFileNm) throws Exception {
		//get the info that I need to look at
		
		List<String> output = RetrieveTextFile.retrieveTextFile(directory+googleFileNm);
		boolean skip = false;
		
	    for(String x:output){
	    	if(x.contains("Messages")) {
	    		//new message group
//	    		System.out.println("\"----------------------------------------------- ");//add blank line
	    		skip = false;
	    	}else
	    	if(x.contains("LPN_Level")) {
	    		skip = true; //no need to view this data
	    	}else
	    	if(skip==false){
	    		displayInfo(x);
	    	}

   	    }
	}
	public static void getKeyInfoAsnVerifySpecificMessages(String googleFileNm, String criteria) throws Exception {
		//get the info that I need to look at
		
		List<String> output = RetrieveTextFile.retrieveTextFile(directory+googleFileNm);
		boolean skip = false;
		
		
		List<String> specificMessage = new ArrayList<String>();
		boolean foundSpecificMessage = false;
		
	    for(String x:output){
	    	if(x.contains("Messages")) {
	    		//new message group
//	    		System.out.println("\"----------------------------------------------- ");//add blank line
	    		skip = false;
	    		if(foundSpecificMessage==true) {
	    			for(String t:specificMessage) {
//	    				displayInfo(t);
	    				System.out.println(t);
	    			}
        		}
	    		specificMessage = new ArrayList<String>();
	    		foundSpecificMessage = false;
	    	}else
	    	if(x.contains("LPN_Level")) {
	    		skip = true; //no need to view this data
	    	}else
	    	if(x.contains(criteria)){
	    		foundSpecificMessage=true;
	    		specificMessage.add(x);	
	    	}else
	    	if(skip==false){
	    		specificMessage.add(x);	
	    	}

   	    }
	    //get last set
		if(foundSpecificMessage==true) {
			for(String t:specificMessage) {
//				displayInfo(t);
				System.out.println(t);
			}
		}
	    
	}	
	private static void displayInfo(String x) throws Exception {
		List temp = new ArrayList();
		temp = splitString(":",x);
		if(temp.size()>0) {
			if(temp.size()>1) {
				String test = (String)temp.get(1);
				if(!test.contains("\"\"")) {
					System.out.println(x);
				}
			}else
			{
				System.out.println(x);
			}
		}else
		{
			System.out.println(x);
		}
	}
	
	public static void getKeyInfoInvAdjust(String googleFileNm) throws Exception {
		//get the info that I need to look at
		
		List<String> output = RetrieveTextFile.retrieveTextFile(directory+googleFileNm);
		
	    for(String x:output){
	    	if(x.contains("Messages")) {
	    		//skip
	    	}else
	    	{
	    		displayInfo(x);
	    	}
   	    }
	}	
	private static String appendSpaces(String value, int total) {
		int valueLength = value.length();
		
		int diff = total - valueLength;
		StringBuilder spaces = new StringBuilder();
		spaces.append("");
		for(int i=0;i<total;i++) {
			spaces.append(" ");
		}
		
		return value+spaces.toString();
	}
	private static ArrayList<String> splitString(String sep, String original) throws Exception
	{
//		String original = RemoveUnconvertibleChars.removeUnconvertibleChars(original2);

	   if (sep == null || sep.equals("") || original == null)
	      throw new IllegalArgumentException("null or empty String");
	   ArrayList<String>  result = new ArrayList<String> ();
	   int oldpos = 0;
	   int pos;
	   int sepLength = sep.length();
	   String substr="";
	   
	   try{
		   while ((pos = original.toUpperCase().indexOf(sep, oldpos)) >= 0)
		   {
		   	  substr = original.substring(oldpos, pos);
		      if (substr.startsWith("\n"))
		         result.add(original.substring(oldpos + 1, pos));
		      else
		         result.add(substr);
		      oldpos = pos + sepLength;
		   }
	
		   if (original.substring(oldpos).toUpperCase().startsWith("\n"))
		      result.add(original.substring(oldpos + 1));
		   else
		      result.add(original.substring(oldpos));
	   }catch(Exception e){
		   System.out.println("TESTING ERROR "+original+"  "+substr);
	   }
	   return result;
	}
}
