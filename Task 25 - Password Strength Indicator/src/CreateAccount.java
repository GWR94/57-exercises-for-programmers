import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by james on 12/07/2017.
 */
public class CreateAccount {
    public void addRecords(String username, String password, String fName, String sName, String email) {
        try {
            File file = new File("C:\\Users\\james\\OneDrive\\57 Exercises For Programmers\\Task 25 - Password Strength Indicator\\loginCredentials.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            SearchFile search = new SearchFile();
            if(search.loginCheck(username, password)) {
                System.out.println("Already on file! Not added");
            }
            else {
                bw.write("USERNAME: " + username + "\nPASSWORD: " + password + "\nFNAME: " + fName + "\nSNAME: " + sName + "\nEMAIL: " + email + "\n__________________\n");
                bw.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



}
