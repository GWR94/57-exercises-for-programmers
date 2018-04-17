import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by james on 12/07/2017.
 */
public class SearchFile {

    public static boolean loginCheck(String username, String password) throws IOException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("loginCredentials.txt")));
        String usernameSearch = "USERNAME: " + username;
        String passwordSearch = "PASSWORD: " + password;
        while (s.hasNext()) {
            if (s.nextLine().equals(usernameSearch)) {
                if (s.nextLine().equals(passwordSearch)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int usernameTaken(String username) throws IOException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("loginCredentials.txt")));
        String usernameSearch = "USERNAME: " + username;
        while (s.hasNext()) {
            if (s.nextLine().equals(usernameSearch)) {
                return -1;
            }
        }
        return 1;
    }

    public static ArrayList<String> returnCredentials(String username, String password) throws IOException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("loginCredentials.txt")));
        String usernameSearch = "USERNAME: " + username;
        ArrayList<String> credentials = new ArrayList<>();
        if (loginCheck(username, password)) {
            credentials.add(username);
            while (s.hasNext()) {
                if (s.nextLine().equals(usernameSearch)) {
                    credentials.add(s.nextLine().substring(10));
                    credentials.add(s.nextLine().substring(7));
                    credentials.add(s.nextLine().substring(7));
                    credentials.add(s.nextLine().substring(7));
                }
            }
        }
        else {
            credentials = null;
        }
        return credentials;
    }

    public static int emailTaken(String email) throws IOException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("loginCredentials.txt")));
        String emailSearch = "EMAIL: " + email;
        while (s.hasNext()) {
            if (s.nextLine().equals(emailSearch)) {
                return -1;
            }
        }
        return 0;
    }
}

