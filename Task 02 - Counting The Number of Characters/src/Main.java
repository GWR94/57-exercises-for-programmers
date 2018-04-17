import java.util.Scanner;

/**
 * Created by HP on 22/06/2017.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            System.out.println("Please enter a word:");
            String str = scanner.nextLine().toLowerCase();

            if (str.equals("")) {
                System.out.println("Please enter a word to be counted\n");
            }
            else if(str.equals("quit")) {
                System.out.println("Cya!\n");
                quit = true;
            }
            else {
                System.out.println(str.substring(0,1).toUpperCase() + str.substring(1, str.length()) + " has " + str.length() + " characters.\n");
            }

        }

    }
}