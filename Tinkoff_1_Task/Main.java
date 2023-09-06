package Tinkoff.Tinkoff_1_Task;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s;
        int n;
        n = scanner.nextInt();
        s = scanner.nextInt();

        int[] array = new int[n];
        for (int a=0; a<array.length; a++){
            array[a]=scanner.nextInt();
        }

        int result = 0;
        int[] newArray = Arrays.stream(array).sorted().distinct().toArray();
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] > result && newArray[i] < s){
                result = newArray[i];
            }
        }
        System.out.println(result);
    }
}