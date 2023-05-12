package eu.groeller.querydsl_demo.repository;

import eu.groeller.querydsl_demo.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long>, TestRepositoryCustom {
}
