import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;


/**
 * Created by HP on 24/06/2017.
 */
public class Main {
    private static DecimalFormat df = new DecimalFormat("#.00");
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the goal amount:");
        double pricipal = inputDouble(s.nextLine());
        System.out.println("Enter the rate of interest:");
        double interest = inputDouble(s.nextLine()) / 100;
        System.out.println("Enter the number of years:");
        int years = inputInt(s.nextLine());
        System.out.println("What is the amount of times the interest is compounded per year?");
        int compounded = inputInt(s.nextLine());
        double amount = (calculateAmount(pricipal, interest, years, compounded));
        BigDecimal finalAmount = new BigDecimal(amount);
        finalAmount = finalAmount.setScale(2, BigDecimal.ROUND_CEILING);
        System.out.println("After " + years + " years compounded " + compounded + " times per year , at an interest of "
                + interest*100 + "%, the investment will be worth £" + finalAmount);
    }

    private static boolean checkDouble(String input) {
        try{
            Double.parseDouble(input);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    private static boolean checkInt(String input) {
        try{
            Integer.parseInt(input);
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
                input = s.nextLine();
            }
        }
        return output;
    }

    private static int inputInt(String input) {
        int output = 0;
        boolean complete = false;
        while(!complete) {
            if (checkInt(input)) {
                output = Integer.parseInt(input);
                complete = true;
            } else {
                System.out.println("Error, please enter a correct input:");
                input = s.nextLine();
            }
        }
        return output;
    }
}
