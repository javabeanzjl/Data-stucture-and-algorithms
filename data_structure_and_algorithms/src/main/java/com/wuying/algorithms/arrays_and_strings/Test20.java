package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

/**
 * 寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 
 *     若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 *     若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 */
public class Test20 {
    /**
     * 输入：nums = [3,4,5,1,2]
     * 输出：1
     * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
     */
    @Test
    public void test01() {
        int[] nums = {5,6,7,8,9,1,2,3,4};
        int[] nums1 = {1,2};
        System.out.println(findMin(nums1));
    }

    /**
     * 首先旋转排序数组是指排序数组经过几次旋转之后得到的数组
     * 旋转几次指的是将数组中的元素向后移动几次
     * 123456移动2次就变成了561234
     * 分析
     * 所以寻找数组中最小值且时间复杂度为O(log n)，用二分法才行
     * 先找到数组中的中间位置的元素的值，和尾部元素进行比较
     * 若比尾部元素大，说明啥，说明最小值一定在中间靠右的位置。
     * 若比尾部元素小，说明啥，说明最小值一定在中间及靠左的位置。
     * 不存在和尾部元素相等的情况，因为是互不相同的数组
     * 这样循环几次之后在head<tail不成立时，head就是要得到的值
     * 最后一定能得到最小值的索引
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int head = 0,mid = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            mid = head + (tail - head) / 2;
            if (nums[mid] > nums[tail]) {
                head = mid + 1;
            } else {
                tail = mid;
            }
        }
        return nums[head];
    }
}
