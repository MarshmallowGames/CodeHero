package com.example.zeltr.codehero.Persistence;

public class DBCreationQueries {

    public static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS users ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "firstName VARCHAR(255), "
            + "lastName VARCHAR(255), "
            + "userName VARCHAR(255), "
            + "email VARCHAR(255))";
    public static final String INSERT_INTO_USER_TABLE = "INSERT INTO users (firstName, lastName, userName, email) "
            + "VALUES ('Dennis', 'Mikkelsen', 'Zeltres', 'Zeltres@hotmail.com')";

    public static final String CREATE_WORLD_TABLE = "CREATE TABLE IF NOT EXISTS worlds ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name VARCHAR(255))";
    public static final String INSERT_INTO_WORLD_TABLE = "INSERT INTO worlds (name) "
            + "VALUES ('The Road')";

    public static final String CREATE_QUEST_TABLE = "CREATE TABLE IF NOT EXISTS quests ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "story TEXT, "
            + "worldID INTEGER, "
            + "FOREIGN KEY(worldID) REFERENCES worlds(id))";
    public static final String INSERT_QUESTS = "INSERT INTO quests (story, worldID) "
            + "VALUES ('quest1', 1), ('quest2', 1), ('quest3', 1), ('quest4', 1)";

    public static final String CREATE_USER_QUESTS_TABLE = "CREATE TABLE IF NOT EXISTS userQuests ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "userId INTEGER, "
            + "questId INTEGER, "
            + "worldId INTEGER, "
            + "completed BOOLEAN, "
            + "FOREIGN KEY(userId) REFERENCES users(id), "
            + "FOREIGN KEY(questId) REFERENCES quests(id), "
            + "FOREIGN KEY(worldId) REFERENCES worlds(id))";

    public static final String INSERT_USER_QUESTS = "INSERT INTO userQuests (userId, questId, worldId, completed) "
            + "VALUES (1, 1, 1, 0), (1, 2, 1, 0), (1, 3, 1, 0), (1, 4, 1, 0)";

    public static final String CREATE_TIPS_TABLE = "CREATE TABLE IF NOT EXISTS tips ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "content TEXT, "
            + "questId INTEGER, "
            + "FOREIGN KEY(questId) REFERENCES quests(id))";

    public static final String CREATE_TASKS_TABLE = "CREATE TABLE IF NOT EXISTS tasks ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "content TEXT, "
            + "questId INTEGER, "
            + "answer TEXT, "
            + "description TEXT, "
            + "FOREIGN KEY(questId) REFERENCES quests(id))";

    public static final String CREATE_ITEMS_TABLE = "CREATE TABLE IF NOT EXISTS items ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "uniqueId TEXT, "
            + "position TEXT, "
            + "type VARCHAR(250), ";

    public static final String CREATE_USER_ITEMS_TABLE = "CREATE TABLE IF NOT EXISTS userItems ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "userId INTEGER, "
            + "itemId INTEGER, "
            + "isActive BOOLEAN, "
            + "FOREIGN KEY(userId) REFERENCES user(id)"
            + "FOREIGN KEY(itemId) REFERENCES items(id))";

}
