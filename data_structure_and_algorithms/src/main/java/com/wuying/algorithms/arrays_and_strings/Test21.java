package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

/**
 * 删除排序数组中的重复项
 *
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 判题标准:
 *
 * 系统会用下面的代码来测试你的题解:
 *
 */
public class Test21 {
    /**
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2,_]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。
     * 不需要考虑数组中超出新长度后面的元素。
     *
     */
    @Test
    public void test01() {
        int[] nums = {1,1,2,2,3,3,4,4};
        int[] nums1 = {1,1,2};
        System.out.println(removeDuplicates(nums1));
    }

    /**
     * 分析
     * 采用双指针-快慢指针
     * 判断i和i+1位置的元素，若不相等，则令i位置的元素放到j位置，i+1位置的元素放到++j上。
     * i和j都是从0开始
     * 最后输出即可
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[j] = nums[i];
                nums[++j] = nums[i + 1];
            }
            
        }
        return j + 1;
    }
    @Test
    public void test02() {
        int[] nums = {1,1,2,2,3,3,4,4};
        int[] nums1 = {1,1,2};
    }
    public int removeDuplicatesMethod(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
