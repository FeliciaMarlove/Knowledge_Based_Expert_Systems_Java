package main.java.be.fmary.engine;

import main.java.be.fmary.Ihm.UserConsoleInterface;
import main.java.be.fmary.facts.Fact;
import main.java.be.fmary.facts.FactFactory;
import main.java.be.fmary.facts.FactsBase;
import main.java.be.fmary.rules.Rule;
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

    /**
     *
     * @param rule The rule to test
     * @return the level or -1 if rule doesn't apply
     */
    private int isRuleValidated(Rule rule) {
        int maxLevel = -1;
        for(Fact fact: rule.getPremisses()) {
            Fact searchedFact = factsBase.getFact(fact.getName());
            // if the fact doesn't exist in the Facts Base we create it and add it to the base
            if (searchedFact == null) {
                if (fact.getQuestion() != null) {
                    searchedFact = FactFactory.createFact(fact, this);
                    factsBase.addFact(searchedFact);
                }
            }
            // if value correspond, the level is updated
            if (searchedFact.getValue().equals(fact.getValue())) {
                maxLevel = Math.max(maxLevel, searchedFact.getLevel());
            }
        }
        return maxLevel;
    }

    /**
     * Get the first applicable rule from the rules base
     * @param rulesBase
     * @return the first applicable rule, or null if no rule in the rules base can apply
     */
    public Rule findFirstApplicableRule(RulesBase rulesBase) {
        for(Rule rule: rulesBase.getRules()) {
            int level = isRuleValidated(rule);
            if (level != -1) {
                maxRuleLevel = level;
                return rule;
            }
        }
        return null;
    }
}
