package beautyOfProgramming;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: rufeng.yan
 * @Desc:
 * @Date: Created in 12:54 2018/4/9.
 */
public class Problems_3_1 {
    private static final String s1 = "AABCD";
    private static final String s2 = "CDAA";

    public static void main(String[] args) {
        System.out.println(isSuccessMove(s1, s2));
    }

    private static boolean isSuccessMove(String souStr, String objStr) {
        if (StringUtils.isBlank(souStr) || StringUtils.isBlank(objStr)) {
            return false;
        }
        int len = souStr.length();
        for(int i = 0; i < len; i ++) {
            souStr = rightMove(souStr);
            if(StringUtils.containsIgnoreCase(souStr, objStr)) {
                return true;
            }
        }
        return false;
    }

    private static String rightMove(String souStr) {
        return souStr.charAt(souStr.length()-1) + souStr.substring(0, souStr.length() - 1);
    }

}
