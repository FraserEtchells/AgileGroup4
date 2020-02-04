package Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sql.DataSetFormater;

class DataSetFormaterTest {

	
	@Test
	void seperateRowTest() {
		DataSetFormater temp = new DataSetFormater();
		String[] row = temp.seperateRow("001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,050625,CEDARS-SINAI MEDICAL CENTER,8700 BEVERLY BLVD,LOS ANGELES,CA,90048,CA - Los Angeles,47,\"$2,868,377.13\",\"$361,621.11\",\"$345,847.51\"");
		assertEquals("001 ",row[0],"Not Procedure ID");
		assertEquals("HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC",row[1],"Not Procedure Description");
		assertEquals("050625",row[2],"Not Provider ID");
		assertEquals("CEDARS-SINAI MEDICAL CENTER",row[3],"Not Provider Name");
		assertEquals("8700 BEVERLY BLVD",row[4],"Not Provider Street");
		assertEquals("LOS ANGELES",row[5],"Not Provider City");
		assertEquals("CA",row[6],"Not Provider State");
		assertEquals("90048",row[7],"Not Provider Zip");
		assertEquals("CA - Los Angeles",row[8],"Not HRR");
		assertEquals("47",row[9],"Not Total Discharges");
		assertEquals("361,621.11",row[10],"Not Payments");
	}

}
