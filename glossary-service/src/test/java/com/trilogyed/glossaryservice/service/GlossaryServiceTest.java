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

import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlossaryServiceTest {



    @MockBean
    private DefinitionClient client;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createDefinition() {

        Definition definition = new Definition();
        definition.setTerm("term");
        definition.setDefinition("definition");

        client.createDefinition(definition);

    }
    @Test
    public void getDefinitions() {

        Definition definition1 = new Definition();
        definition1.setTerm("Apple");
        definition1.setDefinition("An apple is a fruit.");
        definition1.setDefinition("It is round.");
        client.createDefinition(definition1);

        Definition definition2 = new Definition();
        definition2.setTerm("Rain");
        definition2.setDefinition("Rain is wet.");
        definition2.setDefinition("Rain is water");
        client.createDefinition(definition2);

        List<Definition> definitionList = client.getDefinitions(" ");
        assertEquals(2, definitionList.size());

    }

}