package com.evan.study.leetcode.algorithm.SHL;

import java.util.*;

/**
 * In an online word recognition game for kids, the user needs to find the number of times the given word occurs in the sentence.
 * Both the given word and the sentence displayed on the user interface consist of letters from the English alphabet only and are case insensitive (i.e., "toddler" is same as "Toddler").
 * Neither the word nor the sentence contain any white-spaces or special symbols.
 * Write an algorithm to print the number of times the given word appears in the sentence.
 *
 * Note
 * Overlapping instances of the word may appear in the sentence.
 * 单词的匹配可能会发生重叠
 *
 * Input:
 * TodisplayinginthehouseofTodwiththeTod
 * Tod
 * Output:
 * 4（题目错的，应该只有3）
 *
 *
 * 这道题和CountSubStrInParentStr不同的是可以允许重叠
 * sentence = aaaa
 * word = aa
 * 输出是3
 */
public class CountSubStrInParentStr2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.next().toLowerCase();
        String word = sc.next().toLowerCase();

        int count = 0;

        int index = sentence.indexOf(word);

        while (index != -1) {
            count++;

            // 允许重叠匹配
            index = sentence.indexOf(word, index + 1);
        }

        System.out.println(count);
    }
}
