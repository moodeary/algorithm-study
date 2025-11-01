package backjoon.동적프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식_2156_실버1 {
    
    static int[] dp;
    static int[] wines;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        wines = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = wines[1];

        if (N >= 2) {
            dp[2] = wines[1] + wines[2];
        }

        for (int i = 3; i <= N; i++) {

            int case1 = dp[i - 3] + wines[i - 1] + wines[i];
            int case2 = dp[i - 2] + wines[i];
            int case3 = dp[i - 1];

            dp[i] = Math.max(case1, Math.max(case2, case3));
        }

        System.out.println(Math.max(dp[N], dp[N-1]));
    }
}
