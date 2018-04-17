import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by james on 10/07/2017.
 */
public class Main {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter two strings, and i'll tell you if they are anagrams!");
        System.out.println("Enter the first word:");
        String word1 = s.nextLine();
        System.out.println("Enter the second word:");
        String word2 = s.nextLine();
        checkAnagram(word1, word2);
    }

    private static void checkAnagram(String word1, String word2) {
        char[] word1char = word1.toLowerCase().toCharArray();
        char[] word2char = word2.toLowerCase().toCharArray();
        Arrays.sort(word1char);
        Arrays.sort(word2char);
        if(Arrays.equals(word1char, word2char)) {
            System.out.println(word1 + " is an anagram of " + word2);
        }
        else {
            System.out.println(word1 + " is not an anagram of " + word2);
        }
    }
}
