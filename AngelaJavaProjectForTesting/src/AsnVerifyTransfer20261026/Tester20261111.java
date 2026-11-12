package AsnVerifyTransfer20261026;

public class Tester20261111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getAdjRef("R", "03024930220261027135730", "12345", ""));
	}
	public static String getAdjRef(String reasonCode, String adjRef1, String asnIdPoNbr, String rcConditionCode) {
		
		//if reason code is R, there has to be a poNbr passed in the "ReferenceText". if it's blank, try to get it from the asnId
	
		String newValue=adjRef1;
		
		if(reasonCode.trim().equals("R") || rcConditionCode.trim().equals("RC") || reasonCode.trim().equals("W")) {
			if(adjRef1!=null){
				newValue = getValue(adjRef1.trim());
			}
			if("".equals(newValue)) {
				if(asnIdPoNbr!=null){
						newValue =  getValue(asnIdPoNbr.trim());
						if("".equals(newValue)) {
							newValue = "dropMsg";
						}
				}else {
				        return "dropMsg";
				}
			}
		}
		
		return newValue;
	}
	private static String getValue(String value) {

		String newValue = "";
		if(!"".equals(value.trim())){
			newValue = value.trim();
		}

		return newValue;
	}
}
