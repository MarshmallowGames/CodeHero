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
        return normalize(answer).equalsIgnoreCase(normalize(input)); }

    private String normalize(String input) {
        return input.replaceAll("\t", "").replaceAll("\r\n", "").replaceAll("\n", "").replaceAll(" ", "");
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", questId=" + questId +
                ", answer='" + answer + '\'' +
                '}';
    }
}
