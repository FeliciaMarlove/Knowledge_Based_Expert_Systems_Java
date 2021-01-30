package main.java.be.fmary;

import main.java.be.fmary.Ihm.UserConsoleInterface;
import main.java.be.fmary.engine.InferenceEngine;
import main.java.be.fmary.facts.BooleanFact;
import main.java.be.fmary.facts.FactsBase;
import main.java.be.fmary.facts.IntegerFact;
import main.java.be.fmary.rules.Rule;
import main.java.be.fmary.rules.RulesBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static Scanner sc = new Scanner(System.in);
    private static boolean done = false;
    private static InferenceEngine engine = new InferenceEngine();

    public static void main(String[] args) {
        useExistingRulesBase();
    }

    private static void useExistingRulesBase() {
        FactsBase factsBase = new FactsBase() {{
            addFact(new IntegerFact("3 angles", 3, 0, "How many angles does the shape have?"));
            addFact(new IntegerFact("4 angles", 4, 0, "How many angles does the shape have?"));
            addFact(new BooleanFact("right angle", true, 0, "Does the shape have at least one right angle?"));
        }};

        RulesBase rulesBase = new RulesBase();
        List<Rule> rules = new ArrayList<>() {{
            add(new Rule("Rule-1",
                    List.of(factsBase.getFact("3 angles")),
                    new BooleanFact("is a triangle", true, engine.getMaxRuleLevel() + 1, null)
                    ));
            add(new Rule("Rule-2",
                    List.of(factsBase.getFact("4 angles")),
                    new BooleanFact("is a quad", true, engine.getMaxRuleLevel() + 1, null)
            ));
            add(new Rule("Rule-3",
                    List.of(factsBase.getFact("3 angles"), factsBase.getFact("right angle")),
                    new BooleanFact("is a triangle w/ right angle", true, engine.getMaxRuleLevel() + 1, null)
            ));
        }};
        rulesBase.setRules(rules);
        engine.setFactsBase(factsBase);
        engine.setRulesBase(rulesBase);
        engine.setUserConsoleInterface(new UserConsoleInterface());
        engine.execute();
    }

    private static void letUserInputRules() {
        do {
            engine.inputRuleAndAddToRuleBase();
            System.out.println("Add another rule? type \"yes\" to continue or any key to stop:");
            done = !sc.nextLine().equalsIgnoreCase("yes");
        } while (!done);
        engine.getRulesBase().cloneRules().forEach(System.out::println);
    }
}
