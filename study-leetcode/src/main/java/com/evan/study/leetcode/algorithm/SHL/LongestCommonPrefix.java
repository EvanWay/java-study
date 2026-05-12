package com.evan.study.leetcode.algorithm.SHL;

import java.util.*;

/**
 * Input:
 * 3
 * bangaloreRam
 * bangaloreSam
 * bangaloreTom
 * <p>
 * Output:
 * bangalore
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] peopleNames = new String[n];
        for (int i = 0; i < n; i++) {
            peopleNames[i] = sc.next();
        }

        String townName = getTown(peopleNames);
        System.out.println(townName);
    }

    public static String getTown(String[] peopleNames) {

        if (peopleNames == null || peopleNames.length == 0) {
            return "";
        }
        //全部转小写
        for (int i = 0; i < peopleNames.length; i++) {
            peopleNames[i] = peopleNames[i].toLowerCase();
        }
        //拿第一个字符串作为公共前缀
        String prefix = peopleNames[0];

        for (int i = 1; i < peopleNames.length; i++) {
            while (!peopleNames[i].startsWith(prefix)) {
                //不断缩短，每次删掉最后一个字符
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
