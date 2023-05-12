package eu.groeller.querydsl_demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Person extends AbstractPersistable<Long> {

    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private Integer socialSecurityNumber;
    private String email;

    @Embedded
    private PhoneNumber phoneNumber;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Address address;

}
