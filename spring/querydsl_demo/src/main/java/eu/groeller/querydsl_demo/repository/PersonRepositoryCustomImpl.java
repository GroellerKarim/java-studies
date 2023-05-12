package eu.groeller.querydsl_demo.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.PredicateTemplate;
import eu.groeller.querydsl_demo.domain.Person;
import eu.groeller.querydsl_demo.domain.PhoneNumber;
import eu.groeller.querydsl_demo.domain.QPerson;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.Optional;

public class PersonRepositoryCustomImpl extends QuerydslRepositorySupport implements PersonRepositoryCustom {
    public PersonRepositoryCustomImpl() {
        super(Person.class);
    }

    @Override
    public Optional<Person> fetchByPhoneNumber(PhoneNumber phoneNumber) {
        QPerson person = QPerson.person;

        Person p = from(person)
                .where(person.phoneNumber.eq(phoneNumber))
                .fetchFirst();

        return Optional.of(p);
    }

    @Override
    public List<Person> fetchByZipCode(String zipCode) {
        QPerson person = QPerson.person;
        
        return from(person)
                .where(person.address.zipCode.eq(zipCode))
                .fetch();
    }

    @Override
    public List<Person> fetchByContainsCity(String city) {
        QPerson person = QPerson.person;

        return from(person)
                .where(person.address.city.contains(city))
                .fetch();
    }
}
