package eu.groeller.querydsl_demo.repository;

import eu.groeller.querydsl_demo.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDateTime;

public class TestRepositoryCustomImpl extends QuerydslRepositorySupport implements TestRepositoryCustom {


    public TestRepositoryCustomImpl() {
        super(Test.class);
    }

    @Override
    public long countByTestKitTypeAndTestResultAndBetweenDates(TestKitType testKitType, TestResult testResult, LocalDateTime start, LocalDateTime end) {
        QTest test = QTest.test;

        return from(test)
                .where(test.testKitType.eq(testKitType)
                        .and(test.testResult.eq(testResult))
                        .and(test.testTimeStamp.between(start, end)))
                .fetchCount();
    }
}
