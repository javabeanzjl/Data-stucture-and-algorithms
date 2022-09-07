package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 */
public class Test07 {
    
    @Test
    public void test01() {
        String[] strs = {"flower","flow","flight"};
        String beginStr = strs[0].substring(0,1);
    }

    /**
     * 横向扫描---先比较两个字符串的公共前缀，再跟第三个字符串比较
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix,strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    /**
     * 寻找公共字符串
     * @param str1
     * @param str2
     * @return
     */
    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 纵向比较--一个一个比
     */
    @Test
    public void test02() {
        String[] strs = {"flower","flow","flight"};
    }
    public String longestCommonPrefixMethod(String[] strs) {
        if (strs == null || strs[0].length() == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            // 获取第0个元素的首字母
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                // strs[j].length()是什么？是当前字符串的长度。
                // 若长度和i相等，说明啥？说明不是第0个元素比到头了，就是正在比较的字符串比到头了。
                // 那就没必要继续往下比了。输出呗
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        // 说明啥，说明第0个元素就是最长公共前缀。
        return strs[0];
    }
    
    @Test
    public void test03() {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefixMethodTwo(strs));
    }
    /**
     * 二分查找法--先找到最短字符串，通过找到中间字符串mid。比较mid左侧字符是否均在其他字符串之中
     * 若在里面，则说明最长公共前缀在mid右边，否则在左边
     */
    public String longestCommonPrefixMethodTwo(String[] strs) {
        if (strs == null || strs[0].length() == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str: strs) {
            // 找打最短字符串
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;// 说明在右侧
            } else {
                // 说明在左侧。
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    /**
     * 
     * @param strs 字符串数组
     * @param length 中间值
     * @return true表示0,length的字符串都是公共前缀。
     */
    public boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
