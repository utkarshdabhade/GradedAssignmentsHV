import java.util.Scanner;

public class Order {
    private String orderStatus;

    // Constructor
    public Order(int orderId, String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // Getter and Setter for orderStatus field
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // Method to update the order status to "Canceled"
    public void cancelOrder() {
        if (this.orderStatus.equals("Approved")) {
            System.out.println("Are you sure you want to cancel this order? (y/n)");
            try (Scanner scanner = new Scanner(System.in)) {
                String confirmation = scanner.nextLine();
                if (confirmation.equals("y")) {
                    this.orderStatus = "Canceled";
                    System.out.println("Order has been canceled.");
                } else {
                    System.out.println("Order cancelation has been declined.");
                }
            }
        } else {
            System.out.println("Order cannot be canceled as it is not in Approved status.");
        }
    }

public static void main(String[] args) {
    try (// Prompt user for itemID input
    Scanner scanner = new Scanner(System.in)) {
        System.out.print("Enter the itemID: ");
        int itemId = scanner.nextInt();

        // Create an Order object with orderId and orderStatus initialized
        Order order = new Order(itemId, "Approved");

        // Call the cancelOrder method to update the order status
        order.cancelOrder();
    }
}
}
