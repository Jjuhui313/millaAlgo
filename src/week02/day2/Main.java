package week02.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * baekjoon 2667 단지번호붙이기
 *
 * */

public class Main {

    final static int MAX = 25 * 10;
    private static boolean[][] graph;

    private static int count;

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static void dfs(int x, int y) {
        graph[x][y] = false;
        count++;

        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];

            if (graph[newx][newy]) {
                dfs(newx, newy);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new boolean[MAX][MAX];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                graph[i][j] = s.charAt(j - 1) == '1';
            }
        }

        ArrayList<Integer> cntList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j]) {
                    count = 0;
                    dfs(i, j);
                    cntList.add(count);
                }
            }
        }

        System.out.println(cntList.size());
        Collections.sort(cntList);
        for (Integer cnt : cntList) {
            System.out.println(cnt);
        }

        br.close();

    }
}
