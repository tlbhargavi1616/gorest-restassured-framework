package com.gorest.api.utilities;

public class MaskUtil {

    public static String maskToken(String token) {
        if (token == null || token.length() < 10) {
            return "****";
        }
        return token.substring(0, 10) + "****";
    }
}
