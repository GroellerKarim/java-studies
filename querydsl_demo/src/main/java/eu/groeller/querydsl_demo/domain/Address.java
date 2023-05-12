package eu.groeller.querydsl_demo.domain;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends AbstractPersistable<Long> {

    private String streetNumber;
    private String zipCode;
    private String city;
    private String country;


}
