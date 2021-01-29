package main.java.be.fmary;

public class Fact {
    private String name;
    private Boolean bValue;
    private Integer iValue;
    private int level;
    private String question;

    public Fact() {
    }

    public Fact(String name, Integer iValue, int level, String question) {
        this.name = name;
        this.iValue = iValue;
        this.level = level;
        this.question = question;
    }

    public Fact(String name, Boolean bValue, int level, String question) {
        this.name = name;
        this.bValue = bValue;
        this.level = level;
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean bValue() {
        return bValue;
    }

    public void setbValue(Boolean bValue) {
        this.bValue = bValue;
    }

    public Integer getiValue() {
        return iValue;
    }

    public void setiValue(Integer iValue) {
        this.iValue = iValue;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Fact{" +
                "name='" + name + '\'' +
                ", bValue=" + bValue +
                ", iValue=" + iValue +
                ", level=" + level +
                ", question='" + question + '\'' +
                '}';
    }
}
