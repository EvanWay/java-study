package com.evan.study.leetcode.algorithm;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * <p>
 * 示例 1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 * <p>
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 *
 */
public class AddBinary {
    //解法：从最后一位按位相加
    public String addBinary(String a, String b) {
        //进位
        int carry = 0;
        //结果
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += (a.charAt(i) - '0');
                i--;
            }
            if (j >= 0) {
                carry += (b.charAt(j) - '0');
//                carry += Integer.parseInt(String.valueOf(b.charAt(j)));
                j--;
            }
            //取余得到当前位的值
            int result = carry % 2;
            ans.append(result);
            //得到进位
            carry = carry / 2;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
        System.out.println(addBinary.addBinary("1010", "1011"));
    }
}
