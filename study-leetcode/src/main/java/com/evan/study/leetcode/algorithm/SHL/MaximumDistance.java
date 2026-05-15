package com.evan.study.leetcode.algorithm.SHL;

import java.util.*;

/**
 * 题目:
 * In a city there are N houses. Noddy is looking for a plot of land in the city on which to build his house. He wants to buy the largest plot of land that will allow him to build the largest possible house.
 * All the houses in the city lie in a straight line and all of them have a house number and a second number indicating the position of the house from the entry point in the city.
 * Noddy wants to find the houses between which he can build the largest possible house.
 * Write an algorithm to help Noddy find the house numbers between which he can build the largest possible house.
 *
 * 在一个城市里有 N 栋房子。Noddy 正在城市中寻找一块土地来建造他的房子。他想购买最大的一块土地，这块土地可以让他建造尽可能大的房子。
 * 所有房子都位于一条直线上，并且每栋房子都有一个房屋编号，以及第二个数字，用来表示该房子距离城市入口点的位置。
 * Noddy 想找到两栋房子，在这两栋房子之间他可以建造最大的房子。
 * 请写一个算法，帮助 Noddy 找到这两栋房子的房屋编号。
 *
 * 两个房子最大距离
 * 思路：按房子位置 Pi 排序，然后找相邻房子之间位置差最大的那一对。
 * <p>
 * Input:
 * 3 2
 * 11 4
 * 13 9
 * 12 5
 * Output:
 * 12 13
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
