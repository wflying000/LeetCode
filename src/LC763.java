import java.util.ArrayList;
import java.util.List;

public class LC763 {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        int[] map = new int[26];
        for (int i = 0; i < n; i++) {
            map[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            end = Math.max(end, map[ch - 'a']); // 更新片段结尾位置
            if (i == end) { // 说明找到符合要求的片段，将片段长度加入结果中
                res.add(end - start + 1);
                start = end + 1;
            } 
        }

        return res;
    }
}
