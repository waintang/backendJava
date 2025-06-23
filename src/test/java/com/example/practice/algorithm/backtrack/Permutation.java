package com.example.practice.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法 之 全排列（其他回溯法：全排列、组合问题、棋盘类八皇后/数独、子集的生成）
 *
 * 优化方法：交换法优化时间复杂度、流式输出优化空间复杂度
 *
 * 大规模数据问题：应当优先考虑 动态规划（或剪枝策略）、贪心算法、启发式
 * 算法 复杂度排序：O(1) < O(logn) < O(n) < O(nlogn) < O(n^2) < O(n^3) < O(2^n) < O(n!)
 */
public class Permutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; // 输入规模为 n=3，排列数为 3! = 6
        List<List<Integer>> permutations = generatePermutations(nums);
        System.out.println("All permutations:");
        for (List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }

    /**
     * 生成所有排列（阶乘复杂度 O(n!)）
     */
    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    /**
     * 回溯算法
     *  （每步的共性：
     *      N位 按顺序选择一个不重复的数、
     *      按序放入缓存、
     *      循环选下一个数、
     *      撤回第N位当前数
     *
     *    退山条件：目标排列长度 = 输入数组长度、则存入结果集、退出循环
     *      ）
     * @param nums
     * @param current
     * @param result
     */
    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        // 终止条件：当前排列长度等于输入数组长度
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // 添加一个完整排列
            return;
        }

        // 遍历所有可能的选项
        for (int num : nums) {
            if (current.contains(num)) continue; // 跳过已使用的数字
            current.add(num);                   // 选择当前数字
            backtrack(nums, current, result);   // 递归生成剩余排列
            current.remove(current.size() - 1); // 撤销选择（回溯）
        }
    }
}
