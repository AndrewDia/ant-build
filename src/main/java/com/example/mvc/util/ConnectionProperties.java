package com.example.mvc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionProperties {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    public static void getProperties() {
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            driver = properties.getProperty("spring.datasource.driver-class-name");
            url = properties.getProperty("spring.datasource.url");
            user = properties.getProperty("spring.datasource.username");
            password = properties.getProperty("spring.datasource.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        if (url == null)
            getProperties();
        return url;
    }

    public static String getUser() {
        if (user == null)
            getProperties();
        return user;
    }

    public static String getPassword() {
        if (password == null)
            getProperties();
        return password;
    }

    public static String getDriver() {
        if (driver == null)
            getProperties();
        return driver;
    }
}
