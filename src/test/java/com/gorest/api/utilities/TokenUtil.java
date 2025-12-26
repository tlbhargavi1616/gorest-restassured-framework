package com.gorest.api.utilities;

public class TokenUtil {

    public static String getToken() {
        return ConfigReader.get("gorest.token");
    }
}
