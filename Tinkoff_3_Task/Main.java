package Tinkoff.Tinkoff_3_Task;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i]=scanner.nextInt();
        }

        int[] b = new int[n];
        for (int i = 0; i < n; i++){
            b[i]=scanner.nextInt();
        }

        int min = 0;
        int max = n;
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i])
            {min = i;
            break;
            }
        }

        for (int i = min+1; i < n; i++) {
            if (a[i] != b[i]) max = i;
        }

        if (n == 1){
            if (a[0] == b[0]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            int[] lucky = new int[max-min+1];

            for (int i = min; i < max+1; i++) {
                lucky[i - min] = a[i];
            }

            Arrays.sort(lucky);

            for (int i = min; i < max+1; i++) {
                a[i] = lucky[i - min];
            }

            boolean test = true;
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) test = false;
            }

            if (test) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
