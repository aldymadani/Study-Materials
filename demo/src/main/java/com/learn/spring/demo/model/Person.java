package com.learn.spring.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class Person {
    @JsonProperty("id")
    private final UUID id;

    @JsonProperty("name")
    private final String name;
}
