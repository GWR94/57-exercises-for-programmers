import java.util.Scanner;

/**
 * Created by HP on 23/06/2017.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("What is the first number?");
        String num1Str = scanner.nextLine();
        int num1 = 0;
        boolean completed = false;
        if(!completed) {
            if (isNumeric(num1Str)) {
                num1 = Integer.parseInt(num1Str);
                completed = true;
            } else {
                System.out.println("Error! Please enter digits only:");
                num1Str = scanner.nextLine();
            }
        }

        System.out.println("What is the second number?");
        String num2Str = scanner.nextLine();
        int num2 = 0;
        completed = false;
        if(!completed) {
            if (isNumeric(num2Str)) {
                num1 = Integer.parseInt(num2Str);
                completed = true;
            } else {
                System.out.println("Error! Please enter digits only:");
                num1Str = scanner.nextLine();
            }
        }
        System.out.println(num1 + " + " + num2 +  " = " + add(num1,num2) + "\n");
        System.out.println(num1 + " - " + num2 +  " = " + subtract(num1,num2) + "\n");
        System.out.println(num1 + " * " + num2 +  " = " + multiply(num1,num2) + "\n");
        System.out.println(num1 + " / " + num2 +  " = " + divide(num1,num2) + "\n");
    }

    private static int add(int num1, int num2) {
        return num1 + num2;
    }

    private static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    private static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private static int divide(int num1, int num2) {
        return num1 / num2;
    }

    private static boolean isNumeric(String input) {
        if(input.chars().allMatch(Character::isDigit)) {
            return true;
        }
        return false;
    }
}
