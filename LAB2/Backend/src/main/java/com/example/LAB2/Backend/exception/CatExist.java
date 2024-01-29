package com.example.LAB2.Backend.exception;

public class CatExist extends NullPointerException{
    public CatExist(){super("Kot już istnieje");}
}
