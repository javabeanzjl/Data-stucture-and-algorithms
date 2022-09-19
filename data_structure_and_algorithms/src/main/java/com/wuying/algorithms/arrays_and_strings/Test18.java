package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角第二弹
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 */
public class Test18 {
    /**
     * 输入: rowIndex = 3
     * 输出: [1,3,3,1]
     */
    @Test
    public void test01() {
        int rowIndex = 3;
        getRow(rowIndex);
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i <= rowIndex ; i++) {
            result.add(0);
            for (int j = i; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}
