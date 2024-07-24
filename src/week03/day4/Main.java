package week03.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * baekjoon 1182 부분수열의 합
 *
 * */

public class Main {
    private static int N, S;
    private static int[] arr;
    private static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0);

        if (S == 0) count--;

        br.close();
        System.out.println(count);
    }

    public static void backtrack(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        backtrack(depth + 1, arr[depth] + sum);
        backtrack(depth + 1, sum);
    }
}
