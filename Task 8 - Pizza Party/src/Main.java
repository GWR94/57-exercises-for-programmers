import java.util.Scanner;

/**
 * Created by james on 23/06/2017.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("How many people?");
        int people = checkNumber(scanner.nextLine());
        System.out.println("How many pizzas do you have?");
        int pizza = checkNumber(scanner.nextLine());
        System.out.println("How many slices to each pizza?");
        int slices = checkNumber(scanner.nextLine());
        int allSlices = slices * pizza;
        int leftOvers = allSlices % people;
        int eachPerson = allSlices / people;
        if(people>slices) {
            System.out.println("There isn't enough pizza for everybody! \n" +
                    "This is because there are " + people + " people and only " + slices +
                    " slices.\n" + (people - slices) + ((people-slices)>1 ? " people": " person") + " will not have a slice." );
        }
        else if (leftOvers == 1) {
            System.out.println(people + " people with " + pizza + " pizzas. \n" +
                    "Each person gets " + eachPerson + " slices.\n" +
                    "There is " + leftOvers + " leftover slice");
        } else {
            System.out.println(people + " people with " + pizza + " pizzas. \n" +
                    "Each person gets " + eachPerson + " slices.\n" +
                    "There are " + leftOvers + " leftover slices");
        }
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
