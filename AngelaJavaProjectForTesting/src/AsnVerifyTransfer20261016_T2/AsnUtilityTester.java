package AsnVerifyTransfer20261016_T2;

public class AsnUtilityTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String asnSeqNbr = "1";
		String value = "testValue";
		String itemId = "1234567";
//		String asnId = "03040371220261014161605";
		String asnId = "0304";
		System.out.println(buildPoLineKey(asnSeqNbr, value, itemId, asnId));
		
		asnId = "03040371220261014161605";
		System.out.println(buildPoLineKey(asnSeqNbr, value, itemId, asnId));

	}

	public static String buildPoLineKey(String asnSeqNbr, String value, String itemId, String asnId) {

		if (isTransfer(asnId) == true)
			return itemId + "|" + value;
		else
			return asnSeqNbr + "|" + value;
	}

	private static boolean isTransfer(String asnId) {
		if (asnId.length() < 5)
			return false;
		else
			return asnId.substring(4, 5).contains("0") ? true : false;
	}
}
