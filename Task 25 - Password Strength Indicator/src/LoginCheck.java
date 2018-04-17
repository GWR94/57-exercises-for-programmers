import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HP on 11/07/2017.
 */
public class LoginCheck {

    SearchFile search = new SearchFile();

    public static int nameValidator(String name) {
        if(checkSpaces(name)) {
            return -1;
        }
        else if(containsSpecial(name)) {
            return -1;
        }
        else if(name.length() < 2) {
            return -1;
        }
        return 4;
    }

    public static int usernameValidator(String username) {
        if(checkSpaces(username)) {
            return -1;
        }
        else if(containsSpecial(username)) {
            return -1;
        }
        else if(username.length() <= 5) {
            return -1;
        }
        return 4;
    }

    public static int passwordValidator(String password) {
        int strength = 0;

        //Check for spaces
        if (checkSpaces(password)) {
            return -1;
        }

        //Check password less than 8 characters long
        if (password.length() < 8) {
            if(password.length()<=5) {
                strength = -1;
            }
            else if (password.matches("[0-9]+")) {
                strength = 1;
            } else if (password.matches("[a-zA-Z]+")) {
                strength = 2;
            } else {
                strength = 3;
            }
        }

        //Check password with 8 or more characters
        else {
            if (hasAll(password)) {
                strength = 5;
            }
            else if (containsAlphabetic(password) && containsNumeric(password)) {
                strength = 4;
            }
            else {
                strength = 3;
            }
        }
        return strength;
    }

    private static boolean containsSpecial(String password) {
        boolean specialChar = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.substring(i,i+1).matches("[^A-Za-z0-9 ]")) {
                specialChar = true;
            }
        }
        return specialChar;
    }

    private static boolean containsAlphabetic(String password) {
        boolean alphabet = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.substring(i, i + 1).matches("[A-Za-z]")) {
                alphabet = true;
            }
        }
        return alphabet;
    }

    private static boolean containsNumeric(String password) {
        boolean numeric = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.substring(i, i + 1).matches("[0-9]")) {
                numeric = true;
            }
        }
        return numeric;
    }

    private static boolean checkSpaces(String password) {
        return password.contains(" ");
    }

    private static boolean hasAll(String password) {
        boolean perfect;
        if ((containsAlphabetic(password)) && (containsNumeric(password)) && (containsSpecial(password))) {
            perfect = true;
        } else {
            perfect = false;
        }
        return perfect;
    }
}