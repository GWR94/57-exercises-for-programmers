import java.util.Scanner;

/**
 * Created by james on 27/06/2017.
 */
public class Main {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        boolean complete = false;
        while (!complete) {
            System.out.println("What is the password?");
            String password = s.next();
            if (password.equals("ChElSeA")) {
                System.out.println("Welcome James!");
                complete = true;
            } else {
                System.out.println("I don't know you... \n------------------");
            }
        }
    }
}
