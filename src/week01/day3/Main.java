package week01.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * programmers 42583 LV.2 다리를 지나가는 트럭
 *
 * */

public class Main {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<Integer>();

        for (int truck: truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    q.offer(truck);
                    sum += truck;
                    answer++;
                    break;
                } else if (q.size() == bridge_length) {
                    sum -= q.poll();
                } else {
                    if (sum + truck > weight) {
                        q.offer(0);
                        answer++;
                    } else {
                        q.offer(truck);
                        sum += truck;
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bridge_length = Integer.parseInt(br.readLine());
        int weight = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        int[] truck_weights = new int[st.countTokens()];
        int idx = 0;
        while (st.hasMoreElements()) {
            truck_weights[idx++] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(bridge_length, weight, truck_weights));


    }
}
