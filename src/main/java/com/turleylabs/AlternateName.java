package com.turleylabs;

public class AlternateName {
    String alternateNameType;
    String firstName;
    String middleName;
    String lastName;
    String organizationName;

    @Override
    public String toString() {
        return "\n\tAlternateName{" +
                "alternateNameType='" + alternateNameType + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", organizationName='" + organizationName + '\'' +
                '}';
    }
}
