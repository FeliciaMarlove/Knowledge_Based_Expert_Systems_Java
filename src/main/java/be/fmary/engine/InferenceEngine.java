package main.java.be.fmary.engine;

import main.java.be.fmary.Ihm.UserConsoleInterface;
import main.java.be.fmary.facts.BooleanFact;
import main.java.be.fmary.facts.Fact;
import main.java.be.fmary.facts.FactFactory;
import main.java.be.fmary.facts.FactsBase;
import main.java.be.fmary.rules.Rule;
import main.java.be.fmary.rules.RulesBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InferenceEngine {
    private FactsBase factsBase;
    private RulesBase rulesBase;
    private UserConsoleInterface userConsoleInterface;
    private int maxRuleLevel;

    public InferenceEngine() {
        this.factsBase = new FactsBase();
        this.rulesBase = new RulesBase();
        this.userConsoleInterface = new UserConsoleInterface();
        this.maxRuleLevel = 0;
    }

    public void execute() {
        factsBase.clear();
        RulesBase base = new RulesBase();
        base.setRules(rulesBase.cloneRules());
        List<Rule> checkedRules = new ArrayList<>();
        Rule rule = findFirstApplicableRule(base);
        // while there are applicable rules, apply the rule, add fact in the Facts Base
        // and remove the rule from rules to be tested
        while (rule != null) {
            Fact fact = rule.getConclusion();
            fact.setLevel(maxRuleLevel + 1);
            factsBase.addFact(fact);
            checkedRules.add(rule);
            base.deleteRule(rule);
            rule = findFirstApplicableRule(base);
        }

        userConsoleInterface.outputRules(checkedRules);
        userConsoleInterface.outputFacts(factsBase.getFacts());
    }

    public int askIntegerValue(String question) {
        return userConsoleInterface.getIntegerInput(question);
    }

    public boolean askBooleanValue(String question) {
        return userConsoleInterface.getBooleanInput(question);
    }

    public void inputRuleAndAddToRuleBase() {
        Scanner sc = new Scanner(System.in);
        String name;
        List<Fact> premisses = new ArrayList<>();
        String conclusionName;
        Fact conclusionFact;
        String type;
        System.out.println("You will create a new rule in the rules base.\nPlease type a name for the rule:");
        name = sc.nextLine();
        System.out.println("Create the premisses of the rule:");
        boolean premissesDone = false;
        do {
            Fact premiss = FactFactory.inputFact();
            premisses.add(premiss);
            System.out.println("Enter another premiss? Enter \"yes\" or \"no\"");
            premissesDone = !sc.nextLine().equalsIgnoreCase("yes");
        } while (!premissesDone);
        System.out.println("What is the conclusion name?");
        conclusionName = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (Fact f : premisses) {
            sb.append(f.getName());
        }
        conclusionFact = new BooleanFact(conclusionName, true, maxRuleLevel + 1, sb.toString());
        rulesBase.addRule(new Rule(name, premisses, conclusionFact));
    }

    /**
     * @param rule The rule to test
     * @return the level or -1 if rule doesn't apply
     */
    private int isRuleValidated(Rule rule) {
        int maxLevel = -1;
        for (Fact fact : rule.getPremisses()) {
            Fact searchedFact = factsBase.getFact(fact.getName());
            // if the fact doesn't exist in the Facts Base we create it and add it to the base
            if (searchedFact == null) {
                if (fact.getQuestion() != null) {
                    searchedFact = FactFactory.createFact(fact, this);
                    factsBase.addFact(searchedFact);
                }
            }
            // if value correspond, the level is updated
            System.out.println(searchedFact);
            System.out.println(fact);
            if (searchedFact.getValue().equals(fact.getValue())) {
                maxLevel = Math.max(maxLevel, searchedFact.getLevel());
            }
        }
        return maxLevel;
    }

    /**
     * Get the first applicable rule from the rules base
     *
     * @param rulesBase
     * @return the first applicable rule, or null if no rule in the rules base can apply
     */
    private Rule findFirstApplicableRule(RulesBase rulesBase) {
        for (Rule rule : rulesBase.getRules()) {
            int level = isRuleValidated(rule);
            if (level != -1) {
                maxRuleLevel = level;
                return rule;
            }
        }
        return null;
    }

    public FactsBase getFactsBase() {
        return factsBase;
    }

    public void setFactsBase(FactsBase factsBase) {
        this.factsBase = factsBase;
    }

    public RulesBase getRulesBase() {
        return rulesBase;
    }

    public void setRulesBase(RulesBase rulesBase) {
        this.rulesBase = rulesBase;
    }

    public UserConsoleInterface getUserConsoleInterface() {
        return userConsoleInterface;
    }

    public void setUserConsoleInterface(UserConsoleInterface userConsoleInterface) {
        this.userConsoleInterface = userConsoleInterface;
    }

    public int getMaxRuleLevel() {
        return maxRuleLevel;
    }

    public void setMaxRuleLevel(int maxRuleLevel) {
        this.maxRuleLevel = maxRuleLevel;
    }
}
