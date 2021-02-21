package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {



//In this class we will implement the repeated steps of reading from configuration.properties file

    //#1-Create the object from Properties
    private static Properties properties = new Properties(); //properties type of file //obj

    static {
        //#2-Get the path & open the file
        try {
            FileInputStream file = new FileInputStream("configuration.properties");

            //#3-Load the opened file into properties object
            properties.load(file);                                     //file is loaded inside of the properties obj

            //closing the file in JVM Memory
            file.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //#4-Use the object to read from the configuration.properties file
    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }


}
