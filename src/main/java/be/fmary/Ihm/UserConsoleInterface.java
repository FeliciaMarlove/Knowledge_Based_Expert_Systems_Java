package main.java.be.fmary.Ihm;

import main.java.be.fmary.facts.Fact;
import main.java.be.fmary.rules.Rule;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserConsoleInterface {
    private Scanner sc;

    public UserConsoleInterface() {
        sc = new Scanner(System.in);
    }

    public int getIntegerInput(String question) {
        System.out.println(question);
        int input;
        try {
            input = sc.nextInt();
            return input;
        } catch (InputMismatchException e) {
            System.out.println("Please only input an integer value");
            getIntegerInput(question);
        }
        return -999_999;
    }

    public boolean getBooleanInput(String question) {
        System.out.println(question);
        switch (sc.nextLine().toUpperCase()) {
            case "YES":
                return true;
            case "NO":
                return false;
            default:
                System.out.println("Please input \"yes\" or \"no\"");
                getBooleanInput(question);
                break;
        }
        return false;
    }

    public void outputFacts(List<Fact> facts) {
        facts.forEach(System.out::println);
    }

    public void outputRules(List<Rule> rules) {
        rules.forEach(System.out::println);
    }
}
