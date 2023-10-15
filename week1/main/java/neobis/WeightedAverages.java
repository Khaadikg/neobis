package neobis;

import java.util.Scanner;

public class WeightedAverages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = scanner.nextInt();

        for (int i = 0; i < lines; i++) {
            float one = scanner.nextFloat();
            float two = scanner.nextFloat();
            float three = scanner.nextFloat();

            double result = ((one * 2) + (two * 3) + (three * 5));
            System.out.printf("%.1f\n", result);
        }
    }
}
