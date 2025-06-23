package com.example.practice.algorithm.backtrack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapPermutation {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<List<Integer>> result) {
        // 终止条件：所有位置已固定
        if (start == nums.length) {
            // 将当前数组转换为List并存入结果
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        // 从start开始，逐个交换数字
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);      // 选择nums[i]作为当前位置的数字
            backtrack(nums, start + 1, result); // 递归固定下一个位置
            swap(nums, start, i);      // 撤销交换（回溯）
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);
        System.out.println("所有排列（交换法）：");
        for (List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }
}