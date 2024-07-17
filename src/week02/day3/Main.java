package week02.day3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * baekjoon 11724 연결 요소의 개수
 *
 * */

public class Main {

    static int[][] graph = new int[1001][1001];
    static int N;
    static int M;
    static boolean[] visited = new boolean[1001];

    public static void dfs(int idx) {
        if(visited[idx])
            return;
        else {
            visited[idx] = true;
            for(int i = 1; i <= N; i++) {
                if(graph[idx][i] == 1) {
                    dfs(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int a,b;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // 간선 연결
            graph[a][b] = graph[b][a] = 1;
        }

        int count = 0 ;

        // dfs 탐색
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);

        br.close();
    }
}
