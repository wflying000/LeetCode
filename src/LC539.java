import java.util.Collections;
import java.util.List;

public class LC539 {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int minutes0 = getMinutes(timePoints.get(0));
        int preMinutes = minutes0;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            int curMinutes = getMinutes(timePoints.get(i));
            res = Math.min(res, curMinutes - preMinutes);
            preMinutes = curMinutes;
        }
        res = Math.min(res, minutes0 + 1440 - preMinutes);
        return res;

    }

    public int getMinutes(String a) {
        int h = (a.charAt(0) - '0') * 10 + (a.charAt(1) - '0');
        int m = (a.charAt(3) - '0') * 10 + (a.charAt(4) - '0');
        return h * 60 + m;
    }
}
