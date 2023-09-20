

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        try (Scanner sc = new Scanner (System.in)) {
          boolean flag = true;
          while(flag)
          {
          new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
          System.out.println("\t\t  ______________________________ ");
          System.out.println("\t\t |                              |");
          System.out.println("\t\t |     Welcome to Tasty Bites   |");
          System.out.println("\t\t |______________________________| ");
          System.out.println(" ");
          System.out.println("Select your profile. ");
          System.out.println("1. Customer \t 2.Owner/Admin \n");
          int ch1 = sc.nextInt();
              switch (ch1) {
              case 1:
              System.out.println("Welcome Customer \n Do you have premium membership? \n Enter Y or N");
              String ch2;
             
              Scanner sc2 = new Scanner (System.in);
              ch2 = sc2.nextLine();
              switch (ch2)
              {
                case "Y":
                System.out.println("Dear Customer, use Coupon code “DISCOUNT10” to avail 10% discount if your total billing amount is more than Rs.5000/-.\n Bon Appetite...!!!"); 
                System.out.println("1. Enter login ID: ");
                int loginID = sc2.nextInt();
                System.out.println("2. Enter login Password: ");
                int loginPassword = sc2.nextInt();

                break;

                case "N":
                System.out.println("Dear Customer, we are providing Premium Customer Discounts - \n Offer 10% discount on Billing amount for Premium Customers \n (if total billing amount is more than Rs.5000/-.) \n Avail Now!!! \n We are also providing Jumbo Coupons - Offer 15% discount for Orders having Billing amount more than Rs. 2000/- \n What are you waiting for..? \n Join for premium Membership to avail more exciting offers…");
                System.out.println("A. Signup for Premium Membership. ");
                System.out.println("B. Skip and continue as Guest ");
                
                String ch3;
                
                Scanner sc3 = new Scanner (System.in);
                ch3 = sc3.nextLine();
                      switch (ch3)
                      {
                        case "A":
                        System.out.println("Enter your name:");
                        String nm = sc3.nextLine();
                        break;

                        case "B":
                        System.out.println("Dear Guest, your login ID is GUEST");
                        System.out.println("Your login password is GUE123");
                        System.out.println("Print 1 to view food menu.");
                        int foodMenu = sc3.nextInt();
                        break;

                        default:
                        System.out.println("Wrong choice entered.");
                        break;
                                  }
                                

                break;

                default :
                System.out.println("Wrong choice");
                
                } 
                  break;
              

              case 2:
              new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
              System.out.println("\t\t  ______________________________ ");
              System.out.println("\t\t |                              |");
              System.out.println("\t\t |     Welcome Admin/Owner      |");
              System.out.println("\t\t |______________________________| ");
              System.out.println(" ");
              System.out.println("Enter login ID: ");
              int loginID = sc.nextInt();
              System.out.println(loginID);
              System.out.println("Enter login password: ");
              int loginPassword = sc.nextInt();
              System.out.println(loginPassword);
              break;

              default:
              System.out.println("Invalid choice");

          }

          
  }
        }
        catch (Exception e) {
          System.out.println("Error occured " + e.getMessage());
        }
}

}
