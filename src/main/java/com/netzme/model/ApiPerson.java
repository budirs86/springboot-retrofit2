package com.netzme.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
public class ApiPerson {

    private List<Result> results;

    @Getter
    @Setter
    public static class Result {

        private String gender;

        private Map<String, String> name;

        private Location location;

        private Map<String, String> picture;
    }
}
