package com.turleylabs;

public class Address {
    String typeCode;
    String latitude;
    String longitude;
    boolean poBoxFlag;
    PhysicalAddress sourceAddress;

    @Override
    public String toString() {
        return "\n\tAddress{" +
                "typeCode='" + typeCode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", poBoxFlag=" + poBoxFlag +
                ", sourceAddress=" + sourceAddress +
                '}';
    }
}
