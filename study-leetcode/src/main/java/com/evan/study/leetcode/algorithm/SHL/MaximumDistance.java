package com.evan.study.leetcode.algorithm.SHL;

import java.util.*;

/**
 * 两个房子最大距离
 * 思路：按房子位置 Pi 排序，然后找相邻房子之间位置差最大的那一对。
 * <p>
 * Input:
 * 3 2
 * 1 4
 * 3 9
 * 2 5
 * Output:
 * 2 3
 */
public class MaximumDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int val = sc.nextInt();//固定2，没什么用

        int[][] houses = new int[num][2];
        for (int i = 0; i < num; i++) {
            houses[i][0] = sc.nextInt();
            houses[i][1] = sc.nextInt();
        }
        //会按第1列排序，然后升序排序
        //记得：返回 < 0 → 第一个参数在前
        Arrays.sort(houses, (a, b) -> a[1] - b[1]);

        int maxGap = -1;
        int house1 = 0;
        int house2 = 0;

        for (int i = 1; i < num; i++) {
            int gap = houses[i][1] - houses[i - 1][1];
            if (gap > maxGap) {
                maxGap = gap;
                house1 = houses[i - 1][0];
                house2 = houses[i][0];
            }
        }

        if (house1 < house2) {
            System.out.println(house1 + " " + house2);
        } else {
            System.out.println(house2 + " " + house1);
        }
    }
}
