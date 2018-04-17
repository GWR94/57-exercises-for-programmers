import java.util.Scanner;

/**
 * Created by HP on 22/06/2017.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        while(!quit) {
            System.out.println("What is the quote?");
            String quote = scanner.nextLine();
            System.out.println("Who said it?");
            String name = scanner.nextLine();
            System.out.println(name.substring(0,1).toUpperCase() + name.substring(1,name.length()).toLowerCase() + " says, \"" + quote.substring(0,1).toUpperCase() + quote.substring(1,quote.length()).toLowerCase() + "\".\n");
            System.out.println("Do you want another? Enter quit to terminate application");
            String answer = scanner.nextLine();
            if(answer.equals("quit")) {
                System.out.println("Cya!");
                quit = true;
            }
            System.out.println("");
        }
    }
}
