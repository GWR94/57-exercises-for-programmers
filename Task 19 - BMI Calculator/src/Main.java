import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by james on 27/06/2017.
 */
public class Main {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("What is your height? (inches) :");
        double height = returnDouble(s.nextLine());
        System.out.println("What is your weight? (pounds) :");
        double weight = returnDouble(s.nextLine());
        System.out.println(calculateBMI(height, weight));

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
                while(output<0) {
                    System.out.println("Error! Please enter a valid input:");
                    input = s.nextLine();
                    if(checkDouble(input)) {
                        output = Double.parseDouble(input);
                        complete = true;
                    }
                }
                output = Double.parseDouble(input);
                complete = true;
            } else {
                System.out.println("Error! Please enter a valid input: ");
                input = s.nextLine();
            }
        }
        return output;
    }

    private static String calculateBMI(double height, double weight) {
        DecimalFormat df = new DecimalFormat("0.0");
        String output = "";
        double BMI = (weight/(height*height)) * 703;
        if(BMI>25) {
            output = "Your BMI is " + df.format(BMI) + "\nYou are overweight. You should see a doctor.";
        }
        else if(BMI<18.5) {
            output = "Your BMI is " + df.format(BMI) + "\nYou are underweight. You should see a doctor.";
        }
        else {
            output = "Your BMI is " + df.format(BMI) + "\nYou are within the ideal weight!";
        }
    return output;
    }

}
