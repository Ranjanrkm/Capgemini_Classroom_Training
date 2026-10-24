package com.tns.banking.enums;

public enum AccountType {
    SAVING("Saving", 4.5, 1000.0),
    CURRENT("Current", 0.0, 0.0);

    private final String displayName;
    private final double annualInterestRate;
    private final double minimumBalance;

    AccountType(String displayName, double annualInterestRate, double minimumBalance) {
        this.displayName = displayName;
        this.annualInterestRate = annualInterestRate;
        this.minimumBalance = minimumBalance;
    }

    public String getDisplayName() { return displayName; }
    public double getAnnualInterestRate() { return annualInterestRate; }

    public static String normalize(String input) {
        if (input == null) return SAVING.displayName;
        String trimmed = input.trim();
        for (AccountType t : values()) {
            if (t.displayName.equalsIgnoreCase(trimmed) || t.name().equalsIgnoreCase(trimmed)) {
                return t.displayName;
            }
        }
        return trimmed;
    }
}