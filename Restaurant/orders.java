import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class orders {
    static void Orderdetails() {
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader("csvMenu.csv"))) {
            FileWriter fwObj=new FileWriter("csvMenu.csv");
            System.out.println("Enter the Item id:");
            Scanner scan = new Scanner(System.in);
            String id = scan.nextLine();
            System.out.println(id);
            while ((line = br.readLine()) != null) {
                String[] orderData = line.split(",");
                System.out.println(orderData[0]);
                // Check if this is the order you want to print
                if (orderData[0]==id) {
                    System.out.println("Press 1: Change Item description");
                    System.out.println("Press 2: Change Item Price");
                    String option = scan.nextLine();
                    // scan.nextLine();
                    if (option == "1") {
                        System.out.println("Enter Changed item: ");
                        String item = scan.nextLine();
                        orderData[1] = item;
                    } else if (option == "2") {
                        System.out.println("Enter Changed price: ");
                        String price = scan.nextLine();
                        orderData[2] = price;
                    }
                }
                // write the modified fields back to the CSV file
                fwObj.write(String.join(",", orderData) + "\n");
            }
            System.out.println("file updated");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // System.out.println("working");
        Orderdetails();
    }
}
