package Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sql.DataSetFormater;

class DataSetFormaterTest {

	
	@Test
	void separateColumTest() {
		DataSetFormater temp = new DataSetFormater();
		String[] colums = temp.separateRow("001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,050625,CEDARS-SINAI MEDICAL CENTER,8700 BEVERLY BLVD,LOS ANGELES,CA,90048,CA - Los Angeles,47,\"$2,868,377.13\",\"$361,621.11\",\"$345,847.51\"");
		assertEquals("001 ",colums[0],"Not Procedure ID");
		assertEquals("HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC",colums[1],"Not Procedure Description");
		assertEquals("050625",colums[2],"Not Provider ID");
		assertEquals("CEDARS-SINAI MEDICAL CENTER",colums[3],"Not Provider Name");
		assertEquals("8700 BEVERLY BLVD",colums[4],"Not Provider Street");
		assertEquals("LOS ANGELES",colums[5],"Not Provider City");
		assertEquals("CA",colums[6],"Not Provider State");
		assertEquals("90048",colums[7],"Not Provider Zip");
		assertEquals("CA - Los Angeles",colums[8],"Not HRR");
		assertEquals("47",colums[9],"Not Total Discharges");
		assertEquals("361,621.11",colums[10],"Not Payments");
	}
	
	@Test
	void splitUploadedFileIntoRowsTest() {
		DataSetFormater temp = new DataSetFormater();
		String[] row = temp.separateFile("001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,10033,UNIVERSITY OF ALABAMA HOSPITAL,619 SOUTH 19TH STREET,BIRMINGHAM,AL,35233,AL - Birmingham,13,\"$1,016,806.46\",\"$296,937.00\",\"$150,139.69\"\r\n" + 
				"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,30103,MAYO CLINIC HOSPITAL,5777 EAST MAYO BOULEVARD,PHOENIX,AZ,85054,AZ - Phoenix,26,\"$443,387.54\",\"$215,059.54\",\"$163,889.31\"\r\n" + 
				"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,40114,BAPTIST HEALTH MEDICAL CENTER-LITTLE ROCK,\"9601 INTERSTATE 630, EXIT 7\",LITTLE ROCK,AR,72205,AR - Little Rock,33,\"$711,472.00\",\"$180,315.55\",\"$145,192.61\"\r\n" + 
				"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50025,UC SAN DIEGO HEALTH HILLCREST - HILLCREST MED CTR,200 WEST ARBOR DRIVE,SAN DIEGO,CA,92103,CA - San Diego,17,\"$796,343.82\",\"$299,244.41\",\"$270,131.59\"\r\n" + 
				"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50100,SHARP MEMORIAL HOSPITAL,7901 FROST ST,SAN DIEGO,CA,92123,CA - San Diego,13,\"$1,434,651.46\",\"$239,537.46\",\"$215,205.00\"\r\n" + 
				"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50108,\"SUTTER MEDICAL CENTER, SACRAMENTO\",2825 CAPITOL AVENUE,SACRAMENTO,CA,95816,CA - Sacramento,11,\"$846,688.27\",\"$259,930.18\",\"$257,317.55\"\r\n" + 
				"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50262,RONALD REAGAN U C L A MEDICAL CENTER,757 WESTWOOD PLAZA,LOS ANGELES,CA,90095,CA - Los Angeles,22,\"$1,028,341.68\",\"$369,632.86\",\"$340,588.50\"\r\n" + 
				"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50441,STANFORD HEALTH CARE,300 PASTEUR DRIVE,STANFORD,CA,94305,CA - San Mateo County,29,\"$3,104,374.28\",\"$492,689.79\",\"$469,167.03\"\r\n" + 
				"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50454,UCSF MEDICAL CENTER,\"505 PARNASSUS AVE, BOX 0296\",SAN FRANCISCO,CA,94143,CA - San Francisco,18,\"$1,386,713.00\",\"$346,280.83\",\"$333,697.67\"\r\n" + 
				"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50625,CEDARS-SINAI MEDICAL CENTER,8700 BEVERLY BLVD,LOS ANGELES,CA,90048,CA - Los Angeles,47,\"$2,868,377.13\",\"$361,621.11\",\"$345,847.51\"");
		
		assertEquals(10,row.length, "Didnt split correctly");
		
		
	}
}
