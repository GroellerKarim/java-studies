package eu.groeller.querydsl_demo.repository;

import eu.groeller.querydsl_demo.domain.Person;
import eu.groeller.querydsl_demo.domain.PhoneNumber;

import java.util.List;
import java.util.Optional;

public interface PersonRepositoryCustom {

    Optional<Person> fetchByPhoneNumber(PhoneNumber phoneNumber);

    List<Person> fetchByZipCode(String zipCode);
    List<Person> fetchByContainsCity(String city);

}
