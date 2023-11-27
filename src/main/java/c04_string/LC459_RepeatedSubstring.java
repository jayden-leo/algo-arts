package c04_string;

/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 示例 1:
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * link: https://leetcode.cn/problems/repeated-substring-pattern/description/
 */
public class LC459_RepeatedSubstring {
    public boolean repeatedSubstringPattern(String s) {

        return false;
    }

    public static void main(String[] args) {
        String s = "abab";
        LC459_RepeatedSubstring lc459_repeatedSubstring = new LC459_RepeatedSubstring();
        boolean flag = lc459_repeatedSubstring.repeatedSubstringPattern(s);
        System.out.println(flag);
    }
}
