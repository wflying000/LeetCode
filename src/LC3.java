import java.util.HashMap;
import java.util.Map;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        //假设[left, i]当前不含重复字符的最长子串, 当右边界i向前移动一步时,要加入字符s[i+1] 
        //如果新加进来的字符s[i+1]不在之前的子串中，则当前不含重复字符的子串的区间变为[left, i+1]
        //如果新加进来的字符s[i+1]在之前的子串中, 则这个字符之前的位置可能是区间[0, i]中的任何一个位置
        //假设这个位置为k, 如果 k < left, 则[left, i + 1]仍然不含重复字符, 因此左边界left不变
        //如果 k >= left, 则区间[left, ..., k, ... i + 1]中, k与i+1包含相同字符, 而区间[k+1, i]不含
        //重复字符，因此左边界left更新为k+1, 结合以上两种情况, left = max(left, k + 1)
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            res = Math.max(res, i - left + 1);
            map.put(ch, i);
        }
        return res;
    }
}
