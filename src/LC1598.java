public class LC1598 {
    //设当前离主目录距离为res, res初始化为0,
    //如果当前操作是"../", 如果当前在主目录则res不变, 否则res--
    //如果当前操作是"./", 则保持res不变
    //如果是到其他文件夹的操作则res++
    public int minOperations(String[] logs) {
        int res = 0;
        for (int i = 0; i < logs.length; i++) {
            String str = logs[i];
            if (str.equals("../")) {
                res -= res > 0 ? 1 : 0;
            } else if (str.equals("./")) {

            } else {
                res++;
            }
        }
        return res;
    }
}
