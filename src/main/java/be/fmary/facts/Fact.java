package main.java.be.fmary.facts;

public interface Fact {
    String getName();
    void setName(String name);
    Object getValue();
    void setValue(Object bValue);
    int getLevel();
    void setLevel(int level);
    String getQuestion();
    void setQuestion(String question);
}
