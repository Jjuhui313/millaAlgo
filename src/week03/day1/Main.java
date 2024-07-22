package week03.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * baekjoon 15663 N과 M(9)
 *
 * */

public class Main {
    private static int N, M;
    private static int[] numbers;
    private static boolean[] visited;
    private static ArrayList<Integer> cur = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        backtrack(0);
        System.out.println(sb);
    }

    public static void backtrack(int depth) {
        if (depth == M) {
            for (int num : cur) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int lastUsed = -1;

        for (int i = 0; i < N; i++) {
            if (!visited[i] && (lastUsed != numbers[i])) {
                visited[i] = true;
                cur.add(numbers[i]);
                lastUsed = numbers[i];

                backtrack(depth + 1);

                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
