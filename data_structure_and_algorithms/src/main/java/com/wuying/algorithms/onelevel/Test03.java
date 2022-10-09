package com.wuying.algorithms.onelevel;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Test03 {

    /**
     * 输入: s = "abcabcbb"
     * 输出: 3 
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    @Test
    public void test01() {
        String s = "ababcbb";
        lengthOfLongestSubstring(s);
    }

    /**
     * 用HashSet，因为不能存放相同元素
     * 遍历每一个字符串。map中不包含要存放的元素，则add里面
     * 相同时，返回此时字符串的长度
     * 之后，令map中的首位元素remove。字符串接着查找是否重复。并计算长度。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int length = s.length();
        int rk = -1, maxLen = 0;// 右指针，初始值为-1。相当于字符串的左边界的左侧。还没有开始移动。
        for (int i = 0; i < length; ++i) {
            if (i != 0) {
                // 执行这块代码块时，肯定是碰见重复元素了。
                // 左指针向右移动一个
                // set中移除刚才重复的元素
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < length && !set.contains(s.charAt(rk + 1))) {
                // 说明map中包含重复元速了。不断向右移动指针
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            // 说明重复了，此时计算最大长度i到rk。
            maxLen = Math.max(maxLen, rk - i + 1);
        }
        return maxLen;
    }
    
    @Test
    public void test02() {
        String s = "pwwkew";
        lengthOfLongestSubstringMethod(s);
    }

    /**
     * 用Map求解--滑动窗口
     * 定义一个map存储key和value，其中key值为字符，value为字符位置+1.加1表示从加1位置才开始不重复
     * 定义字符串开始位置为start，结束位置为end
     * 不断向map中添加元素。若相同则更新start和end
     * 不相同则计算maxLength
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringMethod(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length(), maxLength = 0;
        for (int end = 0, start = 0; end < length; ++end) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                // 说明重复了。那就改变一下start。取相同元素时的最大的value
                start = Math.max(map.get(alpha), start);
            }
            // end - start + 1
            maxLength = Math.max(maxLength, end - start + 1);
            // 逐个往里面加入元素。
            map.put(s.charAt(end), end + 1);
        }
        return maxLength;
    }
}
