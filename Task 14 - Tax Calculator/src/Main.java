import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by james on 26/06/2017.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("#.00");

    public static void main(String[] args) {
        System.out.println("What is the order amount?");
        double amount = scanner.nextDouble();
        System.out.println("What is the state?");
        String state = scanner.next().toLowerCase();
        calculateTax(state, amount);
    }

    private static void calculateTax(String state, double amount) {
        double taxDbl = amount * 0.055;
        double finalAmountDbl = amount*1.055;
        BigDecimal finalAmount = new BigDecimal(finalAmountDbl);
        BigDecimal finalTaxedAmount = new BigDecimal(taxDbl);
        finalAmount = finalAmount.setScale(2, BigDecimal.ROUND_CEILING);
        finalTaxedAmount = finalTaxedAmount.setScale(2, BigDecimal.ROUND_CEILING);

        if(state.equals("wi")) {
            System.out.println("Subtotal: £" + amount + "\nTax: £" + finalTaxedAmount + "\nTotal: £" + finalAmount);

        }
        else {
            System.out.println("Total: " + amount);
        }
    }
}
