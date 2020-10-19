package com.turleylabs;

public class PhoneNumber {
    String typeCode;
    String text;
    String extension;
    String countryCode;

    @Override
    public String toString() {
        return "\n\tPhoneNumber{" +
                "typeCode='" + typeCode + '\'' +
                ", text='" + text + '\'' +
                ", extension='" + extension + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
