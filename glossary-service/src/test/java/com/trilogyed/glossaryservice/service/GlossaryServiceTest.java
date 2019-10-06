package com.trilogyed.glossaryservice.service;

import com.trilogyed.glossaryservice.model.Definition;
import com.trilogyed.glossaryservice.util.feign.DefinitionClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

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
        Definition def = new Definition(
                "term",
                "definition"
        );
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

    @Test
    public void createDefinition() {

        Definition definition = new Definition();
        definition.setTerm("term");
        definition.setDefinition("definition");
    }
}