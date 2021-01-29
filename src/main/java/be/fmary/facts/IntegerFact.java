package main.java.be.fmary.facts;

public class IntegerFact implements Fact {
    private String name;
    private Integer value;
    private int level;
    private String question;

    public IntegerFact(String name, Integer value, int level, String question) {
        this.name = name;
        this.value = value;
        this.level = level;
        this.question = question;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public void setValue(Object bValue) {
        this.value = value;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
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
