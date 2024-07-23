package week03.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*
 * baekjoon 15651 N과 M(3)
 *
 * */

public class Main {
    private static int N, M;
    private static int[] numbers;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        numbers = new int[M];
        backtrack(0);
        System.out.println(sb);
    }

    public static void backtrack(int depth) {
        if (depth == M) {
            for (int i : numbers) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            numbers[depth] = i + 1;
            backtrack(depth + 1);
        }
    }
}
