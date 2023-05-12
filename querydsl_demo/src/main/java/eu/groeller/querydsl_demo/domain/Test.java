package eu.groeller.querydsl_demo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Test extends AbstractPersistable<Long> {

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Person person;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private TestStation testStation;

    private Integer testBay;
    private TestKitType testKitType;
    private TestResult testResult;

    private LocalDateTime testTimeStamp;
}
