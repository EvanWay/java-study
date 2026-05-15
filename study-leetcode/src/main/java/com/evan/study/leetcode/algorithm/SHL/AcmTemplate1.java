package com.evan.study.leetcode.algorithm.SHL;

import java.util.*;

/**
 * Input:
 * 7
 * 11 5 11 5 11 5 11
 */
public class AcmTemplate1 {
    public static void main(String[] args) {

        //Scanner
        Scanner sc = new Scanner(System.in);

        //数量
        int n = sc.nextInt();

        //n个数据
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(nums));
    }
}
