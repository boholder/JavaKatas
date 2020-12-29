package com.practice.spring_boot_web_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * https://stackoverflow.com/a/48097887
 * The "excludeFilters = ..." is default config in @SpringBootApplication,
 * if you set a custom @ComponentScan annotation like below,
 * you need to add "excludeFilters = ..." inside it,
 * or you can't run @WebMvcTest tests (controller tests).
 */
@ComponentScan(value = "com.practice.spring_boot_web_application.**",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class)})
@SpringBootApplication
public class ExampleApplicaition {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplicaition.class, args);
    }
}
