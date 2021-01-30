package main.java.be.fmary.engine;

import main.java.be.fmary.Ihm.UserConsoleInterface;
import main.java.be.fmary.facts.FactsBase;
import main.java.be.fmary.rules.RulesBase;

public class InferenceEngine {
    private FactsBase factsBase;
    private RulesBase rulesBase;
    private UserConsoleInterface userConsoleInterface;
    private int maxRuleLevel;

    public InferenceEngine(FactsBase factsBase, RulesBase rulesBase, int maxRuleLevel) {
        this.factsBase = factsBase;
        this.rulesBase = rulesBase;
        this.maxRuleLevel = maxRuleLevel;
    }

    public int askIntegerValue(String question) {
        return userConsoleInterface.getIntegerInput(question);
    }

    public boolean askBooleanValue(String question) {
        return userConsoleInterface.getBooleanInput(question);
    }
}
