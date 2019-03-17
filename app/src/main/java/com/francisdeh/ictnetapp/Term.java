package com.francisdeh.ictnetapp;

/**
 * Created by FrancisDeh on 10/31/2017.
 */

public class Term {
    private String term;
    private String definition;

    public Term(String term, String definition){
        this.term = term;
        this.definition = definition;
    }

    public void setTerm(String term){
        this.term = term;
    }

    public void setDefinition(String definition){
        this.definition = definition;
    }

    public String getTerm(){
        return this.term;
    }
    public String getDefinition(){
        return this.definition;
    }

}
