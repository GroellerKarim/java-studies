package eu.groeller.querydsl_demo.repository;

import eu.groeller.querydsl_demo.domain.TestKitType;
import eu.groeller.querydsl_demo.domain.TestResult;

import java.time.LocalDateTime;

public interface TestRepositoryCustom {

    long countByTestKitTypeAndTestResultAndBetweenDates(TestKitType testKitType, TestResult testResult, LocalDateTime start, LocalDateTime end);

}
