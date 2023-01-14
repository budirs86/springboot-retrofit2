package com.netzme.controller;

import com.netzme.dto.PersonDTO;
import com.netzme.service.PersonService;
import com.netzme.controller.PersonController;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.assertNull;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private PersonController controller;

    @MockBean
    private PersonService personService;
    private PersonDTO person = new PersonDTO();
 
    @Test
    @DisplayName("Should return the Person JSON")
    public void testGetPersonSuccess() throws Exception {
        
        person.setGender("male");
        person.setFullname("Mr Axel Clement");
        person.setAddress("5271 Rue du 8 Mai 1945 Versailles");
        person.setPicture("https://randomuser.me/api/portraits/men/52.jpg");

        when(personService.getPerson()).thenReturn(person);

        mockMvc.perform(get("http://localhost:8080/api/person")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gender", is(person.getGender())))
                .andExpect(jsonPath("$.fullname", is(person.getFullname())))
                .andExpect(jsonPath("$.address", is(person.getAddress())))
                .andExpect(jsonPath("$.picture", is(person.getPicture())));
    }


    @Test
    @DisplayName("Should Return Null")
    public void testGetPersonFailed() throws Exception{
        assertNull(controller);
    }
}
