package week03.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * baekjoon 6987 월드컵
 *
 * */

public class Main {

    private static boolean isOk;

    private static int[] arr1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    private static int[] arr2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};

    private static int[] win = new int[6];
    private static int[] draw = new int[6];
    private static int[] lose = new int[6];

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int W = 0;
            int D = 0;
            int L = 0;
            isOk = false;

            for (int j = 0; j < 6; j++) {
                W += win[j] = Integer.parseInt(st.nextToken());
                D += draw[j] = Integer.parseInt(st.nextToken());
                L += lose[j] = Integer.parseInt(st.nextToken());
            }
            if (W + D + L != 30) {
                isOk = false;
            } else {
                backtrack(0);
            }
            sb.append(isOk ? "1" : "0").append(" ");
        }
        br.close();
        System.out.println(sb);
    }

    public static void backtrack(int round) {
        if (isOk) {
            return;
        }
        if (round == 15) {
            isOk = true;
            return;
        }

        int team1 = arr1[round];
        int team2 = arr2[round];

        if (win[team1] > 0 && lose[team2] > 0) {
            win[team1]--;
            lose[team2]--;
            backtrack(round + 1);
            win[team1]++;
            lose[team2]++;
        }

        if (draw[team1] > 0 && draw[team2] > 0) {
            draw[team1]--;
            draw[team2]--;
            backtrack(round + 1);
            draw[team1]++;
            draw[team2]++;
        }

        if (win[team2] > 0 && lose[team1] > 0) {
            win[team2]--;
            lose[team1]--;
            backtrack(round + 1);
            win[team2]++;
            lose[team1]++;
        }

    }
}
