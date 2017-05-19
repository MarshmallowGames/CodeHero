package com.example.zeltr.codehero.Entity;

import java.io.Serializable;
import java.util.List;

public class QuestEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String story;
    private int worldID;
    private boolean completed;
    private List<TipEntity> tips;
    private int xp;
    private int coins;

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

    public int getXp() {return xp;}

    public void setXp(int xp) {this.xp = xp;}

    public int getCoins() {return coins;}

    public void setCoins(int coins) {this.coins = coins;}

    @Override
    public String toString() {
        return "QuestEntity{" +
                "id=" + id +
                ", story='" + story + '\'' +
                ", worldID=" + worldID +
                ", completed=" + completed +
                ", tips=" + tips +
                '}';
    }
}
