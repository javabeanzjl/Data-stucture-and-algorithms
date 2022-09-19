package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class Test14 {
    
    @Test
    public void test01() {
              
    }
    /**
     * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     * int len = removeElement(nums, val);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。
     * 例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     *  
     * 双指针，头指针指向0，尾指针指向length - 1;
     * nums[0] 判断是不是val，不是则进行交换，将头尾交换，再判断是不是，不是继续交换length - 2;
     * 知道头尾相连
     */
    public int removeElement(int[] nums, int val) {
        int tail = nums.length - 1;
        // 头先比较，不是则头尾交换
        for (int head = 0; head <= tail; head++) {
            if (nums[head] == val) {
                 swap(nums,head--,tail--);
            }
        }
        return tail + 1;
    }
    public void swap(int[] nums,int head, int tail) {
        int temp = nums[head];
        nums[head] = nums[tail];
        nums[tail] = temp;
    }
    @Test
    public void test02() {
        
    }
    public int removeElementMethod(int[] nums, int val) {
        int length = nums.length;
        int no = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[no] = nums[i];
                no++;
            }
        }
        return no;
    }
}
