package com.wuying.algorithms.arrays;

import org.junit.jupiter.api.Test;

public class Test03_80 {
    
    @Test
    public void test01() {
        int[] nums = {1,1,1,2,2,3};
        removeRepeatTwoElements(nums);
    }
    public int removeRepeatTwoElements(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 2;
        for (int slow = 2; slow < nums.length; slow++) {
            if (nums[slow] != nums[count - 2]) {
                nums[count++] = nums[slow];
            }
        }
        return count;
    }
}
