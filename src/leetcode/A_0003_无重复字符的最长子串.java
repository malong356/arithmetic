package leetcode;

/**
 * Created by malong on 2020-02-01.
 */
public class A_0003_无重复字符的最长子串 {

    /*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:

    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:

    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:

    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    */

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] map = new int[128];
        for (int i = 0; i < 128; i++) {
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            pre = Math.max(pre, map[chars[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chars[i]] = i;
            System.out.println(String.format("第%d次循环，pre为%d，cur为%d，len为%d", i, pre, cur, len));
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "pwwkaaewbsrtw";
        int l = lengthOfLongestSubstring(s);
        System.out.println("无重复字符[" + s + "]的最长子串长度为:" + l);

    }

}
