package Restaurant;

import java.util.Scanner;

/**
 * customerOperations
 */
public class customerOperations extends commonOperation {

    static void viewMenu() {
        // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("\t\t  ______________________________ ");
        System.out.println("\t\t |                              |");
        System.out.println("\t\t |     Welcome to Tasty Bites   |");
        System.out.println("\t\t |______________________________| ");
        System.out.println("\t\t |     MENU FOR CUSTOMERS       |");
        System.out.println("\t\t |______________________________| ");
        System.out.println(" ");
        System.out.println("PRESS 1: View Menu");
        System.out.println("PRESS 2: Create new Order");
        System.out.println("PRESS 3: View List of Self-Orders");
        System.out.println("PRESS 4: View a specific Self-Order details");
        System.out.println("PRESS 5: View self Profile Details");
        System.out.println("PRESS 6: Edit Profile\n");
        System.out.println("Please select valid input.");
    }

    public static void main(String[] args) {
        viewMenu();
        commonOperation comObj = new commonOperation();
        Scanner choice = new Scanner(System.in);
        int data = choice.nextInt();
        choice.nextLine();

        switch (data) {
            case 1:
                comObj.VeiwList("csvMenu.csv");
                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

            default:
                System.out.println("Enter valid input");
                break;
        }
    }

}
