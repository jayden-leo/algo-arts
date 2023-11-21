package c04_string;

import java.util.Scanner;

/**
 * 题目描述
 * 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，
 * 请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
 * 例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
 * 输入描述:  输入共包含两行，第一行为一个正整数 k，代表右旋转的位数。第二行为字符串 s，代表需要旋转的字符串。
 * 输出描述:  输出共一行，为进行了右旋转操作后的字符串。
 * 输入示例:
 * 2
 * abcdefg
 * 输出示例
 * fgabcde
 * link: https://kamacoder.com/problempage.php?pid=1065
 */
public class KMC55_RightRotateString {

    public String rightRotateString(int k, String s) {
        StringBuilder sb = new StringBuilder();
        int index = s.length() - k;
        while (index < s.length()) {
            sb.append(s.charAt(index++));
        }
        int start = 0;
        while (start < s.length() - k) {
            sb.append(s.charAt(start++));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int k = scanner.nextInt();
//        String s = scanner.next();
        int k = 2;
        String s = "abcdefg";
        KMC55_RightRotateString kmc55_rightRotateString = new KMC55_RightRotateString();
        String result = kmc55_rightRotateString.rightRotateString(k, s);
        System.out.println(result);
    }
}
