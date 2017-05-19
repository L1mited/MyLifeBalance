package com.inducesmile.androidmultiquiz.entities;

/**
 * Created by Sandman on 12/05/2017.
 */

public class Client {
    private int id;
    private String name;
    private String email;

    public Client() {}

    public Client(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId()  {
        return id;
    }

    public void setId(int id)   {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
