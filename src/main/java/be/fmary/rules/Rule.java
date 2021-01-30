package main.java.be.fmary.rules;

import main.java.be.fmary.facts.Fact;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Rule implements Cloneable {
    private String name;
    private List<Fact> premisses;
    private Fact conclusion;

    public Rule(String name, List<Fact> premisses, Fact conclusion) {
        this.name = name;
        this.premisses = premisses;
        this.conclusion = conclusion;
    }

    public List<Fact> getPremisses() {
        List<Fact> clonedList = new ArrayList<>();
        premisses.forEach( fact -> clonedList.add((Fact) fact.clone()));
        return clonedList;
    }

    public void setPremisses(List<Fact> premisses) {
        this.premisses = premisses;
    }

    public Fact getConclusion() {
        return conclusion;
    }

    public void setConclusion(Fact conclusion) {
        this.conclusion = conclusion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": IF (");
        StringJoiner sj = new StringJoiner(" AND ");
        premisses.forEach( fact -> {
            sj.add(fact.getName());
        });
        sb.append(sj).append(") THEN ").append(conclusion);
        return sb.toString();
    }

    public Object clone() {
        List<Fact> clonedPremisses = new ArrayList<>();
        premisses.forEach( fact -> {
            clonedPremisses.add((Fact) fact.clone());
        });
        return new Rule(name, clonedPremisses, conclusion);
    }
}
