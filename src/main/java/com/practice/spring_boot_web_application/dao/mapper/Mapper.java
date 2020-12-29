package com.practice.spring_boot_web_application.dao.mapper;

import com.practice.spring_boot_web_application.dao.entity.Entity;

import java.util.List;

/**
 * Simulate Mybatis|Ibatis type Mapper interface with a configuration xml file.
 */
public interface Mapper {
    List<Entity> getEntitiesBy(String category);
}
