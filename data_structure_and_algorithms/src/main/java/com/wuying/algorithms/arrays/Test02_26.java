package com.wuying.algorithms.arrays;

public class Test02_26 {
    
    public void test01() {
        
    }
    public int deleteRepeatElements(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 1;
        for (int slow = 0; slow < nums.length; slow++) {
            if (nums[slow - 1] != nums[slow]) nums[count] = nums[slow];
        }
        return count;
    }
}
