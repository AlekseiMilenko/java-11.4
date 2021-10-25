package ru.netology.domain;

public class Movie {
    private int id;
    private String title;

    public Movie(){
    }

    public Movie(int id, String title){
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

}
