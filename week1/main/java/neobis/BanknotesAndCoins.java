package neobis;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BanknotesAndCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double n = sc.nextDouble();
        if (n >= 0) {
            int[] banknotes = {100, 50, 20, 10, 5, 2};
            double[] coins = {1.00, 0.50, 0.25, 0.10, 0.05, 0.01};
            System.out.println("NOTAS:");
            for (int banknote : banknotes) {
                int t = (int) (n / banknote);
                System.out.printf("%d nota(s) de R$ %.2f\n", t, (double) banknote);
                n = toDouble(n - banknote * t);
            }
            System.out.println("MOEDAS:");
            for (double coin : coins) {
                int t = (int) (n / coin);
                System.out.printf("%d moeda(s) de R$ %.2f\n", (int) (n / coin), coin);
                n = toDouble(n - coin * t);
            }
        }

    }
    private static double toDouble(double x) {
        DecimalFormat format = new DecimalFormat("#0.00");
        return Double.parseDouble(format.format(x));
    }

}
