import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class main2 {
    public static void main(String[] args) {
        
    
        
            try {
                String csvFile = "csvCustomer.csv";
            String line = "";
            String cvsSplitBy = ",";
            
            // Read the CSV file and get the last row
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            String lastLine = null;
            while ((line = br.readLine()) != null) {
                lastLine = line;
            }
            br.close();
            
            // Parse the last row to get the last number
            String[] lastRow = lastLine.split(cvsSplitBy);
            int lastNumber = Integer.parseInt(lastRow[0]);
            
            // Increment the last number by 1
            int newNumber = lastNumber + 1;
            
            // Create a new row with the incremented number and the new menu item
            String newLoginID = "Customer Login ID";
            String newRow = newNumber + "," + newLoginID;
            
            // Append the new row to the CSV file
            FileWriter writer = new FileWriter(csvFile, true);
            writer.append("\n"); // add a new line before appending the new row
            writer.append(newRow);
            writer.close();
                
            } catch (Exception e) {
                System.out.println("Error found"+ e);
            }
    }
}

