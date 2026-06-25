package RpeStoreMasterOptions;

public class RpeStoreMasterTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(formatValue("",5,"a"));
		System.out.println(formatValue("",5,"0"));
		System.out.println(formatValue("12",5,"0"));
		System.out.println(formatValue("1234",5,"0"));
		System.out.println(formatValue("12345",5,"0"));
		System.out.println(formatValue("123456",5,"0"));
	}

	public static String formatValue(String storeCd, int maxSize, String filler) {
		int inputSize = storeCd.trim().length();
		int diff = maxSize - inputSize;

		if (inputSize < maxSize) {
			StringBuilder value = new StringBuilder();
			for (int i = 0; i < diff; i++) {
				value.append(filler);
			}
			return value.toString() + storeCd.trim();
		} else {
			return storeCd.trim().substring(0,maxSize);
		}
	}
}
