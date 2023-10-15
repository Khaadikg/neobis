package neobis;

import java.util.Scanner;

public class Banknotes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n > 0){
            int[] banknotes = {100,50,20,10,5,2,1};
            System.out.println(n);
            for (int banknote : banknotes) {
                System.out.printf("%d nota(s) de R$ %d,00\n", n / banknote, banknote);
                n = n % banknote;
            }
        }
    }
}
