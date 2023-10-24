import com.ayush.demo;
import java.text.NumberFormat;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal;
        double monthlyInterest;
        int numberOfPayments;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($1k - $1M): ");
            principal = scanner.nextInt();

            if ( principal >= 1000 && principal <= 1_000_000 )
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        while (true) {
            System.out.print("Annual interest Rate: ");
            double annualInterest = scanner.nextFloat();

            if ( annualInterest > 0 && annualInterest <= 30 ) {
                monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
                break; }
            System.out.println("Enter a value between 1 and 30.");
        }

        while (true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();

            if ( years > 0 && years <= 30 ) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break; }
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = principal
                * ( monthlyInterest * Math.pow( 1 + monthlyInterest, numberOfPayments )
                / ( Math.pow( 1 + monthlyInterest, numberOfPayments) - 1 ));

        String mortgageCurrency = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageCurrency);
        demo smm=new demo();
        System.out.println(smm.sm(3,7));
    }
}