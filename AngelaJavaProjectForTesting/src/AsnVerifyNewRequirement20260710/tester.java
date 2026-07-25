package AsnVerifyNewRequirement20260710;

public class tester {

	public static void main(String[] args) {
		
		//FYI - the only difference will be the 3rd parameter which is the qty from Manhattan
		
		//group 1
		System.out.println("group 1-----------------------------------------------------------------------");
		System.out.println(calcTotalUnitsReceived(288,288,2));
		System.out.println(calcTotalUnitsReceived(12,12,2));
//		System.out.println(calcTotalUnitsReceived(120,10,3));
		System.out.println(calcTotalUnitsReceived(120,10,1));
		System.out.println(calcTotalUnitsReceived(324,36,3));
		System.out.println(calcTotalUnitsReceived(384,48,2));
		System.out.println(calcTotalUnitsReceived(20,20,2));
		System.out.println(calcTotalUnitsReceived(24,6,2));

		//group 2
		System.out.println("group 2-----------------------------------------------------------------------");
		System.out.println(calcTotalUnitsReceived(288,288,5));
		System.out.println(calcTotalUnitsReceived(12,12,3));
		System.out.println(calcTotalUnitsReceived(120,10,5));
		System.out.println(calcTotalUnitsReceived(324,36,2));
		System.out.println(calcTotalUnitsReceived(384,48,4));
		System.out.println(calcTotalUnitsReceived(20,20,3));
		System.out.println(calcTotalUnitsReceived(24,6,6));

		//group 3
		System.out.println("group 3-----------------------------------------------------------------------");
		System.out.println(calcTotalUnitsReceived(1,1,5));
		System.out.println(calcTotalUnitsReceived(1,1,3));
		System.out.println(calcTotalUnitsReceived(1,1,5));

		//group 4
		System.out.println("group 4-----------------------------------------------------------------------");
		System.out.println(calcTotalUnitsReceived(72,6,2));
		System.out.println(calcTotalUnitsReceived(72,6,12));

	}
	public static int calcTotalUnitsReceived(int totalPack, int totalPacksPerUnit, int manhattanQty) {
		
		int totalUnitsPerCase = getTotalUnitsPerCase(totalPack, totalPacksPerUnit);
		int totalUnitsReceived = totalUnitsPerCase * manhattanQty;
		
		return totalUnitsReceived;
	}
	public static int getTotalUnitsPerCase(int totalPack, int totalPacksPerUnit) {
		return totalPack/totalPacksPerUnit;
	}
}
