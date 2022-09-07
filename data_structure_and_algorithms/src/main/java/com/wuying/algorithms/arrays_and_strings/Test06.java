package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * 
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 
 * [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 0,0
 * 0,1 1,0
 * 2,0 1,1 0,2
 * 1,2 2,1
 * 2,2
 * 和为i
 * i为奇数时，i正向遍历，j反向
 * i为偶数时，i反向遍历，j正向
 */
public class Test06 {
    @Test
    public void test01() {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] diagonalOrder = findDiagonalOrder(mat);
        /*for (int i = 0; i < diagonalOrder.length; i++) {
            System.out.print(diagonalOrder[i] + " ");
        }*/
    }

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) return new int[0];
        int n = mat.length, m = mat[0].length;
        int[] res = new int[n * m];
        for (int i = 0, idx = 0; i < n + m - 1; i++) {// 第几条对角线 
            if (i % 2 == 0) //偶数对角线
                for (int x = Math.min(i, n - 1); x >= Math.max(0, i - m + 1); x--) //从下往上遍历
                    res[idx++] = mat[x][i - x];
            else            //奇数对角线
                for (int x = Math.max(0, i - m + 1); x <= Math.min(i, n - 1); x++)//从上往下遍历
                    res[idx++] = mat[x][i - x];
        }
        return res;
    }

    public int[] findDiagonalOrderMethod(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int pos = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 1) {
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    res[pos] = mat[x][y];
                    pos++;
                    x++;
                    y--;
                }
            } else {
                int x = i < m ? i : m - 1;  
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    res[pos] = mat[x][y];
                    pos++;
                    x--;
                    y++;
                }
            }
        }
        return res;
    }
}
