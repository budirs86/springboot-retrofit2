package com.netzme.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Location {

    private Map<String, String> street;

    private String city;
}
