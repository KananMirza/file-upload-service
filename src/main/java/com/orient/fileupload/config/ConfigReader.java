package com.orient.fileupload.config;

import com.orient.fileupload.exception.DataNotFoundException;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;

@Component
public class ConfigReader {
    private final static String CONFIG_FILE = "config.properties";
    private static String PATH;

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new DataNotFoundException("Sorry, unable to find " + CONFIG_FILE);
            }

            Properties prop = new Properties();
            prop.load(input);

            // PATH set argument
            PATH = prop.getProperty("PATH");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPath() {
        return PATH;
    }
}
