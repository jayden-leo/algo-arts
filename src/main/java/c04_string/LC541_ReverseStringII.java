package c04_string;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * link: https://leetcode.cn/problems/reverse-string-ii/description/
 */
public class LC541_ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int curIndex = 0; curIndex < chars.length; curIndex += 2 * k) {
            int left = curIndex;
            int right = Math.min(chars.length - 1, left + k - 1);
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        LC541_ReverseStringII lc541_reverseStringII = new LC541_ReverseStringII();
        String result = lc541_reverseStringII.reverseStr(s, 2);
        System.out.println(result);
    }
}
