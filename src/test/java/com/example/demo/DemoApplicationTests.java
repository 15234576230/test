package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String s = "584";
        String s2 = "987";
        char[] chars = s.toCharArray();
        char[] chars2 = s2.toCharArray();
        int a = charToInt(chars);
        int b = charToInt(chars2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a+b);
    }

    public int charToInt(char[] chars){
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            int digit = ((int)chars[i] & 0xF);
            for (int j = 0; j < chars.length-1-i; j++) {
                digit *= 10;
            }
            result += digit;
        }
        return result;
    }

}
