package com.evan.study.leetcode.algorithm.SHL;

import java.util.*;

/**
 * You are given a list of integers and an integer K.
 * Write an algorithm to find the number of elements in the list that are strictly less than K.
 *
 * 给你一个整数列表和一个整数 K。
 * 写一个算法，找出列表中严格小于 K 的元素个数。
 *
 * 很简单的题 Array Traversal（数组遍历统计）
 *
 * Input:
 * 7
 * 1 7 4 5 6 3 2
 * 5
 * Output:
 * 4
 */
public class ElementsLessThenK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < k) {
                result++;
            }
        }
        System.out.println(result);
    }
}
