# Spring Boot Web Application Slice Test Practices

This package gives a simple Spring MVC project on Spring boot, and the corresponding unit tests written using Mockito,
Hamcrest, Jackson etc (and 2 integration tests for a controller and mapper). This is not a Kata, but more like an example.
Or we can practice the unit tests as a Kata I guess.

According to [this answer on stackoverflow](https://stackoverflow.com/a/37773971):
> Unit test has a lot of restrictions:
>   * You cannot access any external components (web servers, db and so forth)
>   * Unit tests run only in memory
>   * They are extremely fast (particle of second).

These are some documents about how to write slice unit tests for Spring MVC layers:

* [Hamcrest](http://hamcrest.org/JavaHamcrest/tutorial) is a better readable, assertion framework for use in test cases.
* [BDDMockito in Mockito package](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/BDDMockito.html#given-T-)
  mock and inject other dependencies for your testing object, makes test faster and isolate from other dependencies.
  Writing mock codes in BDD style for a better readable.
* [Testing the Web Layer](https://spring.io/guides/gs/testing-web/) -- Spring official guide for testing controller
  layer.
* [Writing Unit Tests for the Controller Layers with @WebMvcTest](https://springbootdev.com/2018/02/22/spring-boot-test-writing-unit-tests-for-the-controller-layers-with-webmvctest/)
  -- a tutorial which is clearer than the official guide in my view.

* [Testing in Spring](https://docs.spring.io/spring-framework/docs/5.3.2/reference/html/testing.html) Spring official
  document.

* [Testing in Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing)
  Spring official document.

* [Testing with a running server (with auto-configuration WebTestClient or TestRestTemplate)](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing-spring-boot-applications-testing-with-running-server)
  Spring official document.

* [Mocking and Spying Beans](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing-spring-boot-applications-mocking-beans)
  notes about Spring test + Mockito.

* [Test Auto-configuration Annotations](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-test-auto-configuration.html#test-auto-configuration)
  document about what components are auto-configuration with Spring @XxxTest annotations.

* [spring-test-dbunit](https://springtestdbunit.github.io/spring-test-dbunit/)
  Use this library to write mapper unit tests. It reads fake data prepared in a Excel xls file, makes a mocked
  datasource for your mapper for unit testing.

* [MyBatis-Spring-Boot-Starter-Test](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-test-autoconfigure/)
  Mybatis official library for mybatis component unit testing. 