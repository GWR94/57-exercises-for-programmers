import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by james on 23/06/2017.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("#.###");
    public static void main(String[] args) {
        System.out.println("What is the length of the room in feet?");
        int length = checkNumber(scanner.nextLine());
        System.out.println("What is the width of the room in feet?");
        int width = checkNumber(scanner.nextLine());
        int areaFeet = length * width;
        double areaMetres = length * width * 0.09290304;
        System.out.println("The area is:\n" +
                areaFeet + " square feet\n" +
                df.format(areaMetres) + " square metres");


    }
    private static boolean isNum(String input) {
        boolean isNum = true;
        try {
            Integer.parseInt(input);
        }
        catch(NumberFormatException e) {
            isNum = false;
        }
        return isNum;
    }

    private static int checkNumber(String inputStr) {
        String inputToCheck = inputStr;
        int input = 0;
        boolean completed = false;
        while(!completed) {
            if (isNum(inputToCheck)) {
                input = Integer.parseInt(inputToCheck);
                completed = true;
            }
            else {
                System.out.println("Error! Please insert digits only:");
                inputToCheck = scanner.nextLine();
            }
        }
        return input;
    }

}
