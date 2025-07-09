package com.example.practice.algorithm.dynamic;

import java.util.Arrays;

public class DynamicProgram {

    /**
     * 题目：
     * 给定一个会议数组 events，其中每个会议表示为 [startDayi, endDayi, valuei]，
     * 表示会议 i 从 startDayi 开始到 endDayi 结束，参加该会议可以获得价值 valuei。
     * 你最多可以参加 k 个会议，且同一时间只能参加一个会议。要求计算可以获得的最大价值总和。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] events = {{1, 2, 4}, {3, 4, 3}, {2, 3, 1}, {5, 6, 5}};
        int maxValue = maxValue(events, 2);
        System.out.println("maxValue = " + maxValue);
    }


    /**
     * 动态规划解法，重点在于 构建dp[][]数组 =》 行数是会议总数 events.length（也可以+1） ，列数是（条件要求的）最多参加几个会议 k（也可以+1）
     *  算法过程：dp[][]一行行i 循环 一个个会议追加判断；一列列j 循环 参加j个会议； 值汇总最大价值（即每个值是局部最优解）
     * @param events 一维数组（一组会议），每个元素是个1*3的数组（表示一个的开始时间/结束时间/价值）
     * @param k 最多参加几个会议
     * @return 所有会议的总价值（符合以上要求的）
     */
    private static int maxValue(int[][] events, int k) {
        int m = events.length;
        if (m == 0) return 0;

        // 按结束日升序排序
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        // 预处理prev数组：prev[i]表示第i个会议前最后一个不冲突的会议索引
        int[] prev = new int[m];
        for (int i = 0; i < m; i++) {
            int startDay = events[i][0];
            int low = 0, high = i - 1;
            int p = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (events[mid][1] < startDay) {
                    p = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            prev[i] = p;
        }

        // 初始化DP表：dp[i][j]表示前i个会议选j个的最大价值
        int[][] dp = new int[m + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        dp[0][0] = 0;

        // 填充DP表
        for (int i = 1; i <= m; i++) {
            int[] currentEvent = events[i - 1];
            int currentValue = currentEvent[2];
            int p = prev[i - 1];

            for (int j = 0; j <= k; j++) {
                // 不选当前会议
                dp[i][j] = dp[i - 1][j];

                // 选当前会议（需j >= 1且前一个状态可达）
                if (j >= 1 && dp[p + 1][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[p + 1][j - 1] + currentValue);
                }
            }
        }

        // 计算结果：从选1到k个会议的最大价值
        int max = 0;
        for (int j = 1; j <= k; j++) {
            max = Math.max(max, dp[m][j]);
        }
        return max;
    }

}
