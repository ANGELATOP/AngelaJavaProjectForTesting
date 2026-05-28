package AsnVerifyProdQA2;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test = "Fclty:KC Verify_ASN ASN_Level AsnId:00SAL378826320260525060008025 ItemId:0482729";  //80chars  (max allowed 75 chars)
		System.out.println(truncateValue(test));
		
		test = "Fclty:KC Verify_ASN LPN_Level AsnId:00012706020260521082246 ItemId:0010380"; //74 chars (max allowed 75 chars)
		System.out.println(truncateValue(test));
	}

	public static String truncateValue(String value) {
		//max length in the archive detail for key string is 75
		//the invalid asnID and being to long will cause the insert to error
		int valueSize = value.length();
		
		if(valueSize>75)
			return value.substring(0,75);
		else
			return value;
		
	}
}
