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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
