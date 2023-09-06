package Tinkoff.Tinkoff_2_Task;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] stringCharArray = string.toCharArray();

        Map<Character, Integer> sheriffMap = new HashMap<>();
        sheriffMap.put('s', 0);
        sheriffMap.put('h', 0);
        sheriffMap.put('e', 0);
        sheriffMap.put('r', 0);
        sheriffMap.put('i', 0);
        sheriffMap.put('f', 0);

        for (Character ch : string.toCharArray()){
            if (sheriffMap.containsKey(ch)){
                int num = sheriffMap.get(ch);
                sheriffMap.put(ch, (num+1));
            }
        }

        int[] chars = {sheriffMap.get('s'), sheriffMap.get('h'), sheriffMap.get('e'),
                sheriffMap.get('r'), sheriffMap.get('i'), sheriffMap.get('f')/2};
        Arrays.sort(chars);

        System.out.println(chars[0]);
    }
}
