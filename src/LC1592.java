import java.util.ArrayList;
import java.util.List;

public class LC1592 {
    public String reorderSpaces(String text) {
        int numSpace = 0;
        int i = 0;
        int n = text.length();
        List<String> list = new ArrayList<>();
        while (i < n) {
            while (i < n && text.charAt(i) == ' ') {
                i++;
                numSpace++;
            }
            if (i < n) {
                int s = i;
                while (i < n && text.charAt(i) != ' ') {
                    i++;
                }
                list.add(text.substring(s, i));
            }
        }
        StringBuilder sb = new StringBuilder();
        if (list.size() == 1) {
            sb.append(list.get(0));
            for (i = 0; i < numSpace; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }
        int numInterSpace = numSpace / (list.size() - 1);
        for (i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                for (int j = 0; j < numInterSpace; j++) {
                    sb.append(' ');
                }
            }
        }
        for (i = 0; i < numSpace % (list.size() - 1); i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
