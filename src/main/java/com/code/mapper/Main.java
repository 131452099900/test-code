package com.code.mapper;
import java.util.*;




import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // this test commit
        // 读取页数 n 和时间 m
        int n = 4;
        int m = 1;
        long[] a = new long[]{1l,2l,3l,4l};
        long total = 9l;

        // 如果时间不足：m 分钟最少必须达到 ceil(n/2)
        if (m < (n + 1) / 2) {
            System.out.println(-1);
            return;
        }
        // 如果时间充裕（m>=n），全部正常读即可
        if (m >= n) {
            System.out.println(total);
            return;
        }

        // 必须使用能力读的次数 K = n - m
        int K = n - m;

        // dp[i][j] 表示处理完前 i 页、用了 j 次能力读所获得的“损失”（未除以 2）的最小值
        // 注意：i 从 0 到 n, j 从 0 到 K
        long INF = Long.MAX_VALUE / 2;
        long[][] dp = new long[n+1][K+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= K; j++) {
                if (dp[i][j] == INF) continue;
                // 选项 1：正常读第 i 页（下标 i）
                if (i + 1 <= n) {
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
                }
                // 选项 2：如果还有页可以配对，则用能力读把第 i 页与第 i+1 页一起读
                if (i + 1 < n && j + 1 <= K) {
                    dp[i+2][j+1] = Math.min(dp[i+2][j+1], dp[i][j] + a[i] + a[i+1]);
                }
            }
        }

        // 如果dp[n][K]依然为 INF，说明无法在 m 分钟内读完，输出 -1
        if (dp[n][K] == INF) {
            System.out.println(-1);
        } else {
            double ans = total - dp[n][K] / 2.0;
            // 输出结果（与样例保持一致，例中输出 6.0）
            System.out.println(ans);
        }
    }
}

