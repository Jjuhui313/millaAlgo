package week02.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * baekjoon 1012 유기농 배추
 *
 * */

public class Main {
    private static boolean[][] graph;
    private static int M, N, K;
    private static final int MAX = 50 + 10;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            graph = new boolean[MAX][MAX];
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로
            N = Integer.parseInt(st.nextToken()); //세로
            K = Integer.parseInt(st.nextToken()); //노드

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()) + 1;
                int Y = Integer.parseInt(st.nextToken()) + 1;

                graph[X][Y] = true;
            }

            int count = 0;
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);

        }

        br.close();
    }

    private static void dfs(int x, int y) {
        graph[x][y] = false;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (graph[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }
}
