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
            + "xp INTEGER, "
            + "coins INTEGER, "
            + "FOREIGN KEY(worldId) REFERENCES worlds(id))";
    public static final String INSERT_QUESTS = "INSERT INTO quests (story, worldId, xp, coins) "
            + "VALUES ('You walk down a long road. After walking for some time you meet a farmer standing by the road. Greet him by saying “Hello farmer”.', 1, 5, 1), "
            + "('You continue down the road and reach a little market, you want to greet the merchants one by one when you enter their stand. "
            + "Greet them with “Hello merchant” but store the string as a variable that can be used multiple times.', 1, 11, 3), "
            + "('While continuing down the road, you hear a scream. You want to check up on it and want to start running. Run by putting boolean ‘run’ in the if-statement.', 1, 13, 2), "
            + "('When you arrive to where you hear the scream coming from, you see 3 goblins. The goblins is approaching you, so you pull out your sword. Fill a for loop so it loops 9 times.', 1, 25, 5)";

    public static final String CREATE_USER_QUESTS_TABLE = "CREATE TABLE IF NOT EXISTS userQuests ("
            + "questId INTEGER PRIMARY KEY, "
            + "userId INTEGER, "
            + "worldId INTEGER, "
            + "completed BOOLEAN, "
            + "FOREIGN KEY(userId) REFERENCES users(id), "
            + "FOREIGN KEY(questId) REFERENCES quests(id), "
            + "FOREIGN KEY(worldId) REFERENCES worlds(id))";

    public static final String INSERT_USER_QUESTS = "INSERT INTO userQuests (userId, questId, worldId, completed) "
            + "VALUES (1, 1, 1, 1), (1, 2, 1, 1), (1, 3, 1, 0), (1, 4, 1, 0)";

    public static final String CREATE_TIPS_TABLE = "CREATE TABLE IF NOT EXISTS tips ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "content TEXT, "
            + "questId INTEGER, "
            + "FOREIGN KEY(questId) REFERENCES quests(id))";

    public static final String INSERT_TIPS = "INSERT INTO tips (content, questId) "
            + "VALUES ('In Java you can print strings(text) with System.out.println(\"<your text>\");', 1), "
            + "('Variables in Java are assigned by writing their type, giving them a name and a value.', 2), "
            + "('If-statements runs if the inserted statement returns true or false.', 3), "
            + "('In Java a for loop can look like: for(int i=1; i<11; i++)', 4)";

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
            + "}', 1, 'public class Main {public static void main(String[] args) {System.out.println(\"Hello farmer\");}}', "
            + "'Task: Print out \"Hello farmer\".'), "

            + "('public class Main {\r\n"
            + "\tpublic static void main(String[] args) {\r\n"
            + "\t\tString hello \"______\";\r\n"
            + "\t\tSystem.Out.Println(_______)\r\n"
            + "\t}\r\n"
            + "}', 2, 'public class Main {public static void main(String[] args) {String hello = \"Hello\";System.Out.Println(hello);}}', "
            + "'Task: Assign \"Hello merchant\" to a String and print out the string.'), "

            + " ('public class Main {\r\n"
            + "\tpublic static void main(String[] args) {\r\n"
            + "\t\tboolean run = true\r\n"
            + "\t\tif(___){\r\n"
            + "\t\t\trun();\r\n"
            + "\t\t}\r\n"
            + "\t}\r\n"
            + "}', 3, 'public class Main {public static void main(String[] args) {boolean run = true;if(run){run();}}}', "
            + "'Task: Insert the boolean ‘run’ into the if-statement.'), "

            + "('public class Main {\r\n"
            + "\tpublic static void main(String[] args) {\r\n"
            + "\t\tfor(int i = 0; i < _; i++){\r\n"
            + "\t\t\tslashGoblin();\r\n"
            + "\t\t}\r\n"
            + "\t}\r\n"
            + "}', 4, 'public class Main {public static void main(String[] args) {for(int i = 0; i < 9;i++){slashGoblin();}}}', "
            + "'Task: Fill the for loop so it runs 9 times.')";

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
