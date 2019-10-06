package com.trilogyed.glossaryservice.service;

import com.trilogyed.glossaryservice.model.Definition;
import com.trilogyed.glossaryservice.util.feign.DefinitionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class GlossaryService {

    private DefinitionClient client;

    @Autowired
    public GlossaryService(DefinitionClient client) {
        this.client = client;
    }

    public List<Definition> getDefinitionsByTerm(String term) {
        return Collections.emptyList();
    }

    public Definition createDefinition(Definition definition) {

        System.out.println("Creating Definition");
        return client.createDefinition(definition);

    }
}
