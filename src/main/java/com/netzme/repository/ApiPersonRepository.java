package com.netzme.repository;

import com.netzme.model.ApiPerson;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiPersonRepository {
    
    @GET("/api/")
    Call<ApiPerson> getPerson();
}
