package com.gorest.api.utilities;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream stream =
                    ConfigReader.class
                            .getClassLoader()
                            .getResourceAsStream("config.properties");

            if (stream == null) {
                throw new RuntimeException(
                        "❌ config.properties NOT found in src/test/resources"
                );
            }

            properties.load(stream);

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException(
                    "❌ Property '" + key + "' not found in config.properties"
            );
        }
        return value;
    }
}
