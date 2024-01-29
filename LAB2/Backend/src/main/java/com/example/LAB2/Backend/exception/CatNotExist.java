package com.example.LAB2.Backend.exception;

public class CatNotExist extends NullPointerException{
    public CatNotExist(){super("Kot nie istnieje");}
}
