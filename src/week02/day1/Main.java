package week02.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * baekjoon 1260 DFS와 BFS
 *
 * */

public class Main {
    private static Queue<Integer> q = new LinkedList<>();
    private static boolean[] check;
    private static int[][] arr;
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        check = new boolean[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(V);
        sb.append("\n");
        check = new boolean[N + 1];

        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int V) {
        check[V] = true;
        sb.append(V).append(" ");
        for (int i = 0; i <= N; i++) {
            if (arr[V][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int V) {
        q.add(V);
        check[V] = true;
        while (!q.isEmpty()) {
            V = q.poll();
            sb.append(V).append(" ");

            for (int i = 1; i <= N; i++) {
                if (arr[V][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
