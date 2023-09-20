package Restaurant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class commonOperation {
    void VeiwList(String fileName){
        try{
            File fnew = new File(fileName);
            try (Scanner sc = new Scanner(fnew)) {
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                    // System.out.println();
                }
            }
            } catch (Exception e) {
                System.out.println("Error found:" + e);
            }
            // sc.close();
    }

    void EditMenu(String oldData, String newData){
        System.out.println("Enter the Item id:");
        Scanner scan=new Scanner(System.in);
        String id=scan.nextLine();
        System.out.println("Press 1: Change Item description");
        System.out.println("Press 2: Change Item Price");
        int option=scan.nextInt();
        scan.nextLine();
        File fw1 = new File("csvMenu.csv");
        try (Scanner sc1 = new Scanner(fw1)) {
            String data = " ";
            while (sc1.hasNextLine()) {
                data += sc1.nextLine();
            }
            FileWriter fwObj = new FileWriter((fw1));
            data = data.replaceAll(oldData, newData);
            fwObj.write(data);
            fwObj.close();
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
    }

    void addNewMenu(){
        try {
            String csvFile = "csvMenu.csv";
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
        String newMenuItem = "New Menu Item";
        String newRow = newNumber + "," + newMenuItem;
        
        // Append the new row to the CSV file
        FileWriter writer = new FileWriter(csvFile, true);
        writer.append("\n"); // add a new line before appending the new row
        writer.append(newRow);
        writer.close();
            
        } catch (Exception e) {
            System.out.println("Error found"+ e);
        }
        
    }

    void CreateNewOrder(){
         
    }

    
        // public static void main(String[] args) {
        //     commonOperation ComOps= new commonOperation();
        //     String fileName="csvMenu.csv";
        //     ComOps.VeiwList(fileName);
        //     // ComOps.EditMenu("Vanilla IceCream", "Chocolate IceCream");
        //     // ComOps.VeiwList(fileName);
        //     ComOps.addNewMenu();
        // }
    
}
