package com.practice.spring_boot_web_application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.spring_boot_web_application.dao.entity.Entity;
import com.practice.spring_boot_web_application.dto.Request;
import com.practice.spring_boot_web_application.dto.Response;
import com.practice.spring_boot_web_application.service.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

/**
 * You mast add @RunWith annotation if you use junit4,
 * but you need not add @Extends(SpringExtension.class)(<-equal to @RunWith in junit4)
 * if you use junit5.
 */
@RunWith(SpringRunner.class)
/**
 *  Real project's full content configuration will add lots of additional platform configurations,
 *  such as Eureka, database pools etc, which can slow down your test (about few seconds).
 *
 *  I personally recommend writing an additional configuration class
 *  (use @Configuration, not use @TestConfiguration will it's just loaded as additional config with main config)
 *  and using @Import in the test and overriding full content configuration.
 *
 *  What's more, use @Import to add beans that declared with @Autowired in test class.
 *  Check @MockBean's document for example usage of @Import annotation.
 */
//@Import(MyCustomTestConfiguration.class)
/**
 * @WebMvcTest only scan Components with @Controller annotation,
 * and let Spring auto-config MockMvc, WebMvc etc, so we need not manually config them.
 * But if you are conscious about test speed and don't want to write test configurations,
 * you can change @RunWith(SpringRunner.class) to @RunWith(MockitoJUnitRunner.class),
 * delete @WebMvcTest annotation, change @MockBean to @Mock, and configure MockMvc manually.
 *
 * This blog is clearer than the official guide(https://spring.io/guides/gs/testing-web/):
 * https://springbootdev.com/2018/02/22/spring-boot-test-writing-unit-tests-for-the-controller-layers-with-webmvctest/
 */
@WebMvcTest(Controller.class)
public class ControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    // This is spring's annotation, Mockito's corresponding annotation is @Mock.
    @MockBean
    private Service service;

    @Test
    public void testGetEntities() throws Exception {
        String url = "/v1/entity";
        Request request = buildRequest("c1");

        Response dummyResponse = buildDummyResponse();

        // given (Behavior Driven Development style of writing tests)
        // https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/BDDMockito.html
        given(service.getEntitiesBy(any(Request.class)))
                .willReturn(dummyResponse);

        // when
        Map<String, Object> responseMap = performQueryAndParseResponseToMap(url, request);

        // then (Hamcrest, readable test assertion library)
        assertThat(responseMap.get("message"), is("ok"));
    }

    private Request buildRequest(String category) throws JsonProcessingException {
        return new Request().setCategory(category);
    }

    private Response buildDummyResponse() {
        Entity dummyEntity = new Entity().setCategory("c1").setName("name");
        return new Response("ok").setData(Collections.singletonList(dummyEntity));
    }

    private Map<String, Object> performQueryAndParseResponseToMap(String url, Request request) throws Exception {
        MvcResult mvcResult = performMockMvcQuery(url, request);
        return parseJsonStringToMap(mvcResult);
    }

    private MvcResult performMockMvcQuery(String url, Request request) throws Exception {
        // Jackson json parser. You can use other json parser libraries.
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStrRequest = objectMapper.writeValueAsString(request);

        // Note that and...() methods are called behind perform() method.
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(jsonStrRequest))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        return mvcResult;
    }

    private Map<String, Object> parseJsonStringToMap(MvcResult mvcResult) throws UnsupportedEncodingException, com.fasterxml.jackson.core.JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String responseString = mvcResult.getResponse().getContentAsString();
        // Jackson json parser.
        // You can use a parser which can construct target object from json string,
        // witch make assertion more convenient.
        Map<String, Object> responseMap = objectMapper.readValue(responseString, Map.class);
        return responseMap;
    }
}