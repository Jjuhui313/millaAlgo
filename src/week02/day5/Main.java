package week02.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * baekjoon 1697 숨바꼭질
 *
 * */

public class Main {

    private final static int MIN = 0;
    private final static int MAX = 100000;
    private static int N, K;
    private static int[] time = new int[MAX + 1];
    private static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    private static int bfs(int n) {
        time[n] = 0;
        q.offer(n);

        while (!q.isEmpty()) {
            n = q.poll();

            if (n == K) break;

            int next = time[n] + 1; //1초 증가

            if (n - 1 >= MIN && time[n - 1] == 0) {
                time[n - 1] = next;
                q.offer(n - 1);
            }
            if (n + 1 <= MAX && time[n + 1] == 0) {
                time[n + 1] = next;
                q.offer(n + 1);
            }
            if (n * 2 <= MAX && time[n * 2] == 0) {
                time[n * 2] = next;
                q.offer(n * 2);
            }
        }

        return time[K];

    }
}
