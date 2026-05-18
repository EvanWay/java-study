package com.evan.study.leetcode.algorithm.SHL;

import java.util.Scanner;

/**
 * 岛屿的最大面积
 * The city authorities conduct a study of the houses in a residential area for a city planning scheme.
 * The area is depicted in an aerial view and divided into an N x M grid.
 * If a grid cell contains some part of a house roof, then it is assigned the value 1; otherwise, the cell represents a vacant plot and is assigned the value 0.
 * Clusters of adjacent grid cells with value 1 represent a single house.
 * Diagonally placed grids with value 1 do not represent a single house.
 * The area of a house is the number of 1s that it spans.
 *
 * Write an algorithm to find the area of the largest house.
 *
 * 这道题就是LeetCode No.695 岛屿的最大面积 Max Area of Island
 *
 * Input:
 * 5 5
 * 0 0 0 0 0
 * 0 1 1 0 0
 * 0 0 0 0 0
 * 0 0 1 1 0
 * 0 0 1 0 0
 * Output:
 * 3
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r =  sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    result = Math.max(result, dfs(grid, row, col));
                }
            }
        }
        System.out.println(result);
    }

    public static int dfs(int[][] grid, int r, int c) {
        if (!isGrid(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] == 0) {
            return 0;
        }
        if (grid[r][c] == 2) {
            return 0;
        }
        grid[r][c] = 2;
        return 1
                + dfs(grid, r + 1, c)
                + dfs(grid, r - 1, c)
                + dfs(grid, r, c + 1)
                + dfs(grid, r, c - 1);
    }

    public static boolean isGrid(int[][] grid, int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }
}
