package com.vk.firestoreexampleproject;

public class Note {

    private String title;
    private String description;

    public Note() {
        //Нужен пустой конструктор, чтобы приложение не покрашилось
    }

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
