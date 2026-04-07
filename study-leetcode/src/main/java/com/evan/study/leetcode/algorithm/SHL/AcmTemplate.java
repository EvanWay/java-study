package com.evan.study.leetcode.algorithm.SHL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class AcmTemplate {
    public static void main(String[] args) throws IOException  {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();
        System.out.println("Hello" + name1);

        //Scanner
        Scanner sc = new Scanner(System.in);
        String name2 = sc.nextLine();
        System.out.println();
        System.out.println("Hello" + name2);

//        //template
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        System.out.println(Arrays.toString(nums));
    }
}
