package com.wuying.algorithms.arrays;

import org.junit.jupiter.api.Test;

public class Test05_189 {
    
    @Test
    public void test01() {
        int[] nums = {1,2,3,4,5,6};
        rotateArray(nums, 3);
    }
    
    public void rotateArray(int[] nums, int k) {
        k = k % nums.length;
        reserveArray(nums,0,nums.length - 1);
        reserveArray(nums,0,k - 1);
        reserveArray(nums,k,nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    /**
     反转数组
     */
    public int[] reserveArray(int[] nums,int head, int tail) {
        while(head < tail) {
            int temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            head++;
            tail--;
        }
        return nums;
    }
    
    @Test
    public void test02() {
        
    }

    /**
     * 有额外空间
     * @param nums
     * @param k
     * @return
     */
    public int[] rotateArrayMethod2(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
        return nums;
    }
}
