import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by HP on 28/06/2017.
 */
public class Main {
    private static Scanner s = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.##");

    public static void main(String[] args) {
        System.out.println("Press F to convert from Fahrenheit to another measurement:\n" +
                "Press C to convert from Celcius to another measurement\n" +
                "Press K to convert Kelvin to another measurement\n" +
                "Your choice:");
        boolean complete = false;
        while(!complete) {
            String choice = s.nextLine().toLowerCase();
            switch(choice) {
                case "c":
                    convertCelcius();
                    break;
                case "f":
                    convertFahrenheit();
                    break;
                case "k":
                    convertKelvin();
                    break;
                default:
            }
        }
    }

    private static void convertCelcius() {
        boolean complete = false;
        System.out.println("Press F to convert to Fahrenheit\nPress K to convert to Kelvin: ");
        String choice = s.nextLine().toLowerCase();
        while(!complete) {
            if (choice.equals("f")) {
                convertCelciusToFahrenheit();
                complete = true;
            } else if (choice.equals("k")) {
                covertCelciusToKelvin();
                complete = true;
            } else {
                System.out.println("Error! Please input F or K to begin conversion: ");
                choice = s.nextLine().toLowerCase();
            }
        }
    }

    private static void convertFahrenheit() {
        boolean complete = false;
        System.out.println("Press C to convert to Celcius\nPress K to convert to Kelvin: ");
        String choice = s.nextLine().toLowerCase();
        while(!complete) {
            if (choice.equals("c")) {
                convertFahrenheitToCelcius();
                complete = true;
            } else if (choice.equals("k")) {
                convertFahrenheitToKelvin();
                complete = true;
            } else {
                System.out.println("Error! Please input C or K to begin conversion: ");
                choice = s.nextLine().toLowerCase();
            }
        }
    }

    private static void convertKelvin() {
        boolean complete = false;
        System.out.println("Press C to convert to Celcius\nPress F to convert to Fahrenheit: ");
        String choice = s.nextLine().toLowerCase();
        while(!complete) {
            if (choice.equals("f")) {
                convertKelvinToFahrenheit();
                complete = true;
            } else if (choice.equals("c")) {
                convertKelvinToCelcius();
                complete = true;
            } else {
                System.out.println("Error! Please input C or F to begin conversion: ");
                choice = s.nextLine().toLowerCase();
            }
        }
    }

    private static void covertCelciusToKelvin() {
        System.out.println("Please enter the temperature in Celcius: ");
        int celcius = returnInt(s.nextLine());
        double CtoK = (double)celcius + 273.5;
        System.out.println("The temperature in Kelvin is " + df.format(CtoK));
    }

    private static void convertCelciusToFahrenheit() {
        System.out.println("Please enter the temperature in Celcius: ");
        int celcius = returnInt(s.nextLine());
        double CtoF = (((double)celcius * 9) / 5) + 32;
        System.out.println("The temperature in Fahrenheit is " + df.format(CtoF));
    }

    private static void convertFahrenheitToCelcius() {
        System.out.println("Please enter the temperature in Celcius: ");
        int fahrenheit = returnInt(s.nextLine());
        double FtoC = ((double)fahrenheit - 32) / 1.8;
        System.out.println("The temperature in Fahrenheit is " + df.format(FtoC));
    }

    private static void convertFahrenheitToKelvin() {
        System.out.println("Please enter the temperature in Kelvin: ");
        int fahrenheit = returnInt(s.nextLine());
        double FtoK = (((double)fahrenheit + 459.67) * 5) /9;
        System.out.println("The temperature in Kevlin is " + df.format(FtoK));
    }

    private static void convertKelvinToFahrenheit() {
        System.out.println("Please enter the temperature in Kelvin: ");
        double kelvin = returnDouble(s.nextLine());
        double KtoF = kelvin * 9 / 5 - 459.67;
        System.out.println("The temperature in Fahrenheit is " + df.format(KtoF));
    }

    private static void convertKelvinToCelcius() {
        System.out.println("Please enter the temperature in Kevlin: ");
        double kelvin = returnDouble(s.nextLine());
        double KtoC = kelvin - 273.15;
        System.out.println("The temperature in Celcius is " + df.format(KtoC));
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

    private static int returnInt(String input) {
        boolean complete = false;
        int output = 0;
        while(!complete) {
            if(checkInt(input)) {
                output = Integer.parseInt(input);
                complete = true;
            }
            else {
                System.out.println("Error! Please enter a valid input: ");
                input = s.nextLine();
            }
        }
        return output;
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
            if(checkDouble(input)) {
                output = Double.parseDouble(input);
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
