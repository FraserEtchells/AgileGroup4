package sql;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Pattern;

//Class to format uploaded file to be ready to be inserted into database
public class DataSetFormater {
	
	/*
	 * separated a row of file into columns and gets rid of useless data
	 *
	 * @param row Row to be separated
	 * @return String[] Separated row
	 */
	public String[] separateRow(String row) {
		
		// Split row
		String[] splitRow = row.split(","); 		
		String[] temp = splitRow[0].split(" -");
		
		String [] combined = new String[11];
		combined[0] = temp[0];
		combined[1] = temp[1].substring(1);
		
		for (int i = 2;i < 10;i++) {
			
			combined[i] = splitRow[i-1];

		}
		
		// Get average procedure payment
		String[] temp2 = row.split(Pattern.quote("$"));
		String[] temp3 = row.split("\"");

			
		// If address contains ,
		String firstCharacater = combined[3].substring(0, 1);
		if(firstCharacater.contains("\""))
		{			
			combined[3] = temp3[1];
			for (int i = 4;i < 10;i++) {
				
				combined[i] = splitRow[i];

			}
		}
		
		// If address contains ,
		firstCharacater = combined[4].substring(0, 1);
		if(firstCharacater.contains("\""))
		{	
			if(temp3.length == 3) {
				combined[4] = temp3[2];
			}else {
				combined[4] = temp3[1];
			}
			for (int i = 5;i < 10;i++) {
				
				combined[i] = splitRow[i];

			}
		}
			
		combined[10] = temp2[2].substring(0, temp2[2].length() - 3);

		return combined;
					
	}
	
	/*
	 * Separated file into a list of rows
	 *
	 * @param data Data to be separated
	 * @return String[] Separated data
	 */
	public String[] separateFile(String data) {
		
		// Separate by newLine
		String[] splitData = data.split("\n"); 
		//System.out.print(Arrays.toString(splitData));
		return splitData;
		
	}
	
	/*
	 * Separated file into a list of rows
	 *
	 * @param data Data to be separated
	 * @return String[] Separated data
	 */
	public String[][] processData(String data) {
		
		String[] separateFile = separateFile(data);
		String[][] processedData = new String[separateFile.length][11];
		
		for (int i = 0;i < separateFile.length;i++) {
			
			processedData[i] = separateRow(separateFile[i]);
		}
		
		return processedData;
		
	}
	
	/*
	 * Get hospital data from a row
	 *
	 * @param data Row to get hospital data from
	 * @return String[] Hospital data
	 */
	public String[] getHospitalData(String[] data) {
		
		String[] hospitalData = new String[7];
		
		for (int i = 0;i < hospitalData.length;i++) {
			
			hospitalData[i] = data[i+2];

			
		}
		return hospitalData;
		
	}
	
	/*
	 * Get all hospital data in dataset
	 *
	 * @param data Dataset
	 * @return String[] All data of hospitals
	 */
	public LinkedList<String[]> getHospitals(String[][] data) {
		
		LinkedList<String[]> hospitals = new LinkedList<String[]>();
		
		for (int i = 0;i < data.length;i++) {
			// If hospital not in linked list, add it
			boolean newHospital = true;
			for(String[] str: hospitals)
			{
		    	 if (str[2].equals(data[i][2])) 
		    	 {
		    		 newHospital = false;
		    		 
		    	 }
			}
			
			if(newHospital) { 
				
				hospitals.add(getHospitalData(data[i]));
				
			}
			
		}
		return hospitals;
		
	}
		

	/*
	 * Get procedure data from row
	 *
	 * @param data Row to get data from
	 * @return String[] Procedure data
	 */
	public String[] getProcedureData(String[] data) {
		
		String[] procedureData = new String[2];
		
		for (int i = 0;i < procedureData.length;i++) {
			
			procedureData[i] = data[i];

			
		}
		return procedureData;
		
	}
	
	/*
	 * Get all procedure data from dataset
	 *
	 * @param data Dataset
	 * @return String[] All procedures
	 */
	public LinkedList<String[]> getProcedures(String[][] data) {
		
		LinkedList<String[]> procedures = new LinkedList<String[]>();
		
		for (int i = 0;i < data.length;i++) {
			// If hospital not in linked list, add it
			boolean newProcedure = true;
			for(String[] str: procedures)
			{
		    	 if (str[0].equals(data[i][0])) 
		    	 {
		    		 newProcedure = false;
		    		 
		    	 }

			}
			
			if(newProcedure) { 
				
				procedures.add(getProcedureData(data[i]));
				
			}
			
		}
		return procedures;
		
	}
	
	/*
	 * Get procedure to provider linking data from a row
	 *
	 * @param data Row to get data from
	 * @return String[] linking data
	 */
	public String[] getProcedureToProviderData(String[] data) {
		
		String[] ppData = new String[4];
		
		ppData[0] = data[0]; // Procedure ID
		ppData[1] = data[2]; // Provider ID
		ppData[2] = data[9]; // Discharges
		ppData[3] = data[10]; // Price

		return ppData;
		
	}
	
	/*
	 * Get all procedure to provider linking data from dataset
	 *
	 * @param data Dataset
	 * @return String[] All linking data
	 */
	public LinkedList<String[]> getProcedureToProviders(String[][] data) {
		
		LinkedList<String[]> ppData = new LinkedList<String[]>();
		for(String[] row: data)
		{
			String[] newPP = getProcedureToProviderData(row);
			ppData.add(newPP);
			
		}

		return ppData;
		
	}
	
	public boolean uploadData(String data) {
		
		String[][] processedData = processData(data);
		LinkedList<String[]> hospitals = getHospitals(processedData);
//		//Upload hospitals
//		for(String[] str: hospitals)
//		{
//			String statement = "EXEC addProvider" + " '" + str[0] + "', '" + str[1] +  "', '" + str[2] +  "', '" + str[3] +  "', '" + str[4] +  "', '" + str[5] +  "', '" + str[6] + "'";
//			//System.out.println(statement);
//			SQLConnect.runQuery(statement);
//
//		}
		
		//upload porocedures
		LinkedList<String[]> procedures = getProcedures(processedData);
		//Upload hospitals
		for(String[] str: procedures)
		{
			String statement = "EXEC addProcedure" + " '" + str[0] + "', '" + str[1]+ "'";
			//System.out.println(statement);
			SQLConnect.runQuery(statement);

		}
//		// pp
//		LinkedList<String[]> ppData = getProcedureToProviders(processedData);
//		//Upload hospitals
//		for(String[] str: ppData)
//		{
//			String statement = "EXEC addTreatment" + " '" + str[0] + "', '" + str[1] +  "', '" + str[2] +  "', '" + str[3] +  "'";
//			//System.out.println(statement);
//			SQLConnect.runQuery(statement);
//
//		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataSetFormater n = new DataSetFormater();
		n.separateRow("001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC,040114,BAPTIST HEALTH MEDICAL CENTER-LITTLE ROCK,\"9601 INTERSTATE 630, EXIT 7\",LITTLE ROCK,AR,72205,AR - Little Rock,33,\"$711,472.00\",\"$180,315.55\",\"$145,192.61\"");
	}

}
