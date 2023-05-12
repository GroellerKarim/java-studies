package eu.groeller.querydsl_demo.repository;

import eu.groeller.querydsl_demo.domain.Address;
import eu.groeller.querydsl_demo.domain.Gender;
import eu.groeller.querydsl_demo.domain.Person;
import eu.groeller.querydsl_demo.domain.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    void setup() {
        Person person = new Person("Kek", "Kock", Gender.DIVERS, LocalDate.of(2002,10,2),232, "kek@mail.com", new PhoneNumber(12,12,12), new Address("Leonard", "1220", "Wien", "AT"));
        Person person2 = new Person("Kek", "Kock", Gender.FEMALE, LocalDate.of(2002,10,2),232, "kek@mail.com", new PhoneNumber(212,132,12), new Address("Leonard", "1320", "Wien", "AT"));
        Person person3 = new Person("Kek", "Kock", Gender.MALE, LocalDate.of(2005,10,2),232, "kek@mail.com", new PhoneNumber(15,34,122), new Address("Leonard", "1220", "Wien", "AT"));

        personRepository.saveAll(List.of(person, person2, person3));
    }

    @Test
    void ensureFetchByZipCodeWorks() {
        // Arrange
        String zipcode = "1220";

        // Act
        val persons = personRepository.fetchByZipCode(zipcode);
        log.info(String.valueOf(persons.size()));

        // Assert
        assertThat(persons.size()).isEqualTo(2);

    }
}
