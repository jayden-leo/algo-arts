package c03_hashtable;

import java.util.HashMap;
import java.util.Set;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * link: https://leetcode.cn/problems/ransom-note/description/
 */
public class LC383_RansomLetter {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] record = new int[26];
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i > 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "bg";
        String magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
        LC383_RansomLetter lc383_ransomLetter = new LC383_RansomLetter();
        boolean flag = lc383_ransomLetter.canConstruct(ransomNote, magazine);
        System.out.println(flag);
    }
}
