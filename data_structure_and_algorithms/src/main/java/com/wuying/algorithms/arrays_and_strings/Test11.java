package com.wuying.algorithms.arrays_and_strings;

import org.junit.jupiter.api.Test;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 */
public class Test11 {
    @Test
    public void test01() {
        char[] c = {'h','e','l','l','o'};
        reverveString(c);
    }
    /**
     * 输入：s = ["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     */
    public void reverveString(char[] s) {
        int begin = 0,end = s.length - 1;
        while (begin < end) {
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++;
            end--;
        }
    }
}
