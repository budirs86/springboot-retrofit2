package com.netzme.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Person {

    private String gender;

    private Map<String, String> name;
}
