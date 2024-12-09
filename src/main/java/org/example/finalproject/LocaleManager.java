package org.example.finalproject;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleManager {
    private static final Locale enLocale = new Locale("en", "CA");
    private static final Locale frLocale = new Locale("fr", "CA");
    private static Locale currentLocale = enLocale;
    private static ResourceBundle currentBundle;

    // Load the ResourceBundle based on the current locale
    public static void loadLocale() {
        currentBundle = ResourceBundle.getBundle("org/example/finalproject/ApplicationMessages", currentLocale);
    }

    // Get the current ResourceBundle
    public static ResourceBundle getBundle() {
        return currentBundle;
    }

    // Get the current locale
    public static Locale getCurrentLocale() {
        return currentLocale;
    }

    // Set the locale and reload the ResourceBundle
    public static void setLocale(Locale locale) {
        currentLocale = locale;
        loadLocale(); // Reload the bundle with the new locale
    }

    public static Locale getEnLocale(){
        return enLocale;
    }

    public static Locale getFrLocale(){
        return frLocale;
    }

    public static String getString(String key) {
        return currentBundle.getString(key);
    }
}
