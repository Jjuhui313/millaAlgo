package week02.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * baekjoon 2178 미로 탐색
 *
 * */

public class Main {

    private final static int MAX = 100;
    private final static int MIN = 0;

    private static int[][] graph = new int[MAX + 1][MAX + 1];
    private static boolean[][] visit = new boolean[MAX + 1][MAX + 1];

    private static Queue<int[]> q = new LinkedList<>();

    private static int N, M;

    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                graph[i + 1][j + 1] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs(1, 1));
    }

    public static int bfs(int x, int y) {
        visit[x][y] = true;
        q.add(new int[] {x, y});

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int curX = pos[0];
            int curY = pos[1];

            int next = graph[curX][curY] + 1;

            for (int i = 0; i < 4; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if (newX >= MIN && newY >= MIN && newX <= N && newY <= M) {
                    if (!visit[newX][newY] && graph[newX][newY] == 1) {
                        visit[newX][newY] = true;
                        graph[newX][newY] = next;
                        q.add(new int[] {newX, newY});
                    }
                }
            }
        }

        return graph[N][M];

    }
}
