package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 */
public class Test16 {
    /**
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     */
    @Test
    public void test01() {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }

    /**
     * 外层循环决定起始
     * 内层决定尾巴。
     * 0-0,1,2,3...length
     * 1-1,2,3,....length
     * length-1,length
     * length
     * 这样就全部求和都有了。寻找大于等于target即可。
     * 
     *  暴力破解
     * i = 1; j = 0;
     * i = 2; j = 1,
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        // 我先开始写的0；
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans,j - i + 1);
                    break;
                }
            }
        }
        // 先开始直接返回的ans,会报错。
        return ans;
    }
    @Test
    public void test02() {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLenMethod(target, nums));
    }
    public int minSubArrayLenMethod(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= s) {
                // 小的那个才是正解，所以初值不能比正解小，也就是最大喽
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
