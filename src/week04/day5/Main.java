package week04.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * baekjoon 1495 기타리스트
 *
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = -1;
        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) {
                    int plus = j + n;
                    int minus = j - n;

                    if (plus <= M) {
                        dp[i][plus] = true;
                    }
                    if (minus >= 0) {
                        dp[i][minus] = true;
                    }
                }
            }
        }

        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
