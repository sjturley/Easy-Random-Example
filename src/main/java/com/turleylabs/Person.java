package com.turleylabs;

import java.util.List;

public class Person {
    String firstName;
    String lastName;
    String middleName;
    String ssn;
    List<Address> addresses;
    List<AlternateName> alternateNames;
    List<PhoneNumber> phoneNumbers;

    @Override
    public String toString() {
        return "\n\tPerson{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", addresses=" + addresses +
                ", alternateNames=" + alternateNames +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
