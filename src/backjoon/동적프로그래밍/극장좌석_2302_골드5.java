package backjoon.동적프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 극장좌석_2302_골드5 {

    static int[] dp;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        result = new int[M + 1];

        int before = 0;
        for (int i = 0; i < M; i++) {
            int now = Integer.parseInt(br.readLine());
            result[i] = now - before - 1;
            before = now;
        }

        result[M] = N - before;

        dp[0] = 1;
        dp[1] = 1;


        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        long re = 1;
        for(int cnt : result) {
            if (cnt != 0) {
                re *= dp[cnt];
            }
        }

        System.out.println(re);
    }
}
