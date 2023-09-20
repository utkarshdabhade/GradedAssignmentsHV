import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class updateMenu {
    public static void main(String[] args) {
        String filePath = "csvMenu.csv";
        String temp="csv.Menu.csv.tmp";
        System.out.println("Enter the Item id:");
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();
        System.out.println("Enter Item to be changed.");
        String item=scan.nextLine();
        System.out.println("Enter Price to be changed.");
        String price = scan.nextLine();
        // String menuItemToUpdate = "Hamburger";
        String[] updatedValues = {id,item,price};
        
        try {
            // Open the CSV file using a FileReader object and a BufferedReader object.
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            // Open a FileWriter object and a BufferedWriter object to write to the CSV file.
            FileWriter fileWriter = new FileWriter(temp);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Read each line of the CSV file and split it into an array of String values.
                String[] values = line.split(",");
                
                if (values[0].equals(id)) {
                    // Update the values for the menu item that you want to change.
                    values = updatedValues;
                }
                
                // Write each line of the CSV file back to the file.
                for (int i = 0; i < values.length; i++) {
                    bufferedWriter.write(values[i]);
                    
                    if (i < values.length - 1) {
                        bufferedWriter.write(",");
                    }
                }
                
                bufferedWriter.newLine();
            }
            
            // Close the FileReader, BufferedReader, FileWriter, and BufferedWriter objects.
            bufferedReader.close();
            fileReader.close();
            bufferedWriter.close();
            fileWriter.close();
            
            // Rename the temporary file to the original file.
            // new File(temp).renameTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
