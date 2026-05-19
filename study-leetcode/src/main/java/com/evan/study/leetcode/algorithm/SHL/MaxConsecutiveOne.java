package com.evan.study.leetcode.algorithm.SHL;

import java.util.*;

/**
 * Max Consecutive Ones III
 * 滑动窗口
 *
 * Input:
 * 1101001
 * 2
 * Output:
 * 5
 */
public class MaxConsecutiveOne {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int k = sc.nextInt();

        int left = 0;
        int zeroCount = 0;

        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            // 遇到0
            if (s.charAt(right) == '0') {
                zeroCount++;
            }

            // 如果0超过k个
            // 缩小窗口
            while (zeroCount > k) {

                if (s.charAt(left) == '0') {
                    zeroCount--;
                }

                left++;
            }

            // 更新最大长度
            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
