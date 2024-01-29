package com.example.LAB2.Backend;



public class Cat {


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