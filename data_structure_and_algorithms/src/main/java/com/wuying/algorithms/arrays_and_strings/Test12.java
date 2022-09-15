package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从 1 到 n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 *
 */
public class Test12 {
    /**
     * 输入：nums = [1,4,3,2]
     *      * 输出：4
     *      * 解释：所有可能的分法（忽略元素顺序）为：
     *      * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
     *      * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
     *      * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
     *      * 所以最大总和为 4
     */
    @Test
    public void test01() {
        
    }

    /**
     *
     * 总共2n个，取n个，还得和最大，还得是两个数中的最小值的和
     * a1,a2,a3,...an,...a2n-1,a2n-2--从小到大，依次递增
     * 由于a1和谁凑在一起都是最小会被选中，所以与第二小的a2凑在一起
     * min(a1,a2) + min(a3,a4) + ...min(2n-1, 2n)
     * 1,3,5,7,9...
     * 那这杨选择2,4,6,8,10...这样岂不是更好？
     * 验证一下
     * 假设2,4,6,8,10这样更大，
     * 即min(a2,a3) + min(a4,a5) + ... + min(a2n-2,a2n-1) + 这样a2n只能和a1凑在一起了
     * 我们来比较一下再这样的结果是
     * a1 + a2 + a4 + a6 + ... + a2n-2，原先的结果是
     * a1 + a3 + a5 + a7 + ....+ a2n-1.发现a3 > a2，a5 > a4...
     * 发现不是最大，所以假设失败。
     * 
     * 
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];       
            }
        }
        return sum;
    }
    
    public int arrayPairSumMethod(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum +=nums[i];
        }
        return sum;
    }
}
