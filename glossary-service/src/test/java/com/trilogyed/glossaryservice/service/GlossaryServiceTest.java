package com.trilogyed.glossaryservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.glossaryservice.model.Definition;
import com.trilogyed.glossaryservice.util.feign.DefinitionClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlossaryServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DefinitionClient client;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createDefinitionShouldReturnCreatedDefinition() throws Exception {

        Definition inputDefinition = new Definition();
        inputDefinition.setTerm("term");
        inputDefinition.setDefinition("definition");

        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(inputDefinition);

        Definition outputDefinition = new Definition();
        outputDefinition.setTerm("term");
        outputDefinition.setDefinition("definition");
        outputDefinition.setId(8);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputDefinition);

        when(client.createDefinition(inputDefinition)).thenReturn(outputDefinition);

        this.mockMvc.perform(post("/glossary")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

}