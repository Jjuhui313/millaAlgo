package week04.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * programmers 43238 LV.3 입국심사
 *
 * */

public class Main {
    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = (long) n * times[times.length - 1];

        while (left <= right) {
            long sum = 0L;
            long mid = (left + right) / 2;
            for (int time : times) {
                sum += mid / time;
            }

            if (n > sum) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] times = new int[2];
        for (int i = 0; i < times.length; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, times));
    }
}
