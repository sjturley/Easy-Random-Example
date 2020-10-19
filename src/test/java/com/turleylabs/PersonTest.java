package com.turleylabs;

import com.github.javafaker.Faker;
import com.github.javafaker.idnumbers.EnIdNumber;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.jeasy.random.api.Randomizer;
import org.jeasy.random.randomizers.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class PersonTest {

    private final int seed = 12;
    private final Random random = new Random(seed);
    private final Faker faker = new Faker(random);
    private final Randomizer<String> stateAbbrRandomizer = () -> faker.address().stateAbbr();
    private final Randomizer<String> ssnRandomizer = () -> new EnIdNumber().getValidSsn(faker);
    private final Randomizer<String> phoneNumberRandomizer = () -> faker.numerify("(###) ###-####");
    private final Randomizer<String> phoneExtensionRandomizer = () -> faker.numerify("x####");
    private final Randomizer<String> phoneCountryCodeRandomizer = () -> String.valueOf(random.nextInt(10));
    private final Randomizer<String> countryAbbrRandomizer = () -> faker.country().countryCode2().toUpperCase();
    private final Randomizer<String> phoneTypeRandomizer = createRandomizer("cell", "home");
    private final Randomizer<String> addressTypeRandomizer = createRandomizer("house", "apt");

    @Test
    public void generatePerson() {
        EasyRandomParameters parameters = new EasyRandomParameters()
                .seed(seed)
                .collectionSizeRange(1,1)
                .randomize(FieldPredicates.named("firstName").or(FieldPredicates.named("middleName")), new FirstNameRandomizer(seed))
                .randomize(FieldPredicates.named("lastName"), new LastNameRandomizer(seed))
                .randomize(FieldPredicates.named("ssn"), ssnRandomizer)
                .randomize(FieldPredicates.named("postalCode"), new ZipCodeRandomizer(seed))
                .randomize(FieldPredicates.named("city"), new CityRandomizer(seed))
                .randomize(FieldPredicates.named("county"), new CityRandomizer(seed))
                .randomize(FieldPredicates.named("countryCode"), countryAbbrRandomizer)
                .randomize(FieldPredicates.named("stateCode"), stateAbbrRandomizer)
                .randomize(FieldPredicates.named("latitude"), new LatitudeRandomizer(seed))
                .randomize(FieldPredicates.named("longitude"), new LongitudeRandomizer(seed))
                .randomize(FieldPredicates.named("typeCode").and(FieldPredicates.inClass(Address.class)), addressTypeRandomizer)
                .randomize(FieldPredicates.named("text").and(FieldPredicates.inClass(PhoneNumber.class)), phoneNumberRandomizer)
                .randomize(FieldPredicates.named("extension").and(FieldPredicates.inClass(PhoneNumber.class)), phoneExtensionRandomizer)
                .randomize(FieldPredicates.named("countryCode").and(FieldPredicates.inClass(PhoneNumber.class)), phoneCountryCodeRandomizer)
                .randomize(FieldPredicates.named("typeCode").and(FieldPredicates.inClass(PhoneNumber.class)), phoneTypeRandomizer)
                ;
        EasyRandom easyRandom = new EasyRandom(parameters);
        Person person = easyRandom.nextObject(Person.class);
        System.out.println(person);
    }

    private Randomizer<String> createRandomizer(String... vals) {
        return () -> vals[random.nextInt(vals.length)];
    }  
}
