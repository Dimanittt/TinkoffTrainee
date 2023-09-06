package Tinkoff.Tinkoff_6_Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //кол-во духов
        int m = scanner.nextInt(); //кол-во вопросов
        Map<Integer, Integer> spirits = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            spirits.put(i, 1);
        }
        ArrayList<ArrayList<Integer>> spiritsTeam = new ArrayList<>(n+1);
        spiritsTeam.add(0, new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            spiritsTeam.add(i, new ArrayList<Integer>());
            spiritsTeam.get(i).add(i);
        }
        for (int i = 0; i < m; i++) {
            int q = scanner.nextInt();
            if (q == 1) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                ArrayList<Integer> team1 = new ArrayList<>();
                int teamNumber = -1;
                for (ArrayList<Integer> al : spiritsTeam){
                    teamNumber++;
                    if (al.contains(x)) {
                        team1.addAll(al);
                        break;
                    }
                }
                ArrayList<Integer> team2 = new ArrayList<>();
                for (ArrayList<Integer> al : spiritsTeam){
                    if (al.contains(y)) {
                        team2.addAll(al);
                        break;
                    }
                }
                if (!team1.contains(y)) {
                    team1.addAll(team2);
                    spiritsTeam.set(teamNumber, team1);
                    for (Integer j : spiritsTeam.get(teamNumber)) {
                        int num = spirits.get(j);
                        spirits.put(j, (num + 1));
                    }
                    spiritsTeam.remove(team2);
                }
            }
            if (q == 2) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                boolean check = false;
                for (ArrayList<Integer> al : spiritsTeam){
                    if (al.contains(x) && al.contains(y)) check = true;
                }
                if (check) System.out.println("YES");
                else System.out.println("NO");
            }
            if (q == 3){
                int x = scanner.nextInt();
                System.out.println(spirits.get(x));
            }
        }
    }
}
