package edu.matc.test.util;
import org.apache.logging.log4j.LogManager;

import java.io.*;
import java.util.*;
import org.apache.logging.log4j.Logger;

/**
 * This interface contains a default method that can be used anywhere a Properties
 * object is needed to be loaded.
 * @author Eric Knapp
 *
 */
public interface PropertiesLoader {

    Logger logger =  LogManager.getLogger(PropertiesLoader.class);

    /**
     * This default method will load a properties file into a Properties instance
     * and return it.
     * @param propertiesFilePath a path to a file on the java classpath list
     * @return a populated Properties instance or an empty Properties instance if
     * the file path was not found.
     */
    default Properties loadProperties(String propertiesFilePath){
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            logger.error("Error loading properties", ioException);
        } catch (Exception exception) {
            logger.error("Undexpected error loading properties file", exception);
        }
        return properties;
    }
}