package beautyOfProgramming.chapter_1;

import org.apache.commons.lang3.StringUtils;

/**
 * Author: yrufeng
 * Create: 2019/8/19 23:16
 * Desc: 对于一个字节（8bit）的无符号整型变量，求其二进制表示中"1"的个数，要求算法的执行效率尽可能高
 * 思考：
 *      1. byte -> int -> long
 *      2. 无符号 -> 有符号
 * Java中byte类型变量是有符号数，范围是-128·127
 */
public class Num_1_in_a_byte {
    public static void main(String[] args) {
        int test_num = 254;  // java byte范围是-128到127，这里用int表示一个字节的无符号整型数
        // way 1
        byte num_1 = count_1_in_byte_num_1(test_num);
        System.out.println("方式一：" + num_1);
        // way 2
        byte num_2 = count_1_in_byte_num_2(test_num);
        System.out.println("方式二：" + num_2);

        // way 3 more effective
        byte num_3 = count_1_in_byte_num_3(test_num);
        System.out.println("方式三：" + num_3);

        // way 4
        byte num_4 = count_1_in_byte_num_4(test_num);
        System.out.println("方式四：" + num_4);

        System.out.println(Integer.toBinaryString(test_num));
    }

    private static byte count_1_in_byte_num_3(int test_num) {
        byte num_1 = 0;
        if (check(test_num)) return num_1;
        while(test_num > 0) {
            test_num = test_num & (test_num - 1);
            num_1 += 1;
        }
        return num_1;
    }

    private static boolean check(int test_num) {
        if (test_num < 0 || test_num > 255) {
            throw new RuntimeException("param error");
        }
        return test_num == 0;
    }

    private static byte count_1_in_byte_num_1(int test_num) {
        byte num_1 = 0;
        if (check(test_num)) return num_1;
        while(test_num != 0) {
            if (test_num % 2 == 1) num_1 += 1;
            test_num /= 2;
        }
        return num_1;
    }

    private static byte count_1_in_byte_num_2(int test_num) {
        byte num_1 = 0;
        if (check(test_num)) return num_1;
        num_1 = (byte)StringUtils.countMatches(Integer.toBinaryString(test_num), "1");
        return num_1;
    }

    private static byte count_1_in_byte_num_4(int test_num) {
        byte num_1 = 0;
        if (check(test_num)) return num_1;
        while(test_num > 0) {
            num_1 += test_num & 0x01;
            test_num >>= 1;
        }
        return num_1;
    }
}
