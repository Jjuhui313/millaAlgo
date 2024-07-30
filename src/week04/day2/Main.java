package week04.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * baekjoon 2805 나무 자르기
 *
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        long answer = 0;
        long left = 0L;
        long right = tree[tree.length - 1];
        while (left <= right) {
            long sum = 0L;
            long mid = (left + right) / 2;

            for (int t : tree) {
                if (t > mid) {
                    sum += t - mid;
                }
            }

            if (sum < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}
