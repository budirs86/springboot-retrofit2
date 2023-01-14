package com.netzme.service;


import com.netzme.dto.PersonDTO;
import com.netzme.model.ApiPerson;
import com.netzme.repository.ApiPersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private ApiPersonRepository userRepository;

    @Override
    public PersonDTO getPerson() {
        try {
            Call<ApiPerson> callSync = userRepository.getPerson();
            Response<ApiPerson> response = callSync.execute();
            ApiPerson randomUser = response.body();

            PersonDTO person = null;
            if (randomUser.getResults().size() > 0){
                ApiPerson.Result result = randomUser.getResults().get(0);
                String fullname = String.join(" ", result.getName().get("title"), result.getName().get("first"),
                        result.getName().get("last"));
                String address = String.join(" ",result.getLocation().getStreet().get("number"),
                        result.getLocation().getStreet().get("name"), result.getLocation().getCity());

                person = new PersonDTO();
                person.setGender(result.getGender());
                person.setFullname(fullname);
                person.setAddress(address);
                person.setPicture(result.getPicture().get("medium"));
            }

            return person;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PersonDTO getPerson(PersonDTO personDTO) {
        return null;
    }
}

