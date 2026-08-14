package warehouse.prod20260807laptop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParseFile202600807 {

//	static String directory = "C:\\Users\\atopp\\Downloads\\googleMsgs\\input\\";
	
	static String directory = "C:\\Users\\atopp\\Documents\\eclipseWorkspace202607_git\\AngelaJavaProjectForTesting\\AngelaJavaProjectForTesting\\src\\warehouse\\prod20260807laptop\\";
	static String outputDir = "C:\\Users\\atopp\\Documents\\eclipseWorkspace202607_git\\AngelaJavaProjectForTesting\\AngelaJavaProjectForTesting\\src\\warehouse\\prod20260807laptop\\";

	static HashMap<String,String> totalItems = new HashMap<String,String>();
	
	public static void main(String[] args) throws Exception {

		//Useful Sort Utility
		//Use the ACE flow to sort the input manhattan message by itemId so you don't have to manually sort it yourself after running this utility.

		//Anotgher option, is run the ACE AsnVerifyParseInputMsg.msgflow.  It will sort by itemId and then summarize similar console as the one that
		//this java utility will do.
		
		System.out.println("start");
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------
		//text summary of specific attributes, message per line
		//-------------------------------------------------------------------------------------------------------------------------------------------------
		process("asnVerify manhattanMsg poi 65217.json");  //20 items received
		
//		getKeyInfoAsnVerify("asnVerifyMsg3_po_23962_hasDeletedPoLines.json");

		//-------------------------------------------------------------------------------------------------------------------------------------------------
		//partial json sort of format
		//-------------------------------------------------------------------------------------------------------------------------------------------------
//		getKeyInfoAsnVerifySpecificMessages("20260805_asnVerify po 19806_item0372888.json","\"ItemId\": \"0372888\"");
//		getKeyInfoAsnVerifySpecificMessages("20260805_asnVerify po 19806.json","\"ItemId\": \"0139352\"");
//		getKeyInfoAsnVerifySpecificMessages("ASN Verify PO 92303 SORTED_hasCATCH_WEIGHT.json","\"ItemId\": \"0010852\"");
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------
		//partial json sort of format
		//-------------------------------------------------------------------------------------------------------------------------------------------------
		getKeyInfoAsnVerifySpecificMessagesSpecificAttributes("asnVerify manhattanMsg poi 65217.json","\"ItemId\": \"0372888\"");

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
	    	
//	    	if(x.contains("ASN_Level")) {
//	    		//skip
//	    	}else
	    	if(x.contains("ITEM_Level") || x.contains("LPN_Level") || x.contains("ASN_Level"))   
	    	{
	    		System.out.println( text.toString());
	    		text = new StringBuilder();
	    		
	    		if(x.contains("CatchWeight_ITEM_Level"))
	    		    text.append(rightPadd(x.trim(),47));
	    		else
	    		if(x.contains("ITEM_Level"))
	    		    text.append(rightPadd(x.trim(),47));
	    		else
	    		if(x.contains("LPN_Level"))
		    		text.append(rightPadd(x.trim(),47));
	    		else
	    		if(x.contains("ASN_Level")) {
	    			System.out.println(" ");
		    		text.append(rightPadd(x.trim(),47));
	    		}
	    		else
	    		    text.append("Unknown Message Type");

	    		
	    		list.add(x);
	    		currRec=true;
	    		currMsg=x.trim();
	    		
	    		

	    	}
	    	
	    	if(x.contains("ASN_Level")) {
	    		//skip
	    		//currRec=false;
	    	}else
	    	if(currRec==true) {
	    		if(x.contains("ItemId")){
	    			totalItems.put(x, x);  //get count of total items
	    			
	    			if(x.contains(previousItemId)) {
		    		text.append(rightPadd(x.trim(),23));
	    			}
	    			else {
	    				System.out.println(""); //blank line break
	    				previousItemId=x;
			    		text.append(rightPadd(x.trim(),23));
	    			}
	    			
	    		}else
		    	if(x.contains("UnitsShipped")) {
		    		text.append(rightPadd(x.trim(),25));
			    	list.add(x.trim());	    			
		    	}else
		    	if(x.contains("UnitsReceived")) {//this is the PoLineQty
		    		text.append(rightPadd(x.trim(),25));
			    	list.add(x.trim());	    			
		    	}else
		    	if(x.contains("AttributeUom")) {
		    		text.append(rightPadd(x.trim(),25));
			    	list.add(x.trim());	    			
		    	}else
	    		if(x.contains("AsnSequenceNumber")) {
//	    			text.append(rightPadd(x.trim(),43));
//		    		list.add(x.trim());	    			
	    		}else
	    		if(x.contains("SequenceNumber")) {
	    			text.append(rightPadd(x.trim(),25));
		    		list.add(x.trim());	    			
	    		}else
//	    		if(x.contains("CATCH_WEIGHT")) {
	    		if(x.contains("AttributeName")) {
	    			text.append(rightPadd(x.trim(),34));
		    		list.add(x.trim());	    			
	    		}else
	    		if(x.contains("AttributeValue")) {
	    			text.append(rightPadd(x.trim(),36));
		    		list.add(x.trim());	    			
	    		}
//		    	if(x.contains("AsnSequenceNumber")) {
//		    		if(currMsg.contains("LPN_Level")) {
//			    		elementCnter=elementCnter+1;
//
//			    		text.append(rightPadd(x.trim(),30));
//			    		list.add(x.trim());
//			    		totalAttributes=totalAttributes+1;
//		    			
//		    		}else
//		    		{
//			    		elementCnter=elementCnter+1;
//
//			    		text.append(rightPadd(x.trim(),30));
//			    		list.add(x.trim());
//			    		totalAttributes=totalAttributes+1;
//		    			
//		    		}
//		    	} 
	    	}
   	  }
	    
	    
    	//display last row
		System.out.println(text.toString());

		System.out.println(" ");
		System.out.println("--------------------------------------------------------------------------------------- ");
//		totalItems.forEach((k, v) -> System.out.println((k + ":" + v)));  //this is a forEach and lambda expression for Java 8
		totalItems.forEach((k, v) -> System.out.println((v)));  //this is a forEach and lambda expression for Java 8\
		System.out.println("-----------------total of items for this asn verify message = "+totalItems.size());
		
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
		
		int totalMsgsForItem=0;
		
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
//	    	if(x.contains("LPN_Level")) {
//	    		skip = true; //no need to view this data, aof 8-6-2026 this message is now used in asn verify
//	    	}else
	    	if(x.contains(criteria)){
	    		foundSpecificMessage=true;
	    		specificMessage.add(x);	
	    		totalMsgsForItem=totalMsgsForItem+1; //total of messages for specific criteria such as itemId
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
	    System.out.println("--------------Total Messages for "+criteria+"  "+totalMsgsForItem);
	}	
	public static void getKeyInfoAsnVerifySpecificMessagesSpecificAttributes(String googleFileNm, String criteria) throws Exception {
		//get the info that I need to look at
		
		List<String> output = RetrieveTextFile.retrieveTextFile(directory+googleFileNm);
		boolean skip = false;
		
		
		List<String> specificMessage = new ArrayList<String>();
		boolean foundSpecificMessage = false;
		
		int totalMsgsForItem=0;
		
	    for(String x:output){
	    	if(x.contains("Messages")) {
	    		
	    		//new message group
//	    		System.out.println("\"----------------------------------------------- ");//add blank line
	    		skip = false;
	    		if(foundSpecificMessage==true) {
	    			for(String t:specificMessage) {
//	    				displayInfo(t);
	    				if(t.contains("PIXSpecification")) {
	    					System.out.println("----------------------------------------------------------------------------------------------------------------------- "); //line break
	    				}
	    				if(t.contains("PIXSpecification") 
//	    						|| t.contains("\"Description\"")|| t.contains("SourceTransactionType")|| t.contains("SourceEventName")
	    						|| t.contains("\"ItemDefinition\"")|| t.contains("\"ItemId\"")
	    						|| t.contains("\"PIXFields\"")|| t.contains("\"AsnId\"")
	    						|| t.contains("\"UnitsShipped\"")|| t.contains("\"UnitsReceived\"")
	    						|| t.contains("\"InventoryAttributes\"")|| t.contains("\"AttributeName\"") || t.contains("\"AttributeValue\"") 
	    						|| t.contains("\"AttributeUom\"")|| t.contains("\"ABC\"")|| t.contains("\"ABC\""))
	    				System.out.println(t);
	    			}
        		}
	    		specificMessage = new ArrayList<String>();
	    		foundSpecificMessage = false;
	    	}else
//	    	if(x.contains("LPN_Level")) {
//	    		skip = true; //no need to view this data, aof 8-6-2026 this message is now used in asn verify
//	    	}else
	    	if(x.contains(criteria)){
	    		foundSpecificMessage=true;
	    		specificMessage.add(x);	
	    		totalMsgsForItem=totalMsgsForItem+1; //total of messages for specific criteria such as itemId
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
	    System.out.println("--------------Total Messages for "+criteria+"  "+totalMsgsForItem);
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
