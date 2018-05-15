package ru.innopolis.stc09.education.obj;

public class Course {
    private int id;
    private String name;
    private String descr;

    public Course(int id, String name, String descr) {
        this.id = id;
        this.name = name;
        this.descr = descr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
