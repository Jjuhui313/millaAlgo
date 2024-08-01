package week04.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * baekjoon 12026 BOJ 거리
 *
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if ((s.charAt(j) == 'B' && s.charAt(i) == 'O') ||
                    (s.charAt(j) == 'O' && s.charAt(i) == 'J') ||
                    (s.charAt(j) == 'J' && s.charAt(i) == 'B')) {
                        if (dp[j] != Integer.MAX_VALUE) {
                            dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                        }
                }
            }
        }

        int result = dp[N-1];
        if (result == Integer.MAX_VALUE) {
            result = -1; // 갈 수 없는 경우 -1 출력
        }
        System.out.println(result);

    }
}
