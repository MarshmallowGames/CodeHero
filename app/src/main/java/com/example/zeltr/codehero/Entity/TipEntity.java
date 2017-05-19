package com.example.zeltr.codehero.Entity;

import java.io.Serializable;

public class TipEntity implements Serializable {

    private int id;
    private String content;
    private int questId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuestId() {
        return questId;
    }

    public void setQuestId(int questId) {
        this.questId = questId;
    }

    @Override
    public String toString() {
        return "TipEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", questId=" + questId +
                '}';
    }
}
