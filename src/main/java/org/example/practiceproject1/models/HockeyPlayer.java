package org.example.practiceproject1.models;

import jakarta.persistence.*;

@Entity
@Table(name="HockeyPlayer")
public class HockeyPlayer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="Name")
    private String name;

    @Column(name="Age")
    private int age;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
}
