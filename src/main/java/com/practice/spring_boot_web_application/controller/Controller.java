package com.practice.spring_boot_web_application.controller;

import com.practice.spring_boot_web_application.dto.Request;
import com.practice.spring_boot_web_application.dto.Response;
import com.practice.spring_boot_web_application.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private Service service;

    @PostMapping("/v1/entity")
    public Response getEntitiesByCategory(@RequestBody Request request) {
        return service.getEntitiesBy(request);
    }
}
