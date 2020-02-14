package by.epam.nickgrudnitsky.entity;

public abstract class Problem {
    private String name;

    public abstract void checkAlgorithm();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
