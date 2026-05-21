package com.evan.study.leetcode.algorithm.SHL;

import java.util.*;

/**
 * Question:
 * You are given two lists of different lengths of positive integers.
 * Write an algorithm to count the number of elements that are not common to each list.
 *
 * 给你两个长度不同的正整数列表。
 * 写一个算法，统计两个列表中“不共同存在”的元素个数。
 *
 * HashSet相关
 *
 * Input:
 * 11
 * 1 1 2 3 4 5 5 7 6 9 10
 * 10
 * 11 12 13 4 5 6 7 18 19 20
 * Output:
 * 12
 */
public class DifferentInTwoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //读取第一个数组
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            set1.add(arr1[i]);
        }

        //读取第二个数组
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
            set2.add(arr2[i]);
        }

        int count = 0;
        for (int x : arr1) {
            if (!set2.contains(x)) {
                count++;
            }
        }
        for (int x : arr2) {
            if (!set1.contains(x)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
