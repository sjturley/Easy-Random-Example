package com.turleylabs;

public class PhysicalAddress {
    String city;
    String stateCode;
    String postalCode;
    String county;
    String countryCode;

    @Override
    public String toString() {
        return "\n\tPhysicalAddress{" +
                "city='" + city + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", county='" + county + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
