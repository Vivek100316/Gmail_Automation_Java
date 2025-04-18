package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static void loadConfig() throws Exception {
        prop = new Properties();
        FileInputStream ip = new FileInputStream("src/test/resources/config.properties");
        prop.load(ip);
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
