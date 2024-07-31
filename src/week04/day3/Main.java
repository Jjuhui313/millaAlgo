package week04.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * baekjoon 1654 랜선 자르기
 *
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] line = new int[K];

        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(line);

        long answer = 0L;
        long left = 1L;
        long right = line[line.length - 1];

        while (left <= right) {
            long sum = 0L;
            long mid = (left + right) / 2;

            for (long l : line) {
                sum += l / mid;
            }

            if (sum < N) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}
