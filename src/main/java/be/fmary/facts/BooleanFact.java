package main.java.be.fmary.facts;

public class BooleanFact implements Fact, Cloneable {
    private String name;
    private Boolean value;
    private int level;
    private String question;

    public BooleanFact(String name, Boolean value, int level, String question) {
        this.name = name;
        this.value = value;
        this.level = level;
        this.question = question;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object bValue) {
        this.value = value;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public Object clone() {
        return new BooleanFact(name, value, level, question);
    }

    @Override
    public String toString() {
        return "Fact{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", level=" + level +
                ", question='" + question + '\'' +
                '}';
    }
}
