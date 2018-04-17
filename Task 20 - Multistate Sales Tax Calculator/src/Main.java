import java.util.Scanner;

/**
 * Created by james on 28/06/2017.
 */
public class Main {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("What is the order amount?");
        double amount = returnDouble(s.nextLine());
        System.out.println("What state do you live in?");
        String state = s.nextLine();
        calculateTax(state.toLowerCase(), amount);

    }

    private static void calculateTax(String state, double amount) {
        if(state.equals("wisconsin") || state.equals("wi")) {
            System.out.println();
        }
    }

    private static boolean checkInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    private static boolean checkDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    private static double returnDouble(String input) {
        boolean complete = false;
        double output = 0;
        while(!complete) {
            if (checkDouble(input)) {
                output = Double.parseDouble(input);
                while(output < 0) {
                    System.out.println("Error! Please enter a valid input: ");
                    input = s.nextLine();
                    if(checkDouble(input)) {
                        output = Double.parseDouble(input);
                    }
                }
                complete = true;
            }
            else {
                System.out.println("Error! Please enter a valid input: ");
                input = s.nextLine();
            }
        }
        return output;
    }
}
