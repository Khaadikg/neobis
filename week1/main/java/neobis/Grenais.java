package neobis;

import java.util.Scanner;

public class Grenais {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inter = 0, gremio = 0, empates = 0, total = 0;
        int p = 1;
        do {
            if (p == 1) {
                total++;
                int i = sc.nextInt();
                int j = sc.nextInt();
                if (i > j) {
                    inter++;
                } else if (j > i) {
                    gremio++;
                } else {
                    empates++;
                }
            }
            System.out.println("Novo grenal (1-sim 2-nao)");
            p = sc.nextInt();
        } while (p != 2);
        System.out.println(total + " grenais");
        System.out.println("Inter:" + inter);
        System.out.println("Gremio:" + gremio);
        System.out.println("Empates:" + empates);
        if (inter > gremio) {
            System.out.println("Inter venceu mais");
        } else if (inter < gremio) {
            System.out.println("Gremio venceu mais");
        } else {
            System.out.println("Nao houve vencedor");
        }
    }
}
