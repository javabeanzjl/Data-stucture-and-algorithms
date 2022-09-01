package com.wuying.algorithms.arrays_and_strings;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 寻找数组的中心下标
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 *
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 
 */
public class Test01 {
    @Test
    public void test01() {
        int[] nums1 = {1,7,3,6,5,6};
        int[] nums2 = {1,2,3};
        int[] nums3 = {2,1,-1,5,-5};
        int[] nums4 = {1,-1,5};
        int[] nums5 = {1,-1,0,1,1,0};
        int[] nums6 = {-1,-1,0,0,1,1};
        int[] nums7 = {-1, -1, 1, 1, 0, 0};
        System.out.println(pivotIndex(nums7));
        System.out.println(arraysCenterIndex(nums7));
    }
    // nums = [1, 7, 3, 6, 5, 6] sum = 28
    public int arraysCenterIndex(int[] arr) {
        // 先求和计算出数组中元素之和
        int sums = Arrays.stream(arr).sum();
        int totalLeft = 0;// 用来表示数组中心下标左侧的数值(包含当前下标)
        int totalRight = 0;
        for (int i = 0; i < arr.length; i++) {
            totalRight = sums - totalLeft - arr[i];// 右侧元素之和
            if (totalLeft == totalRight) {// 左侧等于右侧
                return i;
            }
            totalLeft += arr[i];// 左侧元素之和
        }
        return -1;
    }

    /**
     * 数据量大的时候++i的性能比i++要高。但java中jvm进行了优化，如果没有赋值操作，会被优化成一种方式。效率就是一样的。
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
