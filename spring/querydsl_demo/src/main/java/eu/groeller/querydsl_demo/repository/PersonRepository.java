package eu.groeller.querydsl_demo.repository;

import eu.groeller.querydsl_demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom {
}
