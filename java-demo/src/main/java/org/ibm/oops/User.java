package org.ibm.oops;

public class User implements Persistable {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {
        System.out.println("Saving user " + name + " to database " + DB_NAME);
    }

    @Override
    public void load() {
        System.out.println("Loading user " + name + " from database " + DB_NAME);
    }

    @Override
    public void delete() {
        System.out.println("Deleting user " + name + " from database " + DB_NAME);
    }

}
