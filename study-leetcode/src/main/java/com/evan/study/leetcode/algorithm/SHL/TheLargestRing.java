package com.evan.study.leetcode.algorithm.SHL;

import java.util.*;

/**
 * Question
 * A University has invited N alumni to a dinner. The dinner table is circular in shape. The university has assigned each alumnus an invitation ID from 1 to N.
 * Each alumnus likes exactly one fellow alumnus and will attend the dinner only if he/she can be seated next to that person.
 * You are asked to plan the seating arrangement. Write an algorithm to find the maximum number of alumni who will attend the dinner.
 * <p>
 * 一所大学邀请了 N 位校友参加晚宴。
 * 晚宴的餐桌是圆形的。
 * 大学给每位校友分配了一个从 1 到 N 的邀请 ID。
 * 每位校友都恰好喜欢一位其他校友，并且只有当他/她能坐在那个人旁边时，才会参加晚宴。
 * 现在要求你安排座位。
 * 请写一个算法，找出最多有多少位校友可以参加晚宴。
 * <p>
 * Input:
 * 4
 * 2 3 4 1
 * Output:
 * 4
 *
 */
public class TheLargestRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] like = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            like[i] = sc.nextInt();
        }

        boolean[] globalVisited = new boolean[n + 1];

        int maxCycle = 0;

        for (int i = 1; i <= n; i++) {
            if (!globalVisited[i]) {
                Map<Integer, Integer> map = new HashMap<>();

                int cur = i;
                int step = 0;

                while (!globalVisited[cur]) {
                    globalVisited[cur] = true;
                    map.put(cur, step);
                    step++;

                    cur = like[cur];
                }

                if (map.containsKey(cur)) {
                    int cycleLen = step - map.get(cur);
                    maxCycle = Math.max(maxCycle, cycleLen);
                }
            }
        }

        System.out.println(maxCycle);
    }
}
