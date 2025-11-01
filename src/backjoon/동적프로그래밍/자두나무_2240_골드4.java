package backjoon.동적프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자두나무_2240_골드4 {

    static int[][] dp;
    static int[] fruits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // dp[i][j] = i초에 j번 이동했을 때 받을 수 있는 최대 자두 개수
        // j번 이동: 짝수면 1번 나무, 홀수면 2번 나무
        dp = new int[T + 1][W + 2];
        fruits = new int[T + 1];

        // 입력 받기
        for (int i = 1; i <= T; i++) {
            fruits[i] = Integer.parseInt(br.readLine());
        }

        // DP 수행
        for (int i = 1; i <= T; i++) {
            for (int j = 0; j <= W; j++) {
                // 현재 위치 계산 (j번 이동했을 때)
                // j가 짝수면 1번 나무, 홀수면 2번 나무
                int currentTree = (j % 2 == 0) ? 1 : 2;

                // 이동하지 않는 경우
                if (fruits[i] == currentTree) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

                // 이동하는 경우 (j > 0일 때만 가능)
                if (j > 0) {
                    if (fruits[i] == currentTree) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                    }
                }
            }
        }

        // 최댓값 찾기
        int answer = 0;
        for (int j = 0; j <= W; j++) {
            answer = Math.max(answer, dp[T][j]);
        }

        System.out.println(answer);
    }
}
