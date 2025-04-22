package com.art.demo4;

import java.util.UUID;

public class Tests {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }
}