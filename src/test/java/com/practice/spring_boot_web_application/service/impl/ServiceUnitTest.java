package com.practice.spring_boot_web_application.service.impl;

import com.practice.spring_boot_web_application.dao.entity.Entity;
import com.practice.spring_boot_web_application.dao.mapper.Mapper;
import com.practice.spring_boot_web_application.dto.Request;
import com.practice.spring_boot_web_application.dto.Response;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

/**
 * By using "Enclosed.class" junit runner,
 * we can use suite like tests in one file,
 * then we can put method oriented test cases
 * into separated classes but in one file
 * (one public method in service,
 * many test cases in one inner class).
 * <p>
 * Make classes which contains Mockito test cases public,
 * as MockitoJUnitRunner can only run on public class.
 * <p>
 * Integration test for service layer is similar with test for mapper.
 */
@RunWith(Enclosed.class)
public class ServiceUnitTest {
    static class MethodTestsClass {
        // Put mocks below under ServiceUnitTest class with static modifier
        // will throw NPE when running tests.
        @Mock
        Mapper mapper;

        @InjectMocks
        ServiceImpl service;
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class getEntitiesByCategoryTests extends MethodTestsClass {

        @Test
        public void withBadRequest() {
            Response actual = service.getEntitiesBy(null);
            assertThat(actual.getMessage(), is("query request is not complete"));
        }

        @Test
        public void withEmptyDb() {
            given(mapper.getEntitiesBy("emptyDb"))
                    .willReturn(Collections.emptyList());
            Response actual = service.getEntitiesBy(buildRequest("emptyDb"));
            assertThat(actual.getMessage(), is("query result from db is empty"));
        }

        @Test
        public void withNormalResponse() {
            given(mapper.getEntitiesBy("normal"))
                    .willReturn(buildDummyMapperReturn());
            Response actual = service.getEntitiesBy(buildRequest("normal"));
            assertThat(actual.getMessage(), is("ok"));
            assertThat(actual.getData().get(0).getName(), is("n"));
        }
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class anotherMethodTests extends MethodTestsClass {

        @Test
        public void test() {

        }
    }

    private static Request buildRequest(String category) {
        return new Request().setCategory(category);
    }

    private static List<Entity> buildDummyMapperReturn() {
        return Collections.singletonList(new Entity().setCategory("c").setName("n"));
    }
}