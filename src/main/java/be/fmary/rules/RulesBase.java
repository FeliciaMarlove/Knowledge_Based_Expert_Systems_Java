package main.java.be.fmary.rules;

import java.util.ArrayList;
import java.util.List;

public class RulesBase {
    private List<Rule> rules;

    public RulesBase() {
        rules = new ArrayList<>();
    }

    public List<Rule> cloneRules() {
        List<Rule> clonedList = new ArrayList<>();
        rules.forEach( rule -> clonedList.add((Rule) rule.clone()));
        return clonedList;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        rules.forEach( rule -> {
            this.rules.add((Rule) rule.clone());
        });
    }

    public void clearRules() {
        rules.clear();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void deleteRule(Rule rule) {
        rules.remove(rule);
    }
}
