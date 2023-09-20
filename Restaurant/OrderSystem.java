import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OrderSystem {
    // menu file path
    private static final String MENU_FILE_PATH = "csvMenu.csv";
    // order file path
    private static final String ORDER_FILE_PATH = "csvOrder.csv";
    private static int[] itemQuantities;

    // displays menu from the menuDetails.csv file
    private static void displayMenu() {
        try (BufferedReader reader = new BufferedReader(new FileReader(MENU_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                System.out.printf("%s,%s,%s\n", values[0], values[1], values[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // calculates the new order id
    private static int calculateNewOrderId() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ORDER_FILE_PATH))) {
            // read the last line of the order file to get the latest order id
            String lastLine = null;
            String line;
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }

            if (lastLine != null) {
                String[] values = lastLine.split(",");
                int lastOrderId = Integer.parseInt(values[0]);
                return lastOrderId + 1;
            } else {
                return 1;
                }
                } catch (IOException e) {
                e.printStackTrace();
                return -1;
                }
                }
                // generates the order date using current system date
private static String generateOrderDate() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
    Date date = new Date();
    return dateFormat.format(date);
}

// calculates the total billing amount
private static double calculateTotalBillingAmount(int[] menuIds, int[] itemQuantities) {
    double totalBillingAmount = 0;
    try (BufferedReader reader = new BufferedReader(new FileReader(MENU_FILE_PATH))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            int menuId = Integer.parseInt(values[0]);
            double itemCost = Double.parseDouble(values[2]);
            for (int i = 0; i < menuIds.length; i++) {
                if (menuId == menuIds[i]) {
                    totalBillingAmount += itemCost * itemQuantities[i];
                    break;
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return totalBillingAmount;
}

// displays the order details for the user to confirm
private static void displayOrderDetails(int[] menuIds, int[] itemQuantities) {
    try (BufferedReader reader = new BufferedReader(new FileReader(MENU_FILE_PATH))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            int menuId = Integer.parseInt(values[0]);
            String menuItem = values[1];
            double itemCost = Double.parseDouble(values[2]);
            for (int i = 0; i < menuIds.length; i++) {
                if (menuId == menuIds[i]) {
                    System.out.printf("%s: %d Qty Price: %.2f\n", menuItem, itemQuantities[i], itemCost);
                    break;
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

// saves the order to the orderDetails.csv file
private static void saveOrder(int orderId, String orderDate, double totalBillingAmount, String orderDetails, String orderStatus) {
    try (FileWriter writer = new FileWriter(ORDER_FILE_PATH, true)) {
        writer.write(String.format("%d,%s,%.2f,%s,%s\n", orderId, orderDate, totalBillingAmount, orderDetails, orderStatus));
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // display menu
    displayMenu();

    // prompt user for total item counts
    System.out.print("Please enter total Menu Count: ");
    int itemCount = scanner.nextInt();

    int[] menuIds = new int[itemCount];
    itemQuantities = new int[itemCount];

    // prompt user for menuId and item quantity for individual menuId
    for (int i = 0; i < itemCount; i++) {
        System.out.printf("Item no - %d: Enter menuID: ", i+1);
        menuIds[i] = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        itemQuantities[i] = scanner.nextInt();
    }

    // calculate new orderId
    int newOrderId = calculateNewOrderId();

    // generate orderDate using current SystemDate
    String orderDate = generateOrderDate();

    // calculate totalBillingAmount by fetching itemCost details from menuDetails.csv file
    double totalBillingAmount = calculateTotalBillingAmount(menuIds, itemQuantities);

    // orderStatus be ‘Approved’ by default
    String orderStatus = "Approved";

    // create an array of orderDetails for N number of Total Item Counts
    StringBuilder orderDetails = new StringBuilder();
    for (int i = 0; i < itemCount; i++) {
        orderDetails.append(menuIds[i]).append(" ").append(itemQuantities[i]).append(" ");
    }

    // display order details for user to confirm
    System.out.println("Please check the Order details - ");
    displayOrderDetails(menuIds, itemQuantities);
    System.out.printf("Total Billing Amount: %.2f\n", totalBillingAmount);

    // prompt user to confirm order
    System.out.print("Press 'Y' to confirm the order: ");
    String confirm = scanner.next();

    if (confirm.equalsIgnoreCase("Y")) {
        // save order to file
        saveOrder(newOrderId, orderDate, totalBillingAmount, orderDetails.toString(), orderStatus);
        System.out.println("Order Saved!");
    } else {
        System.out.println("Order cancelled.");
    }

    scanner.close();
}

}