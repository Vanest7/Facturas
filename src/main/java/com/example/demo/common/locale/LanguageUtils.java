package com.example.demo.common.locale;

import java.util.Locale;

public class LanguageUtils {

    private static final ThreadLocal<Locale> currentLocale = new ThreadLocal<>();

    public static void setCurrentLocale(Locale locale) {
        currentLocale.set(locale);
    }

    public static String getCurrentLocale() {
        Locale locale = currentLocale.get();
        return locale != null ? locale.getLanguage() : Locale.getDefault().getLanguage();
    }
}
