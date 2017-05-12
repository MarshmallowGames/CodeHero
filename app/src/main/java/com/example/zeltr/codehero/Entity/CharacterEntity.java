package com.example.zeltr.codehero.Entity;

import java.util.List;

public class CharacterEntity {

    private String gender;
    private List<ItemEntity> items;

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public List<ItemEntity> getItems() { return items; }

    public void setItems(List<ItemEntity> items) { this.items = items; }
}
