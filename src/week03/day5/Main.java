package week03.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/*
 * baekjoon 1759 암호 만들기
 *
 * */

public class Main {
    private static int L, C;
    private static char[] arr;
    private static LinkedHashSet<Character> list = new LinkedHashSet<>();
    private static boolean[] visited;
    private static boolean isAeiou;
    private static boolean isAlpha;
    private static int aeiouCnt;
    private static int alphaCnt;

    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        backtrack(0, 0);

        System.out.println(sb);

        br.close();
    }

    public static void backtrack(int depth, int start) {
        if (depth == L) {
            if (isAeiou && isAlpha) {
                for (Character l : list) {
                    sb.append(l);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (visited[i]) {
                continue;
            }

            // 'a', 'e', 'i', 'o', 'u' 중 하나라면 aeiouCnt 증가 / 아니라면 alphaCnt 증가
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i'
                    || arr[i] == 'o' || arr[i] == 'u') {
                aeiouCnt++;
            } else alphaCnt++;

            list.add(arr[i]);

            visited[i] = true;

            if (aeiouCnt >= 1) isAeiou = true;
            else isAeiou = false;

            if (alphaCnt >= 2) isAlpha = true;
                else isAlpha = false;

            backtrack(depth + 1, i + 1);

            visited[i] = false;
            list.remove(arr[i]);

            // 백트랙킹 후 돌아오면 증가시킨 aeiouCnt 혹은 alphaCnt 되돌리기
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i'
                    || arr[i] == 'o' || arr[i] == 'u') {
                aeiouCnt--;
            } else alphaCnt--;
        }
    }
}
