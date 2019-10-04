package com.trilogyed.glossaryservice.controller;

import com.trilogyed.glossaryservice.model.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/glossary")
public class GlossaryController {
    @GetMapping("/term/{term}")
    @ResponseStatus(HttpStatus.OK)
    public List<Definition> getDefitions(@PathVariable String term) {
        return Collections.emptyList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Definition createDefinition(@RequestBody Definition definition) {
        return null;
    }
}
