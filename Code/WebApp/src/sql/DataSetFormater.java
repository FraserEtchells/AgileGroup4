package sql;
import java.util.Arrays;
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
		
		String[] temp = splitRow[0].split("-");
		
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
		System.out.print(Arrays.toString(splitData));
		return splitData;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
