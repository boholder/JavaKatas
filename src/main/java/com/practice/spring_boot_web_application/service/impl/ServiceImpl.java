package com.practice.spring_boot_web_application.service.impl;

import com.practice.spring_boot_web_application.dao.entity.Entity;
import com.practice.spring_boot_web_application.dao.mapper.Mapper;
import com.practice.spring_boot_web_application.dto.Request;
import com.practice.spring_boot_web_application.dto.Response;
import com.practice.spring_boot_web_application.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceImpl implements Service {
    @Autowired
    Mapper mapper;

    @Override
    public Response getEntitiesBy(Request request) {
        // this request validation will be replaced with Spring validation module
        // with Controllers and Validators in real projects.
        if (null == request || null == request.getCategory()) {
            return new Response("query request is not complete");
        }

        return queryFromDb(request.getCategory());
    }

    private Response queryFromDb(String category) {
        List<Entity> result = mapper.getEntitiesBy(category);
        if (null == result || result.isEmpty()) {
            return new Response("query result from db is empty");
        } else {
            return new Response("ok").setData(result);
        }
    }
}
