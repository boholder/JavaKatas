package com.practice.spring_boot_web_application.service;

import com.practice.spring_boot_web_application.dto.Request;
import com.practice.spring_boot_web_application.dto.Response;

@org.springframework.stereotype.Service
public interface Service {
    Response getEntitiesBy(Request request);
}
