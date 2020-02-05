package Tests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import sql.DataSetFormater;

class DataSetFormaterTest {

	public String testData = "001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,10033,UNIVERSITY OF ALABAMA HOSPITAL,619 SOUTH 19TH STREET,BIRMINGHAM,AL,35233,AL - Birmingham,13,\"$1,016,806.46\",\"$296,937.00\",\"$150,139.69\"\r\n" +
			"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,30103,MAYO CLINIC HOSPITAL,5777 EAST MAYO BOULEVARD,PHOENIX,AZ,85054,AZ - Phoenix,26,\"$443,387.54\",\"$215,059.54\",\"$163,889.31\"\r\n" +
			"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,40114,BAPTIST HEALTH MEDICAL CENTER-LITTLE ROCK,\"9601 INTERSTATE 630, EXIT 7\",LITTLE ROCK,AR,72205,AR - Little Rock,33,\"$711,472.00\",\"$180,315.55\",\"$145,192.61\"\r\n" +
			"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50025,UC SAN DIEGO HEALTH HILLCREST - HILLCREST MED CTR,200 WEST ARBOR DRIVE,SAN DIEGO,CA,92103,CA - San Diego,17,\"$796,343.82\",\"$299,244.41\",\"$270,131.59\"\r\n" +
			"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50100,SHARP MEMORIAL HOSPITAL,7901 FROST ST,SAN DIEGO,CA,92123,CA - San Diego,13,\"$1,434,651.46\",\"$239,537.46\",\"$215,205.00\"\r\n" +
			"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50108,\"SUTTER MEDICAL CENTER, SACRAMENTO\",2825 CAPITOL AVENUE,SACRAMENTO,CA,95816,CA - Sacramento,11,\"$846,688.27\",\"$259,930.18\",\"$257,317.55\"\r\n" +
			"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50262,RONALD REAGAN U C L A MEDICAL CENTER,757 WESTWOOD PLAZA,LOS ANGELES,CA,90095,CA - Los Angeles,22,\"$1,028,341.68\",\"$369,632.86\",\"$340,588.50\"\r\n" +
			"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50441,STANFORD HEALTH CARE,300 PASTEUR DRIVE,STANFORD,CA,94305,CA - San Mateo County,29,\"$3,104,374.28\",\"$492,689.79\",\"$469,167.03\"\r\n" +
			"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50454,UCSF MEDICAL CENTER,\"505 PARNASSUS AVE, BOX 0296\",SAN FRANCISCO,CA,94143,CA - San Francisco,18,\"$1,386,713.00\",\"$346,280.83\",\"$333,697.67\"\r\n" +
			"001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,50625,CEDARS-SINAI MEDICAL CENTER,8700 BEVERLY BLVD,LOS ANGELES,CA,90048,CA - Los Angeles,47,\"$2,868,377.13\",\"$361,621.11\",\"$345,847.51\"";

	@Test
	void separateColumTest() {
		DataSetFormater temp = new DataSetFormater();
		String[] colums = temp.separateRow("001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,050625,CEDARS-SINAI MEDICAL CENTER,8700 BEVERLY BLVD,LOS ANGELES,CA,90048,CA - Los Angeles,47,\"$2,868,377.13\",\"$361,621.11\",\"$345,847.51\"");
		assertEquals("001",														colums[0],"Not Procedure ID");
		assertEquals("HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC",colums[1],"Not Procedure Description");
		assertEquals("050625",													colums[2],"Not Provider ID");
		assertEquals("CEDARS-SINAI MEDICAL CENTER",								colums[3],"Not Provider Name");
		assertEquals("8700 BEVERLY BLVD",										colums[4],"Not Provider Street");
		assertEquals("LOS ANGELES",												colums[5],"Not Provider City");
		assertEquals("CA",														colums[6],"Not Provider State");
		assertEquals("90048",													colums[7],"Not Provider Zip");
		assertEquals("CA - Los Angeles",										colums[8],"Not HRR");
		assertEquals("47",														colums[9],"Not Total Discharges");
		assertEquals("361,621.11",												colums[10],"Not Payments");
	}

	@Test
	void splitUploadedFileIntoRowsTest() {
		DataSetFormater temp = new DataSetFormater();
		String[] row = temp.separateFile(testData);

		assertEquals(10,row.length, "Didnt split correctly");

	}

	@Test
	void proccesseDataTest() {
		DataSetFormater temp = new DataSetFormater();
		String[][] processData = temp.processData(testData);		
		assertEquals(10,processData.length, "Didnt process correctly");

	}

	@Test
	void getAllHospitalDataTest() {
		DataSetFormater temp = new DataSetFormater();
		String[][] processData = temp.processData(testData);
		String[] hospitalData = temp.getHospitalData(processData[0]);	
		
		assertEquals("10033",							hospitalData[0], "Didnt get hospital id");
		assertEquals("UNIVERSITY OF ALABAMA HOSPITAL",	hospitalData[1], "Didnt get hospital name");
		assertEquals("619 SOUTH 19TH STREET",			hospitalData[2], "Didnt get hospital street");
		assertEquals("BIRMINGHAM",						hospitalData[3], "Didnt get hospital City");
		assertEquals("AL",								hospitalData[4], "Didnt get hospital State");
		assertEquals("35233",							hospitalData[5], "Didnt get hospital Zip Code");
		assertEquals("AL - Birmingham",					hospitalData[6], "Didnt get hospital HRR");

	}
	
	@Test
	void getAllHospitalsTest() {
		DataSetFormater temp = new DataSetFormater();
		String[][] processData = temp.processData(testData);
		LinkedList<String[]> hospitals = temp.getHospitals(processData);		
		assertEquals(10,hospitals.size(), "Didnt get all hospitals");

	}
	
	@Test
	void getProcedureDataTest() {
		DataSetFormater temp = new DataSetFormater();
		String[][] processData = temp.processData(testData);
		String[] procedureData = temp.getProcedureData(processData[0]);	
		
		assertEquals("001",	procedureData[0], "Didnt get procedure id");
		assertEquals("HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC",procedureData[1], "Didnt get procedure desc");

	}

	@Test
	void getAllProcedureDataTest() {
		DataSetFormater temp = new DataSetFormater();
		String[][] processData = temp.processData(testData);
		LinkedList<String[]> procedures = temp.getProcedures(processData);	
		
		assertEquals(1,	procedures.size(), "Didnt get all procedures");

	}
	
	@Test
	void getProcedureToProviderDataTest() {
		DataSetFormater temp = new DataSetFormater();
		String[][] processData = temp.processData(testData);
		String[] ppData = temp.getProcedureToProviderData(processData[0]);	
		
		assertEquals("001",	ppData[0], "Didnt get procedure id");
		assertEquals("10033",	ppData[1], "Didnt get provider id");
		assertEquals("13",	ppData[2], "Didnt get discharges");
		assertEquals("296,937.00",	ppData[3], "Didnt get price");


	}
	
	@Test
	void getAllProcedureToProviderDataTest() {
		DataSetFormater temp = new DataSetFormater();
		String[][] processData = temp.processData(testData);
		LinkedList<String[]> ppData = temp.getProcedureToProviders(processData);	
		
		assertEquals(10,	ppData.size(), "Didnt get all procedures to provider");
		assertEquals("001",	ppData.getFirst()[0], "Didnt get all procedures");
		assertEquals("10033",	ppData.getFirst()[1], "Didnt get all procedures");
		assertEquals("13",	ppData.getFirst()[2], "Didnt get all procedures");
		assertEquals("296,937.00",	ppData.getFirst()[3], "Didnt get all procedures");
		
		assertEquals("001",	ppData.getLast()[0], "Didnt get all procedures");
		assertEquals("50625",	ppData.getLast()[1], "Didnt get all procedures");
		assertEquals("47",	ppData.getLast()[2], "Didnt get all procedures");
		assertEquals("361,621.11",	ppData.getLast()[3], "Didnt get all procedures");


	}

}
