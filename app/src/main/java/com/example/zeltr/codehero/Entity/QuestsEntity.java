package com.example.zeltr.codehero.Entity;

public class QuestsEntity {

    private int id;
    private String name;
    private int worldID;
    private boolean completed;

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

    public int getWorldID() {
        return worldID;
    }

    public void setWorldID(int worldID) {
        this.worldID = worldID;
    }

    public void setCompleted(boolean completed) { this.completed = completed; }

    public boolean isCompleted() { return completed; }

}
