package com.example.LAB2.Backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
        public String getName () {
            return name;
        }
        public int getAge () {
            return age;
        }
        public void setAge ( int age){
            this.age = age;
        }
        public void setName (String name){
            this.name = name;
        }
        public Long getId () {
            return id;
        }
    protected Cat() {}

}