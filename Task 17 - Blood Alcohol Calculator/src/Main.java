import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by HP on 27/06/2017.
 */
public class Main {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.000");

        System.out.println("How much alcohol have you consumed? (oz) :");
        double alcohol = returnDouble(s.nextLine());
        System.out.println("How much do you weight? (pounds) :");
        double weight = returnDouble(s.nextLine());
        System.out.println("Are you male or female?");
        double alcoholRatio = checkRatio(s.nextLine());
        System.out.println("How many hours was it since your last drink?");
        double hours = returnDouble(s.nextLine());
        double bloodAlcoholContext = ((alcohol * 5.14) /(weight * alcoholRatio)) - (0.015 * hours);

        System.out.println("Have you been driving as part of your profession?");
        boolean completed = false;
        String answer = s.nextLine().toLowerCase();
        while(!completed) {
            if(answer.equals("yes")) {
                System.out.println("------------------------------------");
                System.out.println("Your blood content is: " + df.format(bloodAlcoholContext) + "\nIt is " +
                        (bloodAlcoholContext > 0.02 ? "not " : "") + "legal for you to drive.\n" +
                        "The blood alcohol content is 0.02 for professional drivers.");
                System.out.println("------------------------------------");
                completed = true;

            }
            else if(answer.equals("no")) {
                System.out.println("------------------------------------");
                System.out.println("Your blood content is: " + df.format(bloodAlcoholContext) + "\nIt is " +
                      (bloodAlcoholContext > 0.08 ? "not " : "") + "legal for you to drive.");
                System.out.println("------------------------------------");
                completed = true;
            }
            else {
                System.out.println("Error! Please enter yes or no:");
                answer = s.nextLine().toLowerCase();
            }
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
        double output = 0.0D;
        while (!complete) {
            if (checkDouble(input)) {
                output = Double.parseDouble(input);
                if (output < 0) {
                    while (output < 0) {
                        System.out.println("Error! Please enter a valid input:");
                        input = s.nextLine();
                        if(checkDouble(input)) {
                            output = Double.parseDouble(input);
                        }
                    }
                    complete = true;
                }
                complete = true;
            } else {
                System.out.println("Error! Please enter a valid input:");
                input = s.nextLine();
            }
        }
        return output;
    }

    private static double checkRatio(String input) {
        boolean completed = false;
        double output = 0.0D;
        while (!completed) {
            if (input.toLowerCase().equals("male")) {
                output = 0.73;
                completed = true;
            }
            else if(input.toLowerCase().equals("female")) {
                output = 0.66;
                completed = true;
            }
            else {
                System.out.println("Error! Please enter male or female: ");
                input = s.nextLine();
            }
        }
        return output;
    }
}
