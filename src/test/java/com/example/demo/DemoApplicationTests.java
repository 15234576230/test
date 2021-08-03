package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String s = "1840000000";
        String s2 = "187000000";
        char[] chars = s.toCharArray();
        char[] chars2 = s2.toCharArray();
        int a = charToInt(chars);
        int b = charToInt(chars2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a + b);
    }

    public int charToInt(char[] chars) {
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            int digit = ((int) chars[i] & 0xF);
            for (int j = 0; j < chars.length - 1 - i; j++) {
                digit *= 10;
            }
            result += digit;
        }
        return result;
    }


    /**
     * 给定N个有序整数A1, A2, ... AN，请你从中找出M个位置相邻整数，组成等差数列。那么M最大可是多少？
     * 输入：
     * 一个int数组，有序。
     * 输出
     * 一个整数代表答案
     * 例：输入：
     * {1,1,2,5,6,8,10,12,13,14}
     * 输出： 4
     */
    @Test
    public void test() {
        int[] a = {1,1,2,5,6,8,10,12,13,14};
//        int[] a = {1,1,2,4,6,8,10,12,13,14};
//        int[] a = {1,1,2,4,6,8,10,12,16,18,19};
//        int[] a = {0, 2, 4, 6, 8, 10, 12, 14, 15, 16};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }

        System.out.println(aaa(list));
    }

    /**
     * 将数组转换成集合，以集合内的每个元素的值为初始值，将后面的值与前一位元素值进行比较。
     * 当元素为初始值时，将当前元素和下一元素放入集合中，否则将下一元素与当前元素比较。
     * 如果差值与上一差值相同的话，将其放入集合中，并计算当前集合符合等差数列的个数，
     * 如果集合的size大于2并且集合的size减去当前值的角标等于3时，则表示当前集合符合要求，总数值加一。
     * 由于等差数列最少3个元素，数组的size减去当前值的角标等于3时，直接返回总数值
     * 否则创建新的集合替代当前集合，并将当前符合的个数与总数值相加。
     * */
    public int aaa(List<Integer> list) {
        //两个元素之间的差值
        int n = 0;
        //符合要求的总数值
        int totalSize = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            //集合内符合要求的数值
            int size = 0;
            for (int j = i + 1; j < list.size(); j++) {
                if (j == i + 1) {
                    integers.add(list.get(i));
                    integers.add(list.get(j));
                    n = list.get(j) - list.get(i);
                } else {
                    if (list.get(j) - list.get(j - 1) != n) {
                        n = list.get(j) - list.get(j - 1);
                        ArrayList<Integer> newIntegers = new ArrayList<>();
                        totalSize += size;
                        integers = newIntegers;
                        break;
                    } else {
                        integers.add(list.get(j));
                        if (integers.size() > 2) {
                            size++;
                            if (list.size() - i == 3) {
                                totalSize++;
                                return totalSize;
                            }
                        }
                    }
                }

            }
        }
        return totalSize;
    }

}
