package c04_string;

import java.util.Scanner;

/**
 * 题目描述
 * 给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为 number。
 * 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
 * 输入描述 输入一个字符串 s,s 仅包含小写字母和数字字符。
 * 输出描述 打印一个新的字符串，其中每个数字字符都被替换为了number
 * 输入示例  a1b2c3
 * 输出示例  anumberbnumbercnumber
 * link: https://kamacoder.com/problempage.php?pid=1064
 */
public class KMC54_ReplaceNums {

    public String replaceNums(String s){
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char ch :chars){
            if (ch-'0'>=0&&ch-'0'<=9){
                result.append("number");
            }else{
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        KMC54_ReplaceNums kmc54_replaceNums = new KMC54_ReplaceNums();
        String result = kmc54_replaceNums.replaceNums(s);
        System.out.println(result);
    }
}
