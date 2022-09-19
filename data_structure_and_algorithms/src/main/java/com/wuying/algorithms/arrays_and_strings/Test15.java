package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 */
public class Test15 {
    /**
     * 输入：nums = [1,1,0,1,1,1]
     * 输出：3
     * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
     */
    @Test
    public void test01() {
        int[] nums = {1,1,0,1,1,1};
        int[] nums2 = {0};
        System.out.println(findMaxConsecutiveOnes(nums2));
    }

    /**
     * slow = 0;时，判断是不是1，若是则++；再判断
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int j = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                j++;
            } else {
                maxLength = Math.max(j,maxLength);
                j = 0;
            }
        }
        return Math.max(j,maxLength);
    }
}
