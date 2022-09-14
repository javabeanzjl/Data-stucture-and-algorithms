package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 */
public class Test09 {
    @Test
    public void test01() {
        String s = "this is my lover";
        String s1 = " hello world ";
        String s2 = "a good   example";
        System.out.println(reverseWords(s2));
    }

    /**
     * 反转字符串
     * 先按照空格进行分组
     * 交换字符串。
     * 拼接字符串 
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        String[] strs = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int begin = 0;
        int end = strs.length - 1;
        do {
            String temp = strs[begin];
            strs[begin] = strs[end];
            strs[end] = temp;
            begin++;
            end--;
        } while (begin < end);
        int i = 0;
        for (String str: strs) {
            if (str.length() != 0) {
                stringBuilder.append(str.trim());
                if (++i <= strs.length - 1) {
                    stringBuilder.append(" ");
                }    
            }
        }

        return stringBuilder.toString().trim();
    }
}
