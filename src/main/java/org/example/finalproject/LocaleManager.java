package org.example.finalproject;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleManager {
    private static Locale currentLocale = new Locale("en","CA");
    private static ResourceBundle currentBundle;

    // Load the ResourceBundle based on the current locale
    public static void loadLocale() {
        currentBundle = ResourceBundle.getBundle("ApplicationMessages", currentLocale);
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
}
