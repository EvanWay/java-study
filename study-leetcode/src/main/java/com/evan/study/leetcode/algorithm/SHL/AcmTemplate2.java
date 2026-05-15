package com.evan.study.leetcode.algorithm.SHL;

import java.io.*;
import java.util.*;

/**
 * Input:
 * 7
 * 11 5 11 5 11 5 11
 */
public class AcmTemplate2 {
    public static void main(String[] args) throws IOException {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //数量
        int n = Integer.parseInt(br.readLine());

        //第二行整行
        String line = br.readLine();
        //转成int[]
        String[] parts = line.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        System.out.println(Arrays.toString(nums));
    }
}
