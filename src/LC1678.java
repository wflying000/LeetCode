public class LC1678 {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            char ch = command.charAt(i);
            if (ch == 'G') {
                sb.append(ch);
                i++;
            } else if (ch == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i += 2;
                } else {
                    sb.append("al");
                    i += 4;
                }
            }
        }
        return sb.toString();
    }
}
