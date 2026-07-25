package AsnVerifyNewRequirement20260710;

import java.util.ArrayList;
import java.util.List;

public class CreateTestFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		
		temp = header(); 
		for(String t:temp)
			list.add(t);
		
		//add mutiple item levels
		temp = itemLevel("0018968","009","00011396220260713140601", "5");
		for(String t:temp)
			list.add(t);
		temp = itemLevel("0027368","011","00011396220260713140601", "3");
		for(String t:temp)
			list.add(t);
		temp = itemLevel("0030312","013","00011396220260713140601", "5");
		for(String t:temp)
			list.add(t);
		temp = itemLevel("0129002","031","00011396220260713140601", "2");
		for(String t:temp)
			list.add(t);
		temp = itemLevel("0139998","037","00011396220260713140601", "4");
		for(String t:temp)
			list.add(t);
		temp = itemLevel("0179754","043","00011396220260713140601", "3");
		for(String t:temp)
			list.add(t);
		temp = itemLevel("0200147","045","00011396220260713140601", "6");
		for(String t:temp)
			list.add(t);
		

		temp = asnLevel();
		for(String t:temp)
			list.add(t);

		temp = footer();
		for(String t:temp)
			list.add(t);
		
		for(String l:list)
			System.out.println(l);
		
	}
	public static List<String> createMultipleItemLevel(String itemCode, String poLineNo, String asnId, String unitsReceived){
		List<String> list = new ArrayList<String>();

		return list;
	}
	public static List<String> itemLevel(String itemCode, String poLineNo, String asnId, String unitsReceived) {
		
		List<String> list = new ArrayList<String>();
		
			list.add("{");
				list.add("\"Messages\": null,");
				list.add("\"PIXSpecification\": \"ITEM_Level\",");
				list.add("\"Description\": \"Item Level Variance\",");
				list.add("\"SourceTransactionType\": \"Receiving\",");
				list.add("\"SourceEventName\": \"Verify_ASN\",");
				list.add("\"ItemDefinition\": {");
					list.add("\"Company\": \"KC\",");
					list.add("\"Season\": \"\",");
					list.add("\"SeasonYear\": \"\",");
					list.add("\"Style\": \"\",");
					list.add("\"StyleSuffix\": \"\",");
					list.add("\"Color\": \"NA\",");
					list.add("\"ColorSuffix\": \"\",");
					list.add("\"SecondDimension\": \"\",");
					list.add("\"SizeCode\": \"\",");
					list.add("\"SizeDescription\": \"\",");
//					list.add("\"ItemId\": \"0051970\",");
					list.add("\"ItemId\": \""+itemCode+"\",");
					list.add("\"Description\": \"FSHR ROAD TRIP MIX 19 OZ\"");
				list.add("},");
				list.add("\"SubItemFields\": {");
					list.add("\"CountryOfOrigin\": \"\",");
					list.add("\"InventoryTypeId\": \"\",");
					list.add("\"ProductStatusId\": \"\",");
					list.add("\"ItemBatchNumberId\": \"005\",");
					list.add("\"InventoryAttribute1\": \"\",");
					list.add("\"InventoryAttribute2\": \"\",");
					list.add("\"InventoryAttribute3\": \"\",");
					list.add("\"InventoryAttribute4\": \"\",");
					list.add("\"InventoryAttribute5\": \"\",");
					list.add("\"ExpirationDate\": \"\",");
					list.add("\"ManufactureDate\": \"\"");
				list.add("},");
				list.add("\"PIXFields\": {");
					list.add("\"BusinessUnitId\": \"\",");
					list.add("\"ExternalOrganizationId\": \"\",");
					list.add("\"RrnId\": \"\",");
					list.add("\"AsnLevelId\": \"LPN\",");
					list.add("\"CreatedBy\": \"richard.melton@awginc.com\",");
					list.add("\"OriginalOrderId\": \"\",");
					list.add("\"OriginalOrderLineId\": \"\",");
//					list.add("\"AsnSequenceNumber\": \"005\",");
					list.add("\"AsnSequenceNumber\": \""+poLineNo+"\",");
					list.add("\"AsnLineId\": \"005\",");
					list.add("\"PurchaseOrderId\": \"\",");
					list.add("\"AlternatePurchaseOrderId\": \"\",");
					list.add("\"PurchaseOrderLineId\": \"\",");
//					list.add("\"AsnId\": \"00014217320260417150601\",");
					list.add("\"AsnId\": \""+asnId+"\",");
					list.add("\"AlternateAsnId\": \"\",");
					list.add("\"AsnStatus\": \"8000\",");
					list.add("\"AsnOriginTypeId\": \"P\",");
					list.add("\"ReceiptVariance\": \"Y\",");
					list.add("\"ReceiptsCompleted\": \"Y\",");
					list.add("\"iLPNsShipped\": \"1\",");
					list.add("\"iLPNsReceived\": \"0\",");
					list.add("\"UnitsShipped\": \"11.0\",");
//					list.add("\"UnitsReceived\": \"0\",");
					list.add("\"UnitsReceived\": \""+unitsReceived+"\",");
					list.add("\"CreatedTimestamp\": \"2026-04-20T15:16:08.887\",");
					list.add("\"UpdatedTimestamp\": \"2026-04-20T15:19:25.856\",");
					list.add("\"UpdatedBy\": \"system-msg-user@KC\",");
					list.add("\"TransactionDateTime\": \"2026-04-20T15:16:07.545\"");
				list.add("},");
				list.add("\"TransactionNumber\": \"7766981676006518462\",");
				list.add("\"SequenceNumber\": 11,");
				list.add("\"TransactionDateTime\": \"2026-04-20T15:16:07.545\",");
				list.add("\"Organization\": \"KC\",");
				list.add("\"Facility\": \"KC\"");
			list.add("},");
			
			return list;
	}
	public static List<String> header() {
		
		List<String> list = new ArrayList<String>();
		
		list.add("{ ");

		list.add("\"ContextInformation\": {");
			list.add("\"Messages\": null,");
			list.add("\"Organization\": \"KC\",");
			list.add("\"UserId\": \"system-msg-user@KC\",");
			list.add("\"UserLocale\": \"UTC\",");
			list.add("\"Location\": \"KC\"");
		list.add("},");
		list.add("\"CurrentPage\": 1,");
		list.add("\"ExportDocuments\": [");
		
		return list;
	}

	public static List<String> footer() {
		
		List<String> list = new ArrayList<String>();
		list.add("],");
		list.add("\"UniqueJobId\": \"a946ecf0-f7bb-45bf-8aff-46dd805b9608\",");
		list.add("\"TotalPages\": 1");
	list.add("}");
		
	return list;
	}
	
	public static List<String> asnLevel() {
		
		List<String> list = new ArrayList<String>();
		
		list.add("{");
		list.add("\"Messages\": null,");
		list.add("\"PIXSpecification\": \"ASN_Level\",");
		list.add("\"Description\": \"ASN Level Variance\",");
		list.add("\"SourceTransactionType\": \"Receiving\",");
		list.add("\"SourceEventName\": \"Verify_ASN\",");
		list.add("\"PIXFields\": {");
			list.add("\"BusinessUnitId\": \"\",");
			list.add("\"ExternalOrganizationId\": \"\",");
			list.add("\"RrnId\": \"\",");
			list.add("\"AsnLevelId\": \"LPN\",");
			list.add("\"CreatedBy\": \"richard.melton@awginc.com\",");
			list.add("\"AsnId\": \"00014217320260417150601\",");
			list.add("\"AlternateAsnId\": \"\",");
			list.add("\"AsnStatus\": \"8000\",");
			list.add("\"AsnOriginTypeId\": \"P\",");
			list.add("\"ReceiptVariance\": \"N\",");
			list.add("\"ReceiptsCompleted\": \"Y\",");
			list.add("\"iLPNsShipped\": \"3\",");
			list.add("\"iLPNsReceived\": \"3\",");
			list.add("\"UnitsShipped\": \"21.0000\",");
			list.add("\"UnitsReceived\": \"21.0000\",");
			list.add("\"CreatedTimestamp\": \"2026-04-20T15:16:07.773\",");
			list.add("\"UpdatedTimestamp\": \"2026-04-20T15:19:25.855\",");
			list.add("\"UpdatedBy\": \"system-msg-user@KC\",");
			list.add("\"TransactionDateTime\": \"2026-04-20T15:16:07.545\"");
		list.add("},");
		list.add("\"TransactionNumber\": \"7766981676006518462\",");
		list.add("\"SequenceNumber\": 3,");
		list.add("\"TransactionDateTime\": \"2026-04-20T15:16:07.545\",");
		list.add("\"Organization\": \"KC\",");
		list.add("\"Facility\": \"KC\"");
	list.add("}");
		
	return list;
	}
	
}
