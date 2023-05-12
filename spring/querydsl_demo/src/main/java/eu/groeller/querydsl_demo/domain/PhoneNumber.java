package eu.groeller.querydsl_demo.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Embeddable
public class PhoneNumber {

    private Integer countryCode;
    private Integer areaCode;
    private Integer serialNumber;

}
