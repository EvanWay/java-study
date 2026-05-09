package com.evan.study.leetcode.algorithm.SHL;


import java.util.*;

/**
 * 一家公司正在以安全的方式将一条包含 N 个正整数 的消息传输到新服务器。
 * 他们采用如下传输方式：每次从消息中选取 两个相同的整数作为一对 并发送。
 * 该过程会一直进行，直到无法再组成新的整数对为止。
 *
 * 最后需要输出：
 * 已成功传输的整数对数量
 * 以及未能配对、剩余的整数数量
 *
 * 请编写一个算法来计算上述两个值。
 *
 * Input:
 * 8
 * 12 10 6 12 10 12 1 21
 * <p>
 * Output:
 * 2 4
 */
public class SHLTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int pair = 0;
        int remaining = 0;

        for (Integer count : map.values()) {
            pair += (count / 2);
            remaining += (count % 2);
        }

        System.out.println(pair + " " + remaining);
    }
}
