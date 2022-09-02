package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，
 * 其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，
 * 并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 */
public class Test03 {
    
    @Test
    public void test01() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] myMerge = myMerge(intervals);
        // merge(intervals);
    }
    // 合并前提第一数组当中的末尾一定比其中一个数组的
    public int[][] myMerge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2]; 
        }
        // 排序--按照每个数组的第一位元素排序
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        // 定义一个集合用来存储新的数组
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int begin = intervals[i][0];// 用来获取当前个数组的第一个值
            int end = intervals[i][1];// 用来获取当前数组的第二个值
            if (list.size() == 0 || list.get(list.size() - 1)[1] < begin) {// 说明当前相邻的两个不能合并
                list.add(new int[]{begin,end});
            } else {
                // 说明能合并，进行合并
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], end);
            }
        }
        for (int[] ints: list) {
            System.out.println(ints[0] + "," + ints[1]);
        }
        return list.toArray(new int[list.size()][]);
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        for (int[] ints: merged) {
            System.out.println(ints[0] + "," + ints[1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
