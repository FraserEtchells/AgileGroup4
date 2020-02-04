package sql;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DataSetFormater {
	
	public String[] seperateRow(String row) {
		
		String[] splitRow = row.split(","); 
		
		String[] temp = splitRow[0].split("-");
		
		String [] combined = new String[11];
		combined[0] = temp[0];
		combined[1] = temp[1].substring(1);
		
		for (int i = 2;i < 10;i++) {
			
			combined[i] = splitRow[i-1];
		}
		String[] temp2 = row.split(Pattern.quote("$"));
		combined[10] = temp2[2].substring(0, temp2[2].length() - 3);
		return combined;
		
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
