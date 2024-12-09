package org.example.finalproject;

import java.util.Locale;
import java.util.ResourceBundle;

public class i18n {

    private static ResourceBundle bundle;

    // Load the resource bundle based on the system locale or user preference
    public static void loadBundle(Locale locale) {
        bundle = ResourceBundle.getBundle("ApplicationMessages", locale); // Load bundle based on selected locale
    }

    // Get localized string
    public static String getString(String key) {
        return bundle.getString(key);
    }
}
