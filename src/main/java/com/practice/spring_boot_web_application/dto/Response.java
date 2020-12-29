package com.practice.spring_boot_web_application.dto;

import com.practice.spring_boot_web_application.dao.entity.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class Response {
    private String message;
    private List<Entity> data;

    public Response(String message) {
        this.message = message;
    }
}
