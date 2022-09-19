package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 */
public class Test17 {
    /**
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     */
    @Test
    public void test01() {
        int numRows = 0;
        generate(numRows);
    }
    /**
     * 思考过程：
     * 
     * i控制行数和数组中元素个数，从1开始，依次递增
     * List<int[] > list = new ArrayList<>();
     * for i = 3循环开始
     * list.add(new int[i]);
     * for循环，j= 1 < i - 1; j++;// 控制第几个元素的
     * list.get(i - 1)[0] = 1;
     * list.get(i - 1)[i] = 1;
     * list.get(i - 1)[j] = list.get(i - 2)[j-1] + list.get(i - 2)[j];
     * int[] num = new int[numRows];
     * target[0] = i;
     * num[i] = 
     * target[target.length];
     *
     * list.add();
     *
     * 0,1由0和1组成,2
     * 0,1由0和1组成，2由1和2组成。
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> innerList = new ArrayList<>(i);
            if (i < 3) {
                for (int j = 0; j < i; j++) {
                    innerList.add(j,1);
                }
                list.add(innerList);
            } else {
                innerList.add(0,1);
                for (int j = 1; j < i - 1; j++) {// 计算非首尾处的元素的值并填入内集合。
                    int lastHead = list.get(i - 2).get(j - 1);
                    int lastTail = list.get(i - 2).get((j));
                    innerList.add(j,lastHead + lastTail);
                }
                innerList.add(i - 1,1);
                list.add(innerList);
            }    
        }
        return list;
    }
    @Test
    public void test02() {
        List<Integer> list = new ArrayList<>(3);
        list.add(2,1);
    }
}
