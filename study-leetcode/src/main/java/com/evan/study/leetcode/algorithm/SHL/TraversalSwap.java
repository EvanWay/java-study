package com.evan.study.leetcode.algorithm.SHL;

import java.util.*;

/**
 * You are given a list of N unique positive numbers ranging from 0 to (N - 1).
 * Write an algorithm to replace the value of each number with its corresponding index value in the list.
 *
 * Explanation:
 * Before the change:
 * arr[0]=3 arr[1]=2 arr[2]=0 arr[3]=1
 * After the change:
 * arr[0]=2 arr[1]=3 arr[2]=1 arr[3]=0
 *
 * 给定一个包含 N 个互不相同的正整数的列表，这些数字的范围是 0 到 (N - 1)。
 * 写一个算法，把每个数字替换成它在列表中的对应下标值。
 *
 *
 * Input:
 * 4
 * 3 2 0 1
 * Output:
 * 2 3 1 0
 *
 */
public class TraversalSwap {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //遍历交换
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[arr[i]] = i;
        }

        //输出
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }
}
