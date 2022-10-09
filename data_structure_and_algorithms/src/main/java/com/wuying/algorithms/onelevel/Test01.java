package com.wuying.algorithms.onelevel;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * No1.两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，
 * 
 * 并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class Test01 {

    /**
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     */
    @Test
    public void test01() {
        int[] nums = {-3,4,3,90};
        int target = 0;
        int[] ints = twoSum(nums, target);
        for (int num: ints) {
            System.out.print(num + " ");
        }
    }

    /**
     * 采用双指针解法
     * 先对数组进行排序
     * 一个指向head，一个指向tail
     * 比较nums[head] + nums[tail] 之和与target大小
     * 若前者大说明尾巴太大，令tail指针向左移动
     * 若前者小说明头太小，令head指针向右移动
     * 相等时，返回当前head与tail
     * 
     * 有个前提，就是需要数组是有顺序的
     * 那可不可以拷贝一个数组，可以的
     * 成功了，但是耗时严重。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] copyNums = Arrays.copyOf(nums,length);
        Arrays.sort(copyNums);
        int head = 0;
        int tail = length - 1;
        int headNum = 0, tailNum = 0;
        int[] targetNums = new int[2];
        boolean success = false;
        while (head < tail && !success) {
            if (copyNums[head] + copyNums[tail] > target) {
                tail--;
            } else if (copyNums[head] + copyNums[tail] < target) {
                head++;
            } else {
                headNum = copyNums[head];
                tailNum = copyNums[tail];
                success = true;
            }
        }
        for (int i = 0,j = 0; i < nums.length; i++) {
            if (nums[i] == headNum || nums[i] == tailNum) {
                targetNums[j++] = i;
            }
        }
        return targetNums;
    }
    
    @Test
    public void test02() {
        int[] nums = {3,3};
        int target = 6;
        int[] ints = twoSum(nums, target);
        for (int num: ints) {
            System.out.print(num + " ");
        }
    }

    /**
     * 暴力枚举法
     * 枚举数组中的每一个数num，再寻找数组中是否存在target - num就可以了
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumMethod(int[] nums, int target) {
        int length = nums.length;
        int targetNums[] = null;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int remNum = target - num;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] == remNum) {
                    targetNums = new int[]{i, j};
                }
            }
        }
        return targetNums;
    }
    
    @Test
    public void test03() {
        int[] nums = {-3,4,3,90};
        int target = 0;
        int[] ints = twoSumMethod02(nums, target);
        for (int num: ints) {
            System.out.print(num + " ");
        }
    }

    /**
     * 哈希查找
     * 暴力破解虽然简单，但是时间复杂度为O(N2)
     * 哈希查找的时间复杂度为O(1)，所以用哈希查找降低时间复杂度
     * 利用哈希查找一边将nums中的元素存放到map中，通过key=nums[i]。value=i
     * 这种方式一边查找target- nums[i]是否存在于map中，一边遍历nums
     * 若map中存在则此时对应的value和i就是要找的两个值。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumMethod02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

