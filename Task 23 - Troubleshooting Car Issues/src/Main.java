import java.util.Scanner;

/**
 * Created by james on 10/07/2017.
 */
public class Main {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=======================================\n" +
                         "Welcome to the car troubleshooting guide!\n" +
                         "Please click type \"Y\" to answer \"Yes\"\n" +
                         "Or \"N\" to answer \"No\".\n" +
                         "Are you ready to begin?\n" +
                         "=======================================");
        if(checkInput(s.nextLine())) {
            System.out.println("Is the car silent when you turn the key?");
            if (checkInput(s.nextLine())) {
                System.out.println("Are the battery terminals corroded?");
                if (checkInput(s.nextLine())) {
                    System.out.println("Clean terminals and try starting again.");
                    System.exit(0);
                } else {
                    System.out.println("Replace the cables and try again");
                    System.exit(0);
                }
            } else {
                System.out.println("Does the car make a clicking noise?");
                if (checkInput(s.nextLine())) {
                    System.out.println("Replace the battery");
                } else {
                    System.out.println("Does the car crank up but fail to start?");
                    if (checkInput(s.nextLine())) {
                        System.out.println("Check spark plug connections");
                    } else {
                        System.out.println("Does the engine start and then die?");
                        if (checkInput(s.nextLine())) {
                            System.out.println("Does your car have fuel injection?");
                            if (checkInput(s.nextLine())) {
                                System.out.println("Get it in for a service!");
                            } else {
                                System.out.println("Check to ensure the choke is opening and closing");
                            }
                        } else {
                            System.out.println("Get it in for a service!");
                        }
                    }
                }
            }
        }
        else {
            System.exit(0);
        }


    }

    //Checks for valid input for program
    private static boolean checkInput(String input) {
        boolean complete = false;
        boolean outcome = false;
        while(!complete) {
            if ((input.equals("y")) || (input.equals("yes"))) {
                outcome = true;
                complete = true;
            }
            else if(input.equals("n") || input.equals("no")) {
                outcome = false;
                complete = true;
            }
            else {
                System.out.println("Error! Please enter \"Y\" or \"N\"");
                input = s.nextLine();
            }
        }
        return outcome;
    }
}
