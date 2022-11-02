package com.ljm.sheji.factoty;

abstract class Person {

    private String name;
    abstract void getMethod();
    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
