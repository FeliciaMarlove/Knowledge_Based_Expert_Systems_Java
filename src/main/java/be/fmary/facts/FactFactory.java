package main.java.be.fmary.facts;

import main.java.be.fmary.engine.InferenceEngine;

public class FactFactory {
    static Fact Fact(Fact fact, InferenceEngine engine) {
        if (fact instanceof IntegerFact) {
            return new IntegerFact(
                    fact.getName(),
                    engine.askIntegerValue(fact.getQuestion()),
                    0,
                    null
                    );
        } else {
            return new BooleanFact(
                    fact.getName(),
                    engine.askBooleanValue(fact.getQuestion()),
                    0,
                    null
            );
        }
    }
}
