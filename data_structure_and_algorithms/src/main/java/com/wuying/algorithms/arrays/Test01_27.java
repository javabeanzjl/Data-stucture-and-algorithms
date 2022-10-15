package com.wuying.algorithms.arrays;

import org.junit.jupiter.api.Test;

public class Test01_27 {

    @Test
    public void test01() {
        int[] nums = {3,2,2,3};
        int target = 3;
        System.out.println(removeElementMethod(nums, target));
        // removeElementMethod(nums, target);
    }
    public int removeElementMethod(int[] nums, int target) {
        int slow = 0, fast = nums.length - 1;
        while(slow <= fast) {
            if (nums[slow] == target) {
                nums[slow] = nums[fast];
                fast--;
            } else {
                slow++;
            }
        }
        return slow;
    }
}
