import java.util.Scanner;

/**
 * Created by james on 27/06/2017.
 */
public class Main {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hold old are you?");
        int age = checkInt(s.nextLine());
        System.out.println(age >= 17 ? "You are old enough to drive. You could have started learning " + (age-17) + (age-17==1 ? " year" : " years") + " ago!" : "You are not old enough to drive! You have " + Math.abs(age-17) + " years until you can learn to drive");
    }

    private static boolean checkInput(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    private static int checkInt(String input) {
        boolean complete = false;
        int output = 0;
        while(!complete) {
            if(checkInput(input)) {
                output = Integer.parseInt(input);
                while(output <= 0) {
                        System.out.println("Error! Please enter a valid age: ");
                        input = s.nextLine();
                        if(checkInput(input)) {
                            output = Integer.parseInt(input);
                            complete = true;
                        }
                }
                complete = true;
            }

            else{
                System.out.println("Error! Please enter a valid age: ");
                input = s.nextLine();
                checkInput(input);
            }
        }
        return output;
    }
}
