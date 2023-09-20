package Restaurant;

import java.util.Scanner;

/**
 * customerOperations
 */
public class employeeOperations extends commonOperation {

    static void viewMenu() {
        System.out.println("\t\t  ______________________________ ");
        System.out.println("\t\t |                              |");
        System.out.println("\t\t |     Welcome to Tasty Bites   |");
        System.out.println("\t\t |______________________________| ");
        System.out.println("\t\t |     MENU FOR EMPLOYEE        |");
        System.out.println("\t\t |______________________________| ");
        System.out.println(" ");
        System.out.println("1: View Menu \t\t\t\t\t 2: Edit existing Menu");
        System.out.println("3: Add New Menu\t\t\t\t\t 4: Create new Order");
        System.out.println("5: Change existing Order Status \t\t 6: View Consolidated Collection of the Day");
        System.out.println("7:View List of Customers\t\t\t 8:View List of Orders created by the individual Customer");
        System.out.println("9: View List of Self-Orders\t\t\t 10: View a specific Self-Order details");
        System.out.println("11: View self Profile Details\t\t\t 12:Edit Profile");
        System.out.println("13: View Attendance Management\t\t\t 14:View Shift Management\n");
        System.out.println("Please select valid input.");
    }

    static void SelfOrder(String UId){
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader("csvOrder.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] orderData = line.split(",");

                // Check if this is the order you want to print
                if (orderData[1].equals(UId)) {
                    System.out.println(Arrays.toString(orderData));
                    // System.out.println("User id: "+ orderData[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        viewMenu();
        commonOperation comObj = new commonOperation();
        Scanner scan = new Scanner(System.in);
        int data = scan.nextInt();
        scan.nextLine();

        switch (data) {
            case 1:
                comObj.VeiwList("csvMenu.csv");
                break;

            case 2:
                System.out.println("Enter");
                comObj.EditMenu(null, null);
                break;

            case 3:

                break;

            case 4:

                break;

            case 5:
                System.out.print("Enter the itemID: ");
                int itemId = scan.nextInt();
                scan.nextLine();
                // Create an Order object with orderId and orderStatus initialized
                Order order = new Order(itemId, "Approved");

                // Call the cancelOrder method to update the order status
                order.cancelOrder();
                break;

            case 6:

                break;

            default:
                System.out.println("Enter valid input");
                break;
        }
    }

}
