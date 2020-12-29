package com.practice.spring_boot_web_application.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Entity {
    private String name;
    private String category;
}
