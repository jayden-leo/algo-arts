package c03_hashtable;

import java.util.HashMap;

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
public class C06RansomLetter {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];
        for (char c : ransomNote.toCharArray()) {
            counts[c-'a']++;
        }
        for (char c : magazine.toCharArray()) {
            counts[c-'a']--;
        }
        for (int count : counts) {
            if (count>0){
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (map.get(c) != null) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "bg";
        String magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
        boolean flag = new C06RansomLetter().canConstruct(ransomNote, magazine);
        System.out.println(flag);
    }
}
