package main.java.be.fmary.facts;

import java.util.ArrayList;
import java.util.List;

public class FactsBase {
    private List<Fact> facts;

    public FactsBase() {
        this.facts = new ArrayList<>();
    }

    public List<Fact> getFacts() {
        List<Fact> clonedList = new ArrayList<>();
        facts.forEach( fact -> clonedList.add((Fact) fact.clone()));
        return clonedList;
    }

    public void clear() {
        facts.clear();
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public Fact getFact(String factName) {
        for(Fact fact: facts) {
            if (fact.getName().equals(factName)) {
                return fact;
            }
        }
        return null;
    }

    public Object getFactValue(String factName) {
        Fact fact = getFact(factName);
        return fact == null ? null : fact.getValue();
    }
}
