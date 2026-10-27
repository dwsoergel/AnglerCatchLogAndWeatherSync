package com.dwsoergel.angler.testUtils;

import java.io.IOException;
import java.util.Properties;


/**
 * Provides a default method for loading a Properties object.
 *
 * @author Eric Knapp
 */
public interface PropertiesLoader {

    /**
     * Loads a properties file into a Properties instance.
     *
     * @param propertiesFilePath path to a file on the Java classpath
     * @return a populated Properties instance, or an empty Properties
     * instance if the properties could not be loaded
     */
    default Properties loadProperties(String propertiesFilePath) {
        Properties properties = new Properties();

        try {
            properties.load(
                    this.getClass()
                            .getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return properties;
    }
}
