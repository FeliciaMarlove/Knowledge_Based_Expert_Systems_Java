package main.java.be.fmary.facts;

import java.util.ArrayList;
import java.util.List;

public class FactsBase {
    private List<Fact> facts;

    public List<Fact> getFacts() {
        List<Fact> clonedList = new ArrayList<>();
        facts.forEach( fact -> clonedList.add((Fact) fact.clone()));
        return clonedList;
    }

    public void clearFactsBase() {
        facts.clear();
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public FactsBase() {
        this.facts = new ArrayList<>();
    }
}
