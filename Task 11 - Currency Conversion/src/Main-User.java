import java.util.Scanner;

/**
 * Created by HP on 24/06/2017.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("How many euros are you exchanging?");
        double amountFrom = inputDouble(scanner.nextLine());
        System.out.println("What is the current exchange rate?");
        double rateFrom = inputDouble(scanner.nextLine());
        System.out.println();
        double rateTo =
    }

    private static boolean checkDouble(String input) {
        try{
            double d = Double.parseDouble(input);

        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    private static double inputDouble(String input) {
        double output = 0;
        boolean complete = false;
        while(!complete) {
            if (checkDouble(input)) {
                output = Double.parseDouble(input);
                complete = true;
            } else {
                System.out.println("Error, please enter a correct input:");
                input = scanner.nextLine();
            }
        }
        return output;
    }

}
