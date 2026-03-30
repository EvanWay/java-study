package com.evan.study.leetcode.algorithm.SHL;

import java.util.Scanner;

/**
 * 计算第二个字符串在第一个字符串中出现的次数
 * You are given two strings containing only
 * English letters. Write an algorithm to count the
 * number of occurrences of the second string in
 * the first string. (You may disregard the case of
 * the letters.)
 * <p>
 * Input
 * The first line of the input consists of a string parent, representing the first string.
 * The second line consists of a string sub, representing the second string.
 * <p>
 * Output
 * Print an integer representing the number of occurrences of Sub in Parent.
 * If no occurrence of Sub is found in Parent then print 0.
 *
 * 这道题类似于LeetCode No.28 implement strStr()
 */
public class CountSubStrInParentStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String parent = scanner.nextLine();
        String sub = scanner.nextLine();
        scanner.close();

        parent = parent.toLowerCase();
        sub = sub.toLowerCase();

        int count = 0;
        int index = 0;

        while ((index = parent.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }

        System.out.println(count);
    }
}
