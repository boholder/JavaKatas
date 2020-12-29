package com.practice.spring_boot_web_application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.spring_boot_web_application.dao.entity.Entity;
import com.practice.spring_boot_web_application.dto.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
/**
 * Can't actually run this test as we don't have a datasource.
 * Read this official document for meaning of "webEnvironment":
 * https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing-spring-boot-applications-testing-with-running-server
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ControllerIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testGetEntities() throws JsonProcessingException {
        Request request = new Request().setCategory("realCategory");
        // dev-env-url: http://localhost:8080/v1/entity
        String url = "http://localhost:8080/v1/entity";

        // when
        Map<String, Object> actual = performQuery(url, request);

        // then
        assertThat(actual.get("message"), is("ok"));
        List<Entity> actualData = (List<Entity>) actual.get("data");
        assertThat(actualData.get(0).getName(), is("realEntityName"));
    }

    private Map<String, Object> performQuery(String uri, Request request) throws JsonProcessingException {
        HttpHeaders headers = buildRequestHeader();
        // Jackson json parser. You can use other json parser libraries.
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStrRequest = objectMapper.writeValueAsString(request);
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonStrRequest, headers);
        String responseJsonStr = restTemplate.postForObject(uri, requestEntity, String.class);
        return objectMapper.readValue(responseJsonStr, Map.class);
    }

    private static HttpHeaders buildRequestHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Headers/Connection
        headers.setConnection("close");
        return headers;
    }
}
