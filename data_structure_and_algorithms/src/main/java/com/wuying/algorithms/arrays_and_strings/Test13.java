package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

/**
 * 两数之和 II - 输入有序数组
 *
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */
public class Test13 {
    /**
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
     *
     */
    @Test
    public void test01() {
        int[] numbers = {1,2,3,4,5,6,7};
        int target = 9;
        System.out.println(twoSum(numbers, target));
    }

    /**
     * 双指针法
     * 头尾相加若比目标值大，则说明尾巴太大，因为头一定是最小的
     * 若相加比目标值小，说明啥，头太小，头向右移动一下，不能移动尾，因为尾移动一次增长的是比头要大得多的
     * 知道头尾相接
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        while (head < tail) {
            int total = numbers[head] + numbers[tail];
            if (total == target) {
                System.out.println(head + " " + tail);
                return new int[] {++head,++tail};
            } else if (total < target) {
                // 说明太小了，需要零头指针右移
                ++head;
            } else {
                // 说明太大了，尾指针左移
                --tail;
            }
        }
        return new int[]{-1,-1};
    }
}
