package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

import java.io.CharArrayReader;

/**
 * KPM算法
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 */
public class Test10 {
    @Test
    public void test01() {
        System.out.println(strStr("adcadcaddcadde", "adcadde"));
    }

    /**
     * 用KMP算法解决
     * 从i = 0; j = 0开始匹配，直到不符合要求，
     * i不变，j = next[j];
     * 构建next[]数组
     * @param haystack 字符串
     * @param needle 目标匹配字符串
     * @return
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) {
            return 0;
        } else if (m > n) {
            return -1;
        }
        // 构建next数组
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }   
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    @Test
    public void test02() {
        System.out.println(strStrMethod("adcadcaddcadde", "adcadde"));
        System.out.println(strStrMethod("adcadde", "adcadcaddcadde"));
    }
    public int strStrMethod(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
