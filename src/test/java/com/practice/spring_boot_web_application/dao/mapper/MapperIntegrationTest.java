package com.practice.spring_boot_web_application.dao.mapper;

import com.practice.spring_boot_web_application.dao.entity.Entity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * You can use this library to write mapper unit tests.
 * It reads fake data prepared in a Excel xls file,
 * makes a mocked datasource for your mapper for unit testing.
 * But now I only write a integration test with real datasource.
 * <p>
 * https://springtestdbunit.github.io/spring-test-dbunit/
 * <p>
 * Note that if you are particularly using mybatis,
 * mybatis provide a library called MyBatis-Spring-Boot-Starter-Test,
 * which helps you write mybatis mapper tests.
 * It configures an in-memory embedded database for testing usage.
 * <p>
 * http://mybatis.org/spring-boot-starter/mybatis-spring-boot-test-autoconfigure/
 */

/**
 * We need Spring to prepare datasource for us,
 * even we don't actually have one.
 */
@RunWith(SpringRunner.class)
/**
 * Use custom only-contains-datasource-config configuration
 * to load less context to speed up DAO tests.
 */
//@Import(MyDataSourceConfig.class)
@SpringBootTest
public class MapperIntegrationTest {
    @Autowired
    Mapper mapper;

    @Test
    public void selectEntitiesByCategory() {
        List<Entity> actual = mapper.getEntitiesBy("realCategoryInDb");
        assertThat(actual.size(), greaterThan(0));
    }
}