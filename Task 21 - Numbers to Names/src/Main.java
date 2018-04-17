import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by james on 10/07/2017.
 */
public class Main {
private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Would you like the months to be in English, French or German?");
        String inputStr = checkMonth(s.nextLine().toLowerCase());

        System.out.println("Please enter the numeric value of a month:");
        Dictionary engDict = new Hashtable();
        Dictionary gerDict = new Hashtable();
        Dictionary freDict = new Hashtable();
        int input = returnInt(s.nextLine());
        //English Dictionary
        engDict.put(1, "January");
        engDict.put(2, "February");
        engDict.put(3, "March");
        engDict.put(4, "April");
        engDict.put(5, "May");
        engDict.put(6, "June");
        engDict.put(7, "July");
        engDict.put(8, "August");
        engDict.put(9, "September");
        engDict.put(10, "October");
        engDict.put(11, "November");
        engDict.put(12, "December");
        //French Dictionary
        freDict.put(1, "Janvier");
        freDict.put(2, "Février");
        freDict.put(3, "Mars");
        freDict.put(4, "Avril");
        freDict.put(5, "Mai");
        freDict.put(6, "Juin");
        freDict.put(7, "Juillet");
        freDict.put(8, "Août");
        freDict.put(9, "Septembre");
        freDict.put(10, "Octobre");
        freDict.put(11, "Novembre");
        freDict.put(12, "Decmbre");
        //German Dictionary
        gerDict.put(1, "Januar");
        gerDict.put(2, "Februar");
        gerDict.put(3, "Marz");
        gerDict.put(4, "April");
        gerDict.put(5, "Mai");
        gerDict.put(6, "Juni");
        gerDict.put(7, "Juli");
        gerDict.put(8, "August");
        gerDict.put(9, "September");
        gerDict.put(10, "Oktober");
        gerDict.put(11, "November");
        gerDict.put(12, "Dezember");

        if(inputStr.equals("english")) {
            System.out.println("The chosen month is " + engDict.get(input));
        }
        else if(inputStr.equals("french")) {
            System.out.println("The chosen month is " + freDict.get(input));
        }
        else if(inputStr.equals("german")) {
            System.out.println("The chosen month is " + gerDict.get(input));
        }



        //Switch Statement Challenge
//        switch(input) {
//            case 1:
//                System.out.println("January");
//                break;
//            case 2:
//                System.out.println("February");
//                break;
//            case 3:
//                System.out.println("March");
//                break;
//            case 4:
//                System.out.println("April");
//                break;
//            case 5:
//                System.out.println("May");
//                break;
//            case 6:
//                System.out.println("June");
//                break;
//            case 7:
//                System.out.println("July");
//                break;
//            case 8:
//                System.out.println("August");
//                break;
//            case 9:
//                System.out.println("September");
//                break;
//            case 10:
//                System.out.println("October");
//                break;
//            case 11:
//                System.out.println("November");
//                break;
//            case 12:
//                System.out.println("December");
//                break;
//            default:
//                System.out.println("Error! Please enter a valid month");
//        }

    }

    private static String checkMonth(String input) {
        boolean complete = false;
        String output = "";
        while(!complete) {
            if((input.equals("english")) || (input.equals("french")) || (input.equals("german"))) {
                output = input;
                complete = true;
            }
            else {
                System.out.println("Please enter your desired language - \"English\", \"French\" or \"German\" :");
                input = s.nextLine();
            }
        }
        return output;
    }

    private static boolean checkInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }catch(NumberFormatException e) {
            return false;
        }
    }

    private static int returnInt(String input) {
        boolean complete = false;
        int output = 0;
        while(!complete) {
            if (checkInt(input)) {
                output = Integer.parseInt(input);
                if(output > 0 && output <=12) {
                    complete = true;
                }
                else {
                    System.out.println("Please enter a valid numerical value:");
                    input = s.nextLine();
                }
            }
            else {
                System.out.println("Error! Please enter a numerical value:");
                input = s.nextLine();
            }
        }
        return output;
     }
}
