package com.epam.andrei_eremenko.task_01.module;

public abstract class Paradox implements ModuleInterface {

    private static int idCounter = 0;
    private final int id;
    private String name;

    Paradox(String name) {
        this.id = setId();
        this.name = name;
    }

    private int getId() {
        return id;
    }

    static int getIdCounter() {
        return idCounter;
    }

    String getName() {
        return name;
    }

    public abstract String getResult();

    private synchronized int setId() {
        ++idCounter;
        return idCounter;
    }

    public static synchronized void resetIdCounter() {
        idCounter = 0;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (this.getClass() == obj.getClass()) {
            return true;
        }

        Paradox other = (Paradox) obj;
        return ((getId() == other.getId()) &&
                (getName().equals(other.getName())));
    }
}
