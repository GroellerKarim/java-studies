package eu.groeller.querydsl_demo.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TestStation extends AbstractPersistable<Long> {
    String stationName;
}
