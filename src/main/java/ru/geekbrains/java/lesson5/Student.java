package ru.geekbrains.java.lesson5;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private int mark;

    public Student() {
    }

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public Student(long id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
