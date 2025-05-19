package org.example.api.model;

public class User {
    private String name;
    private int age;

    public User() {
    }

    /**
     *
     * @param name
     * @param age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     *
     * @return name
     */
    public String getName() { return name; }

    /**
     *
     * @param name
     */
    public void setName(String name) { this.name = name; }

    /**
     *
     * @return age
     */
    public int getAge() { return age; }

    /**
     *
     * @param age
     */
    public void setAge(int age) { this.age = age; }
}
