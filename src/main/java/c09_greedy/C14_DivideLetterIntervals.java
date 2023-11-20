package c09_greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 * link: https://leetcode.cn/problems/partition-labels/
 */
public class C14_DivideLetterIntervals {
    public List<Integer> partitionLabels(String s) {
        List<Integer> integers = new ArrayList<>();
        return integers;
    }

    public static void main(String[] args) {
        C14_DivideLetterIntervals c14_divideLetterIntervals = new C14_DivideLetterIntervals();
        List<Integer> result = c14_divideLetterIntervals.partitionLabels("ababcbacadefegdehijhklij");
        for (Integer index : result) {
            System.out.println(index + " ");
        }
    }
}
