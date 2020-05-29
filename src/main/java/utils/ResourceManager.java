package utils;

import java.io.IOException;
import java.util.Properties;

public class ResourceManager {
    private static Properties properties;

    public static String getProperty(String key) {
        if (properties == null) {
            properties = readProperties();
        }
        return properties.getProperty(key);
    }

    private static Properties readProperties() {
        properties = new Properties();
        String propertyFile = "/test.properties";
        try {
            properties.load(ResourceManager.class.getResourceAsStream(propertyFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

