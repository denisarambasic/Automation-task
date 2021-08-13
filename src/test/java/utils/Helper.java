package utils;

import java.io.IOException;
import java.util.Properties;

public class Helper {

    public static boolean isHeadlessMode() {
        Properties prop = new Properties();
        try {
            prop.load(Helper.class.getClassLoader().getResourceAsStream("MyProject.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String headlessMode = prop.getProperty("headlessMode");
        return Boolean.parseBoolean(headlessMode);
    }

    public static void sleep(int milisec) {
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
