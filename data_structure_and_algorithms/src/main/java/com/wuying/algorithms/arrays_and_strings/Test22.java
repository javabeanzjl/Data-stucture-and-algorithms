package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

/**
 * 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 */
public class Test22 {
    /**
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     */
    @Test
    public void test01() {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

    /**
     * 分析
     * 快慢指针
     * 如果不等于0，则令i赋值给j
     * 最后根据j确定0的个数，将后面几位赋值成0即可
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int slow = 0;
        int fast = 0;
        int zeroNum = 0;
        int head = 0;
        int tail = nums.length - 1;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            } else {
                zeroNum++;
            }
            fast++;
        }
        head = tail - zeroNum;
        while (head < tail) {
            nums[tail--] = 0;
        }
        for (int n: nums) {
            System.out.println(n);
        }
    }
    
    @Test
    public void test02() {
        int[] nums = {0,1,0,3,12};
    }

    /**
     * 采用快排思想
     * 快排思想是比x的小的放左边，比x大的放右边
     * 这里x取0，不等于0的元素放到左边，等于0的放到右边
     * @param nums
     */
    public void moveZerosMethod(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}
