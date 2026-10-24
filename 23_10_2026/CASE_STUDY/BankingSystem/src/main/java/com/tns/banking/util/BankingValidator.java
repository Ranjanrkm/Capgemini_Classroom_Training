package com.tns.banking.util;

import java.util.regex.Pattern;

public class BankingValidator {
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[6-9]\\d{9}$");

    public static boolean isValidPhone(String contact) {
        return contact != null && PHONE_PATTERN.matcher(contact.trim()).matches();
    }
}