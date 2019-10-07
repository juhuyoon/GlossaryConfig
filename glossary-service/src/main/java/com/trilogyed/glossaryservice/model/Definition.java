package com.trilogyed.glossaryservice.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class Definition {
    private Integer id;
    @NotBlank
    @Pattern(regexp = "^((?!(?<!\\w)(darn|heck|drat|jerk|butt)(?!\\w)).)*$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Must be family friendly!")
    private String term;
    @NotBlank
    @Pattern(regexp = "^((?!(?<!\\w)(darn|heck|drat|jerk|butt)(?!\\w)).)*$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Must be family friendly!")
    private String definition;

    public Definition() {
    }

    public Definition(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public Definition(Integer id, String term, String definition) {
        this.id = id;
        this.term = term;
        this.definition = definition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(term, that.term) &&
                Objects.equals(definition, that.definition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, term, definition);
    }

    @Override
    public String toString() {
        return "Definition{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
