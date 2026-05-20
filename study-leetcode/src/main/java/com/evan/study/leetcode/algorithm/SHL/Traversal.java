package com.evan.study.leetcode.algorithm.SHL;

import java.util.*;

/**
 * Write an algorithm to find the number of occurrences of needle in a given positive number haystack.
 * <p>
 * 写一个算法，找出数字 needle 在给定正整数 haystack 中出现的次数。
 *
 * 遍历算法
 * <p>
 * Input:
 * 2
 * 123228
 * Output:
 * 3
 */
public class Traversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int needle = sc.nextInt();
        String haystack = sc.next();

        int count = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // 字符转数字
            int tmp = haystack.charAt(i) - '0';
            if (needle == tmp) {
                count++;
            }
        }
        System.out.println(count);
    }
}
