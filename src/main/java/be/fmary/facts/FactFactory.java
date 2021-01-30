package main.java.be.fmary.facts;

import main.java.be.fmary.engine.InferenceEngine;

import java.util.Scanner;

public class FactFactory {
    public static Fact createFact(Fact fact, InferenceEngine engine) {
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

    public static Fact inputFact() {
        Scanner sc = new Scanner(System.in);
        Boolean ok;
        String type;
        String name;
        String question;
        String value;
        do {
            System.out.println("You will create a new fact in the facts base.\nPlease type a name for the fact:");
            name = sc.nextLine();
            System.out.println("Please type a question for the fact:");
            question = sc.nextLine();
            do {
                System.out.println("Please type \"bool\" for a \"True/False\" question or \"int\" for an integer question");
                type = sc.nextLine().toLowerCase();
            } while (!type.equals("bool") || !type.equals("int"));
            switch (type) {
                case "bool":
                    System.out.println("Please type the value, either \"true\" or \"false\":");
                    do {
                        value = sc.nextLine().toLowerCase();
                    } while (value.equals("true") || value.equals("false"));
                    break;
                case "int":
                    System.out.println("Please type the integer:");
                    do {
                        value = sc.nextLine();
                    } while (value.matches("[0-9]+"));
                    break;
                default:
                    value = null; break;
            }

            System.out.println("Please check that everything is correct, type \"ok\" to confirm or any key to retry:");
            System.out.println("Name = " + name + ",\ntype = "
                    + (type.equalsIgnoreCase("bool") ? "True/False question" : "Integer question")
                    + ",\nquestion = " + question);
            ok = sc.nextLine().equalsIgnoreCase("ok");
        } while (!ok);

        switch (type) {
            case "bool": return new BooleanFact(name, Boolean.valueOf(value), 0, question);
            case "int": return new IntegerFact(name, Integer.valueOf(value), 0, question);
        }
        return null;
    }
}
