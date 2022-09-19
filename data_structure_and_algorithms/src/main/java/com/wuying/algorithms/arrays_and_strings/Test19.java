package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

/**
 * 反转字符串中的单词 III
 *
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class Test19 {
    /**
     * 输入：s = "Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     */
    @Test
    public void test01() {
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords(str));
    }

    /**
     * 分析
     * 获取每个单词的Char数组，之后进行首位交换。
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        // 创建可变字符串
        StringBuilder stringBuilder = new StringBuilder();
        // 按照空格分组
        String[] strs = s.split(" ");
        int length = strs.length;
        for (int i = 0,j = 0; i < length; i++) {
            // 将每组字符去掉前后空格并转换成char数组
            char[] chars = strs[i].trim().toCharArray();
            // 交换每组数组中的数
            swap(chars);
            // 将交换完的char数组填充到可变字符中
            stringBuilder.append(chars);
            // 没交换一个数组添加空格
            if (++j < length) {
                stringBuilder.append(" ");    
            }
        }
        return stringBuilder.toString();
    }
    public void swap(char[] chars) {
        int begin = 0;
        int end = chars.length - 1;
        while (begin < end) {
            char stemp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = stemp;
            begin++;
            end--;
        }
    }

    /**
     * 官方答案
     */
    @Test
    public void test02() {
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWordsMethod(str));
    }

    public String reverseWordsMethod(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
