import java.util.Arrays;

public class LC670 {
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] chs = str.toCharArray();
        Integer[] index = new Integer[str.length()];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> chs[b] - chs[a]);
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] != chs[index[i]]) {
                int j = i; //如果最大值有多个将最后一个最大值与前面值交换, (这里使用排序需要排序结果稳定)
                while (j < chs.length && chs[index[j]] == chs[index[i]]) {
                    j++;
                }
                swap(chs, i, index[j - 1]);
                str = String.valueOf(chs);
                return Integer.parseInt(str);
            }
        }
        return num;
    }

    private void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
