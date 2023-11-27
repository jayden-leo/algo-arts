package c03_hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
public class C01Allophone {

    public static void main(String[] args) {
        String a = "anagram";
        String b = "nagaram";
        C01Allophone lc01_allophone = new C01Allophone();
        boolean result = lc01_allophone.isAnagram(a, b);
        System.out.println(result);
    }

    // 数组，最快
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

    // hashtable 慢一些
    public boolean isAnagram2(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.get(c)==null?1:map.get(c)+1);
        }
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)){
                map.put(c,map.get(c)-1);
            }else{
                return false;
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue()>0){
                return false;
            }
        }
        return true;
    }
}
