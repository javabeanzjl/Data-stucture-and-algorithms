package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class Test08 {
    
    
    @Test
    public void test01() {
        String s1 = "baccdb";
        String s2 = "cbbd";
        String s3 = "cbbd";
        String s4 = "aacabdkacaa";
        String s5 = "acabedaca";
        String s6 = "xaabacxcabaaxcabaax";
        System.out.println(longestPalindromeMethod(s2));
    }

    /**
     * 最长回文字符串
     * 中心扩散法
     * 原理：
     * bababc babab是回文串，去掉首位后aba还是，再去掉剩b也是，下标为4
     * 控制i大于0.小于字符串长度,在来个变量left和right都等于i。判断ii位置是不是相等
     * left--和right++之后判断是否相等。left<0之后跳出本次循环。
     * 
     * 
     * @param s
     * @return
     */
    public String longestPalindromeMethod(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int targetLen = Math.max(len1,len2);
            if (targetLen > end - start) {
                // abcbade.
                start = i - (targetLen - 1) / 2;
                end = i + targetLen / 2;
            }
        }
        return s.substring(start,end + 1);
    }
    
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
    
    
    
    
    @Test
    public void test02() {
        String s = "aacabdkacaa";
        String indexStr1 = "a";
        int index = s.lastIndexOf(indexStr1);
        do {
            index = s.lastIndexOf(indexStr1,index - 1);
            System.out.println(index);
        } while (index > 0);
    }

    /**
     * 回文字符串分为两种，一种是奇数型，一种是偶数型。
     * 偶数型直接判断两处索引之间的字符是否全为一个，不是则直接return。
     * 从index1 = 0位置开始查找，找到字符串，在反着查并查出索引index2，
     * 若两个索引相等，则直接return进入下一次循环，index2 = 2和反着查的索引进行比较
     * 若不相等，则查看中间字符长度。若为两个index之差为2则直接return，直接返回subString(index1,index2)
     * 若索引差不为2，则进行判断，index1再+1和index2再-1做比较。满足index1>index2.
     * 
     * 最长，再判断
     * 
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s;
        }
        List<String> list = new ArrayList<>(); 
        // 1、找到重复字符串并记下索引
        for (int index1 = 0; index1 < s.length(); index1++) {
            // 获取当前所引处的字符
            String indexStr1 = s.substring(index1,index1+1);
            // 倒着查找到indexStr1查看其索引index
            int index = s.lastIndexOf(indexStr1);
            int targetBeginIndex = index1;
            int targetEndIndex = s.lastIndexOf(indexStr1);
            if (targetEndIndex - targetBeginIndex == 0) {
                continue;
            }
            
            if (targetEndIndex - targetBeginIndex == 1) {
                String targetBeginStr = s.substring(targetBeginIndex,targetEndIndex);
                String targetEndStr = s.substring(targetEndIndex,targetEndIndex + 1);
                if (targetBeginStr.equals(targetEndStr) == true) {
                    list.add(s.substring(targetBeginIndex,targetEndIndex + 1));
                }
            }
            int x = index1;
            boolean isTrue = false;
            for (int index2 = s.lastIndexOf(indexStr1); index2 >= index1 ; index2--) {
                // +1
                int beginIndex = x + 1;
                // -1
                int endIndex = index2 - 1;
                if (endIndex < 0) {
                    break;
                }
                if (isTrue == true) {
                    x = index1;
                    beginIndex = x + 1;
                    endIndex = index - 1;
                    if (endIndex < 0) {
                        break;
                    }
                }
                // 进入到这里就已经说明两个索引并不相等
                // 如果两个索引值处各自+1和-1处的字符相等。
                // 这时第beginIndex + 1个字符
                String beginStr = s.substring(beginIndex,beginIndex + 1);
                // 
                String endStr = s.substring(endIndex - 1, endIndex);
                if (endIndex >= beginIndex &&  beginStr.equals(endStr)) {
                    isTrue = false;
                    if (endIndex - beginIndex == 0 || endIndex - beginIndex == 1) {
                        // 若两个索引值之差等于0或者1，说明是回文子串
                        String target = s.substring(index1,index + 1);
                        list.add(target);
                        if (target.length() == s.length()) {
                            return target;
                        }
                    }
                    x++;
                } else {
                    // 并不是直接结束
                    index = s.lastIndexOf(indexStr1,index - 1);
                    isTrue = true;
                }
            }
        }
        // 执行到这里说明前面没找到回文字符串，查看倒数第二个字符串和倒数第一个字符串相等。
        /*if ((s.substring(s.length() - 2,s.length() - 1)).equals((s.substring(s.length() - 1,s.length()))) == true) {
            return s.substring(s.length() - 2);
        }*/
        // 找到最长的那一个
        if (list.size() == 0) {
            return "";
        }
        return list.stream().max(Comparator.comparing(String::length)).get();
    }
    
    @Test
    public void test03() {
        String s1 = "baccdb";
        String s2 = "cbbd";
        String s3 = "cbbd";
        String s4 = "aacabdkacaa";
        String s5 = "acabedaca";
        String s6 = "xaabacxcabaaxcabaax";
        System.out.println(lonestPalindromeMethod(s2));
    }

    /**
     * 暴力解法
     * 一个回文字符串并且长度大于2.去掉首位字母后它一定还是回文串
     * 
     * @param s
     * @return
     */
    public String lonestPalindromeMethod(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j]表示s[i...j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        
        // 初始化，所有长度为1的回文串，并使其为true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        
        char[] charArray = s.toCharArray();
        // 地推开始
        // 先枚举长度为2的字符串，依次递增
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                // 由L和i可以确定右边界，即j - i + 1 = L 得
                int j = L + i - 1;// 右边界
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {// 外侧字符相等，若里面是回文字符则当前字符一定是回文字符。
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                
                // dp[i][L] == true 成立，就表示子串ss[i..L]是回文，此时记录长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }
    
}
