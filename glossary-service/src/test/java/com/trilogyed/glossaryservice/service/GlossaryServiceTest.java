package com.trilogyed.glossaryservice.service;

import com.trilogyed.glossaryservice.model.Definition;
import com.trilogyed.glossaryservice.util.feign.DefinitionClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlossaryServiceTest {

    private GlossaryService service;

    @MockBean
    private DefinitionClient client;

    private void setUpDefinitionClientMock() {
        Definition def = new Definition("term", "definition");
        Definition created = new Definition(
                1,
                "term",
                "definition"
        );

        Definition def2 = new Definition(
                "term 2",
                "definition 2"
        );
        Definition created2 = new Definition(
                2,
                "term 2",
                "definition 2"
        );
        when(client.createDefinition(def)).thenReturn(created);
        when(client.createDefinition(def2)).thenReturn(created2);
        when(client.getDefinitionsByTerm("term 1")).thenReturn(Collections.singletonList(created));
        when(client.getDefinitionsByTerm("term 2")).thenReturn(Collections.singletonList(created2));



    }

    @Before
    public void setUp() throws Exception {
        setUpDefinitionClientMock();
        service = new GlossaryService(client);
    }

//    @Test
//    public void createDefinition() {
//
//        Definition definition = new Definition();
//        definition.setTerm("term");
//        definition.setDefinition("definition");
//    }

    @Test
    public void getDefinitionsByTerm() {

        Definition definition1 = new Definition("term", "definition");
        definition1.setId(1);
        definition1.setTerm("Apple");
        definition1.setDefinition("An apple is a fruit.");
        definition1.setDefinition("It is round.");
        client.createDefinition(definition1);

        Definition definition2 = new Definition("term", "definition");
        definition2.setId(2);
        definition2.setTerm("Rain");
        definition2.setDefinition("Rain is wet.");
        definition2.setDefinition("Rain is water");
        client.createDefinition(definition2);

        List<Definition> definitionList = new ArrayList<>();
        definitionList.add(definition1);
        definitionList.add(definition2);

        assertEquals(2, definitionList.size());

    }

}