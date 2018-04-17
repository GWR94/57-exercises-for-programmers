import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by james on 23/06/2017.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("#.00");
    public static void main(String[] args) {
        System.out.println("Enter the price of item one:");
        double item1 = checkDouble(scanner.nextLine());
        System.out.println("Enter the quantity of item one:");
        int quantity1 = checkInt(scanner.nextLine());
        System.out.println("Enter the price of item two:");
        double item2 = checkDouble(scanner.nextLine());
        System.out.println("Enter the quantity of item two:");
        int quantity2 = checkInt(scanner.nextLine());
        System.out.println("Enter the price of item three:");
        double item3 = checkDouble(scanner.nextLine());
        System.out.println("Enter the quantity of item three:");
        int quantity3 = checkInt(scanner.nextLine());

        double subtotal = (item1 * quantity1) + (item2 * quantity2) + (item3 * quantity3);
        double tax = subtotal * 0.055;
        double total = tax + subtotal;
        System.out.println("Subtotal: $" + df.format(subtotal) + "\nTax: $" + df.format(tax) +
                "\nTotal: $" + df.format(total));

    }

    private static boolean isInt(String input) {
        boolean isNum = true;
        try {
            Integer.parseInt(input);
        }
        catch(NumberFormatException e) {
            isNum = false;
        }
        return isNum;
    }

    private static boolean isDouble(String input) {
        boolean isNum = true;
        try {
            Double.parseDouble(input);
        }
        catch(NumberFormatException e) {
            isNum = false;
        }
        return isNum;
    }

    public static int checkInt(String inputStr) {
        String inputToCheck = inputStr;
        int input = 0;
        boolean completed = false;
        while(!completed) {
            if (isInt(inputToCheck)) {
                input = Integer.parseInt(inputToCheck);
                completed = true;
            }
            else {
                System.out.println("Error! Please insert integer values only: \n");
                inputToCheck = scanner.nextLine();
            }
        }
        return input;
    }


    public static double checkDouble(String inputStr) {
        String inputToCheck = inputStr;
        double input = 0;
        boolean completed = false;
        while(!completed) {
            if (isDouble(inputToCheck)) {
                input = Double.parseDouble(inputToCheck);
                completed = true;
            }
            else {
                System.out.println("Error! Please insert double values only: \n");
                inputToCheck = scanner.nextLine();
            }
        }
        return input;
    }


}
