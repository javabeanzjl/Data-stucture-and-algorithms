package com.wuying.algorithms.arrays_and_strings;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 
 */
public class Test02 {
    @Test
    public void test01() {
        int [] arr = {1, 3, 7, 9};
        System.out.println(searchTarget(arr, 8));
        System.out.println("--------------------");
    }
    

    /**
     * 
     * @param arr
     * @return 目标索引
     */
    public static int searchTarget(int[] arr, int target) {
        int begin = 0;// 开始下标
        int end = arr.length - 1;// 结尾下标
        int dns = arr.length;
        while (begin <= end) {
            int mid = (end + begin) / 2;// 中间下标
            if (arr[mid] >= target) {// 说明在左边
                dns = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {// 说明在右边
                begin = mid + 1;
            }
        }
        return dns;
    }
}
