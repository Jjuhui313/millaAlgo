package week03.option1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * baekjoon 1405 미친 로봇
 *
 * */

public class Main {
    private static int N;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {-1, 1, 0, 0};
    private static boolean[][] visited;
    private static double[] percent;
    private static double result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        percent = new double[4];
        for (int i = 0; i < 4; i++) {
            percent[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }
        visited = new boolean[30][30];
        result = 0;
        backtrack(15, 15, 0, 1);
        System.out.println(result);
    }

    public static void backtrack(int x, int y, int depth, double total) {
        if (depth == N) {
            result += total;
            return;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < 30 && newY >= 0 && newY < 30) {
                if (!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    backtrack(newX, newY, depth + 1, total * percent[i]);
                    visited[newX][newY] = false;
                }
            }
        }
        visited[x][y] = false;
    }
}
