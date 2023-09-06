package Tinkoff.Tinkoff_4_Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m;
        int n;
        n = scanner.nextInt();
        m = scanner.nextInt();

        int[] array = new int[m];
        for (int a = 0; a < array.length; a++){
            array[a]=scanner.nextInt();
        }
        int[] numbers = new int[array.length*2];
        for (int i = 0; i < numbers.length/2; i++) {
            numbers[i] = array[i];
            numbers[numbers.length-1] = array[i];
        }
        int[][] dp = new int[numbers.length+1][n+1];
        for (int i = 1; i <= numbers.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (numbers[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-numbers[i-1]] + numbers[i-1]);
                }
            }
        }
        int i = numbers.length;
        int j = n;
        List<Integer> selectedNumbers = new ArrayList<>();
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i-1][j]) {
                selectedNumbers.add(numbers[i-1]);
                j -= numbers[i-1];
            }
            i--;
        }
        int testSum = 0;
        int[] selectedNumbersArray = new int[selectedNumbers.size()];
        for (int k = 0; k <selectedNumbers.size(); k++) {
            testSum += selectedNumbers.get(k);
        }
        if (testSum != n) System.out.println(-1);
        else {
            System.out.println(selectedNumbersArray.length);
            for (int k = 0; k < selectedNumbersArray.length; k++) {
                System.out.print(selectedNumbers.get(k) + " ");
            }
        };
    }
}