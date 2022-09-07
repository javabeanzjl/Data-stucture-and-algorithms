package com.wuying.algorithms.arrays_and_strings;

import com.beust.ah.A;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 */
public class Test05 {
    @Test
    public void test01() {
        int[][] marix1 = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] marix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(marix2);
    }
    public void setZeroes(int [][] marix) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < marix.length; i++) {
            for (int j = 0; j < marix[i].length; j++) {
                if (marix[i][j] == 0) {
                    list.add(new int[] {i,j});
                }
            }
        }
        for (int i = 0; i < marix.length; i++) {
            for (int j = 0; j < marix[i].length; j++) {
                for (int k = 0; k < list.size(); k++) {
                    if (list.get(k)[0] == i || list.get(k)[1] == j) {
                        marix[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < marix.length; i++) {
            for (int j = 0; j < marix[i].length; j++) {
                System.out.print(marix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 效率更高
     */
    @Test
    public void test02() {
        int[][] marix1 = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] marix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroesMethod(marix2);
    }
    public void setZeroesMethod(int [][] marix) {
        int [] x = new int[marix[0].length];
        int [] y = new int[marix.length];
        for (int i = 0; i < marix.length; i++) {
            for (int j = 0; j < marix[i].length; j++) {
                if (marix[i][j] == 0) {
                    x[j] = 1;
                    y[i] = 1;
                }
            }
        }
        for (int i = 0; i < marix.length; i++) {
            for (int j = 0; j < marix[i].length; j++) {
                if (x[j] == 1 || y[i] == 1) {
                    marix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < marix.length; i++) {
            for (int j = 0; j < marix[i].length; j++) {
                System.out.print(marix[i][j]);
            }
            System.out.println();
        }
    }
}
