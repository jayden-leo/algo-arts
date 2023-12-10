package c04_string;

import java.util.ArrayList;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * link: https://leetcode.cn/problems/reverse-words-in-a-string/description/
 */
public class C04ReverseWords {

    public static void main(String[] args) {
        String s = " the sky  is blue";
        String result = new C04ReverseWords().reverseWords(s);
        System.out.println(result);
    }

    public String reverseWords(String s) {
        char[] chars = s.trim().toCharArray();
        int left = 0;
        int right = chars.length - 1;
        // 整体反转
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        // 删除多余空格
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ') {
                chars[slow++] = chars[fast];
            } else if (fast != 0 && chars[fast] == ' ' && chars[fast - 1] != ' ') {
                chars[slow++] = chars[fast];
            }
        }
        // 对单词进行反转
        String substring = String.valueOf(chars).substring(0, slow);
        chars = substring.toCharArray();
        System.out.println(chars);
        int offset;
        for (int i = 0; i < chars.length; i += offset + 1) {
            offset = 0;
            left = i;
            while (left + offset < chars.length - 1 && chars[left + offset] != ' ') {
                offset++;
            }
            if (left+offset==chars.length-1){
                right = left+offset;
            }else{
                right = left + offset - 1;
            }
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

    public String reverseWords2(String s) {
        ArrayList<StringBuilder> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (' ' != chars[i]) {
                answer.append(chars[i]);
                if (i == chars.length - 1) {
                    list.add(answer);
                }
            } else if ((' ' == chars[i] && i > 0 && chars[i - 1] != ' ')) {
                list.add(answer);
                answer = new StringBuilder();
            }
        }
        System.out.println(list);
        answer = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            StringBuilder stringBuilder = list.get(i);
            answer.append(stringBuilder).append(" ");
        }
        return answer.toString().trim();
    }
}
