package com.evan.study.leetcode.algorithm;

/**
 * 44.通配符匹配
 * <p>
 * 给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符序列（包括空字符序列）。
 * 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int startIndex = -1;
        int match = 0;
        int sLen = s.length(), pLen = p.length();
        while (i < sLen) {
            if (j < pLen && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < pLen && p.charAt(j) == '*') {
                startIndex = j;
                match = i;
                j++;
            } else if (startIndex != -1) {
                j = startIndex + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }

        while (j < pLen && p.charAt(j) == '*') {
            j++;
        }
        return j == pLen;
    }

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("aa", "a"));//false
        System.out.println(wildcardMatching.isMatch("aa", "*"));//true
        System.out.println(wildcardMatching.isMatch("cb", "?a"));//false
    }
}
