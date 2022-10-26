import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> prefix = new HashSet<>();
        for (String str : dictionary) {
            prefix.add(str);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (prefix.contains(words[i].substring(0, j + 1))) {
                    words[i] = words[i].substring(0, j + 1);
                    break;
                }
            }
        }
        return String.join(" ", words);
    }
}
