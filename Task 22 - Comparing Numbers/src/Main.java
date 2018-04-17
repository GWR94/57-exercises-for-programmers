import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by james on 10/07/2017.
 */
public class Main {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Double> numList = new ArrayList<>();
        System.out.println("How many numbers would you like to compare?");
        int numsToCompare = (int) returnDouble(s.nextLine());

        for(int i=0; i<numsToCompare; i++) {
            System.out.println("Enter number " + (i+1) + ":");
            numList.add(returnDouble(s.nextLine()));
            }
            System.out.println("Highest number is: " + findHighest(numList));
    }

    private static double findHighest(ArrayList<Double> numList) {
        double highest = -Double.MAX_VALUE;
        for(int i=0; i<numList.size(); i++) {
            if(numList.get(i) > highest) {
                highest = numList.get(i);
            }
        }
        return highest;
    }

    private static boolean checkDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        }catch(NumberFormatException e) {
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
                System.out.println("Error! Please enter a valid number: ");
                input = s.nextLine();
            }
        }
        return output;
    }
}
