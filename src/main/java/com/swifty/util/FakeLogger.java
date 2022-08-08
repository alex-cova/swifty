package com.swifty.util;

import java.nio.file.Path;

public class FakeLogger {

    public static void info(String s, Path absolutePath) {
        info(s, absolutePath.toString());
    }

    public static void info(String s, String absolutePath) {
        System.out.println(s + " " + absolutePath);
    }

    public static void info(String s) {
        System.out.println(s);
    }

    public static void error(String errorMsg) {
        System.err.println(errorMsg);
    }
}
