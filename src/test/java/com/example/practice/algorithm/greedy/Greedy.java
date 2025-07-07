package com.example.practice.algorithm.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 贪心算法：如活动选择问题、每次选择最早结束的活动
 */
public class Greedy {
    public static void main(String[] args) {
//        int[][] events = {{1, 2}, {2, 3}, {3, 4}};
        int[][] events = {{1, 3}, {2, 3}, {3, 4}, {1, 2}};
        int maxEvents = maxEventOptimized(events);
        System.out.println("maxEvents:"+maxEvents);
    }

    /**
     * 最多参加会议数量
     *    时间复杂度：O(nlog n + n*D)
     *    空间复杂度：O(n)
     */
    public static int maxEvents(int[][] events) {
        // O(nlogn)
        Arrays.sort(events, (a, b) -> {
            if(a[1] != b[1]){return a[1] - b[1];}
            return a[0] - b[0];
        });

        Set<Integer> attended = new HashSet<>();
        for(int[] event : events){ // O(n)
            int start = event[0];
            int end = event[1];
            for(int day = start; day <= end; day++){ // O(D)
                if(!attended.contains( day)){
                    attended.add(day); // 空间复杂度 O(D)
                    break;
                }
            }
        }

        return attended.size();
    }


    /**
     * 贪心算法的优化版本：
     *    时间复杂度：O(nlog n + n + n + D) = O(nlog n + D)
     *    空间复杂度：O(n)
     * @param events
     * @return
     */
    private static int maxEventOptimized(int[][] events){
        int res = 0;
        int maxDay = 0;

        // 按开始时间升序排序 O(n log n)
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // 找出最大的结束天数 O(n)
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int eventPtr = 0;
        for (int day = 1; day <= maxDay; day++) {
            while (eventPtr<events.length && events[eventPtr][0]==day){ // O(n)
                minHeap.offer(events[eventPtr][1]); // 空间复杂度 O(n)
                eventPtr++;
            }
            // 移除已经过期的会议
            while (!minHeap.isEmpty() && minHeap.peek() < day) { // O(n)
                minHeap.poll();
            }
            // 参加结束时间最早的会议
            if (!minHeap.isEmpty()) { // 0(D)
                minHeap.poll();
                res++;
            }

        }
        return res;
    }
}
