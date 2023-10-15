package neobis;

import java.util.Scanner;

public class PopulationIncrease {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int small = scanner.nextInt();
            int big = scanner.nextInt();
            double small_percent = scanner.nextDouble();
            double big_percent = scanner.nextDouble();

            int year = 0;
            while (big >= small) {
                small += (small * small_percent) / 100;
                big += (big * big_percent) / 100;
                year++;
                if (year > 100) {
                    break;
                }
            }
            if (year > 100) {
                System.out.println("Mais de 1 seculo.");
            } else {
                System.out.println(year + " anos.");
            }
        }
    }
}
