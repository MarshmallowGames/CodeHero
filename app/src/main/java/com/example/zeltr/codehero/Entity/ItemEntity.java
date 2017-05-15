package com.example.zeltr.codehero.Entity;

public class ItemEntity {

    private int id;
    private String uniqueId;
    private String type;
    private String position;
    private boolean isActive;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUniqueId() { return uniqueId; }

    public void setUniqueId(String uniqueId) { this.uniqueId = uniqueId; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public boolean isAttackItem() { return type == "attack"; }

    public boolean isDefenseItem() { return type == "defense"; }

    public boolean isActive() { return isActive; }

    public void setActive(boolean active) { isActive = active; }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }
}
