package com.example.zeltr.codehero.Entity;

public class TaskEntity {

    private int id;
    private String content;
    private String description;
    private int questId;
    private String answer;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuestId() {
        return questId;
    }

    public void setQuestId(int questId) {
        this.questId = questId;
    }

    public String getAnswer() { return answer; }

    public void setAnswer(String answer) { this.answer = answer; }

    public boolean isSolved(String input) {
        return answer.equalsIgnoreCase(input);
    }
}
