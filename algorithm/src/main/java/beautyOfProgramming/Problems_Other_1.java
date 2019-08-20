package beautyOfProgramming;

/**
 * @Author: rufeng.yan
 * @Desc: 在字符串中找出连续最长的数字串，并把这个串的长度返回
 * @Date: Created in 15:18 2018/4/20.
 */
public class Problems_Other_1 {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    public static void main(String[] args) {
        tableSizeFor();
        //System.out.println(getNumberStr("woshishu12xni134xxlx029828"));
    }

    static final void tableSizeFor() {
        for(int i = 0; i < 10; i ++) {
            if(5 == i)
                break;

            System.out.println("hahah " + i);
        }
    }

    public static String getNumberStr(String str) {
        int numStart = 0;
        int numEnd = 9;
        int current = 0;
        int maxLength = 0;
        int count = 0;
        int startIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            int var = Integer.valueOf(str.charAt(i)).intValue();
            if (var >= numStart && var <= numEnd) {
                current = i;
                count++;
            } else {
                count = 0;
            }
            if (maxLength < count) {
                maxLength = count;
                startIndex = current - maxLength + 1;
            }
        }
        return str.substring(startIndex, startIndex + maxLength);
    }
}
