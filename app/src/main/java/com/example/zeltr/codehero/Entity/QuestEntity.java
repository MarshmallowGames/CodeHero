package com.example.zeltr.codehero.Entity;

import java.util.List;

public class QuestEntity {

    private int id;
    private String story;
    private int worldID;
    private boolean completed;
    private List<TipEntity> tips;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStory() { return story;}

    public void setStory(String story) { this.story = story; }

    public int getWorldID() {
        return worldID;
    }

    public void setWorldID(int worldID) {
        this.worldID = worldID;
    }

    public void setCompleted(boolean completed) { this.completed = completed; }

    public boolean isCompleted() { return completed; }

    public List<TipEntity> getTips() { return tips; }

    public void setTips(List<TipEntity> tips) { this.tips = tips; }
}
