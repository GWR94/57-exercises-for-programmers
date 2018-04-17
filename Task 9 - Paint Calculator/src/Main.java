import java.util.Scanner;

/**
 * Created by james on 23/06/2017.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("What is the length of the room in feet?");
        int length = checkNumber(scanner.nextLine());
        System.out.println("What is the width of the room in feet?");
        int width = checkNumber(scanner.nextLine());
        int area = length * width;
        int leftOver = area % 350;
        int fullCans = area / 350;
        if(leftOver<350 && leftOver>0) {
            fullCans++;
        }
        System.out.println("You will need to buy " + fullCans + (fullCans>1 ? " cans" : " can") + " to cover " +
        area + " square feet.");
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
