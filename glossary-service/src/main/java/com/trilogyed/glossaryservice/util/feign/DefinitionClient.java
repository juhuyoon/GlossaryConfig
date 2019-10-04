package com.trilogyed.glossaryservice.util.feign;

import com.trilogyed.glossaryservice.model.Definition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("definition-service")
public interface DefinitionClient {
    @GetMapping("/definition/term/{term}")
    List<Definition> getDefinitions(@PathVariable String term);

    @PostMapping("/definition")
    Definition createDefinition(@RequestBody Definition definition);
}
