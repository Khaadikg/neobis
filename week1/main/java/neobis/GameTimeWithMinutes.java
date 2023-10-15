package neobis;

import java.util.Scanner;

public class GameTimeWithMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first_hour = scanner.nextInt();
        int first_min = scanner.nextInt();
        int second_hour = scanner.nextInt();
        int second_min = scanner.nextInt();

        int diff = ((second_hour * 60) + second_min) - ((first_hour * 60) + first_min);
        if (diff <= 0) diff += 24 * 60;
        System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", diff / 60, diff % 60);
    }
}
