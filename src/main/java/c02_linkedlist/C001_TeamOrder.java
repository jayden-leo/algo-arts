package c02_linkedlist;

/**
 * 中信笔试题：
 * 团队活动中，队员人数为N，排成队列后每人有一个固定的编号（从1开始递增），并从头到尾依次进行分组，组员数量从1开始依次递增，
 * 也就是第一组 1 个人，第二组 2 个人，第三组 3 个人…….，最后数量不足的成员为一组，分完组之后要求第M小组（M为单数）的成员反转排列顺序，
 * 其他组的成员保持不变，最终形成新的排列队列。
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
 * 1 2 3 6 5 4 7 8 9 10 15 14 13 12 11 16 17
 */
public class C001_TeamOrder {

    public static void main(String[] args) {
        orderTeam(17);
    }

    private static void orderTeam(int n) {
        int[] res = new int[n];
        int curIndex = 0;
        int curNum = 1;
        int groupNum = 1;
        while (curIndex < n) {
            int lastIndex = Math.min(curIndex + groupNum - 1, n-1);
            if (groupNum % 2 == 1) {
                int count = 0;
                int temp = curIndex;
                for (; curIndex <= lastIndex; curIndex++) {
                    res[curIndex] = temp + groupNum - count;
                    count++;
                    curNum++;
                }
                groupNum += 1;
            } else {
                for (; curIndex <= lastIndex; curIndex++) {
                    res[curIndex] = curNum;
                    curNum++;
                }
                groupNum += 1;
            }
        }
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
