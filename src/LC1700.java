import java.util.Arrays;

public class LC1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int s1 = Arrays.stream(students).sum();
        int s0 = n - s1;
        int i = 0;
        for (i = 0; i < n; i++) {
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return n - i;
    }
}
