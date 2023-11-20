package c03_hashtable;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * link: https://leetcode.cn/problems/valid-anagram/description/
 */
public class LC242_Allophone {
    public boolean isAnagram(String s, String t) {
        int[] letterCount = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (char sChar : sChars) {
            letterCount[sChar - 'a'] += 1;
        }
        for (char tChar : tChars) {
            letterCount[tChar - 'a'] -= 1;
        }
        for (int i : letterCount) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "anagram";
        String b = "nagaram";
        LC242_Allophone lc01_allophone = new LC242_Allophone();
        boolean result = lc01_allophone.isAnagram(a, b);
        System.out.println(result);
    }
}
