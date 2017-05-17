package com.example.zeltr.codehero.Persistence;

public class DBCreationQueries {

    public static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS users ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "firstName VARCHAR(255), "
            + "lastName VARCHAR(255), "
            + "userName VARCHAR(255), "
            + "email VARCHAR(255), "
            + "exp INTEGER, "
            + "coins INTEGER)";
    public static final String INSERT_INTO_USER_TABLE = "INSERT INTO users (firstName, lastName, userName, email, exp, coins) "
            + "VALUES ('Dennis', 'Mikkelsen', 'Zeltres', 'Zeltres@hotmail.com', 0, 0)";

    public static final String CREATE_WORLD_TABLE = "CREATE TABLE IF NOT EXISTS worlds ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name VARCHAR(255))";
    public static final String INSERT_INTO_WORLD_TABLE = "INSERT INTO worlds (name) "
            + "VALUES ('The Road')";

    public static final String CREATE_QUEST_TABLE = "CREATE TABLE IF NOT EXISTS quests ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "story TEXT, "
            + "worldId INTEGER, "
            + "FOREIGN KEY(worldId) REFERENCES worlds(id))";
    public static final String INSERT_QUESTS = "INSERT INTO quests (story, worldId) "
            + "VALUES ('quest one', 1), ('quest two', 1), ('quest three', 1), ('quest four', 1)";

    public static final String CREATE_USER_QUESTS_TABLE = "CREATE TABLE IF NOT EXISTS userQuests ("
            + "userId INTEGER, "
            + "questId INTEGER PRIMARY KEY, "
            + "worldId INTEGER, "
            + "completed BOOLEAN, "
            + "FOREIGN KEY(userId) REFERENCES users(id), "
            + "FOREIGN KEY(questId) REFERENCES quests(id), "
            + "FOREIGN KEY(worldId) REFERENCES worlds(id))";

    public static final String INSERT_USER_QUESTS = "INSERT INTO userQuests (userId, questId, worldId, completed) "
            + "VALUES (1, 2, 1, 0), (1, 3, 1, 0), (1, 4, 1, 0)";

    public static final String CREATE_TIPS_TABLE = "CREATE TABLE IF NOT EXISTS tips ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "content TEXT, "
            + "questId INTEGER, "
            + "FOREIGN KEY(questId) REFERENCES quests(id))";

    public static final String INSERT_TIPS = "INSERT INTO tips (content, questId) "
            + "VALUES ('Tip 1', 1), ('Tip 2', 2), ('Tip 3', 3)";

    public static final String CREATE_TASKS_TABLE = "CREATE TABLE IF NOT EXISTS tasks ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "content TEXT, "
            + "questId INTEGER, "
            + "answer TEXT, "
            + "description TEXT, "
            + "FOREIGN KEY(questId) REFERENCES quests(id))";
    public static final String INSERT_TASKS = "INSERT INTO tasks (content, questId, answer, description) "
            + "VALUES "

            + "('public class Main {\r\n"
            + "\tpublic static void main(String[] args) {\r\n"
            + "\t\tSystem.out.println(\"________\");\r\n"
            + "\t}\r\n"
            + "}', 1, 'Task 1 answer', 'Task 1 description'), "


            + "('public class Main {\r\n"
            + "\tpublic static void main(String[] args) {\r\n"
            + "\t\tString hello \"______\";\r\n"
            + "\t\tSystem.Out.Println(_______)"
            + "\t}"
            + "}', 2, 'Task 2 answer', 'Task 2 description'), "


            + " ('public class Main {\r\n"
            + "\tpublic static void main(String[] args) {\r\n"
            + "\t\tboolean run = true\r\n"
            + "\t\tif(___){\r\n"
            + "\t\t\trun();\r\n"
            + "\t\t}"
            + "\t}"
            + "}', 3, 'Task 3 answer', 'Task 3 description'), "


            + "('public class Main {\r\n"
            + "\tpublic static void main(String[] args) {\r\n"
            + "\t\tfor(int i = 0; i < _; i++){\r\n"
            + "\t\t\tslashGoblin();\r\n"
            + "\t\t}\r\n"
            + "\t}"
            + "}', 4, 'public class Main {public static void main(String[] args) {for(int i = 0; i < _; i++){slashGoblin();}}}', "
            + "'Task 4 description')";

    public static final String CREATE_ITEMS_TABLE = "CREATE TABLE IF NOT EXISTS items ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "uniqueId TEXT, "
            + "position TEXT, "
            + "itemType VARCHAR(250))";
    public static final String INSERT_ITEMS = "INSERT INTO items (uniqueId, position, itemType)"
            + "VALUES ('sword', 'leftHand', 'attack'), ('shield', 'righthand', 'defence'), "
            + "('armor', 'chest', 'defence')";

    public static final String CREATE_USER_ITEMS_TABLE = "CREATE TABLE IF NOT EXISTS userItems ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "userId INTEGER, "
            + "itemId INTEGER, "
            + "isActive BOOLEAN, "
            + "FOREIGN KEY(userId) REFERENCES user(id)"
            + "FOREIGN KEY(itemId) REFERENCES items(id))";
    public static final String INSERT_USER_ITEMS = "INSERT INTO userItems (userId, itemId, isActive) "
            + "VALUES (1, 1, 0), (1, 2, 0), (1, 3, 0)";

}
