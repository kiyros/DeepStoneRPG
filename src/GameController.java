import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class GameController {
    private Player player;
    private final PlayerView view;
    private HashMap<Integer, Room> rooms = new HashMap<>();
    private final Scanner userInput;
    private Puzzle puzzle;
	/*
	author: Joseph Ongchangco

	 */

    // sets up constructor, default constructor for main class
    public GameController(Player player, PlayerView view) {
        this.player = player;
        this.view = view;
        userInput = new Scanner(System.in);
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public void setRooms(HashMap<Integer, Room> rooms) {
        this.rooms = rooms;
    }

    // todo: commands
    // author: Joseph Ongchangco
    public void commands() throws IOException {
        // show main menu
        view.showMenu();

        //prompt user to load game or start a new one
        boolean gameLoaded = gameCheck();
        while (!gameLoaded) {
            switch (userInput.nextLine().toLowerCase()) {
                case "n":
                case "new":
                case "new game":
                    newGame();
                    gameLoaded = gameCheck();
                    break;
                case "l":
                case "load":
                case "lo":
                case "load game":
                    loadGame();
                    gameLoaded = gameCheck();
                    break;
                default:
                    view.error("Command error:  \n try typing in [n]ew or [l]oad to play a game!");
                    break;
            }
        }

        // throws to lowercase to easily verify user commands
        while (true) {
            // informs the user that the program is ready to receive the next command
            view.nextCommand();
            switch (userInput.nextLine().toLowerCase()) {
                case "h":
                case "help":
                    view.getHelp();
                    break;
                case "new":
                case "new game":
                    newGame();
                    // todo new game()
                    System.out.println(rooms);
                    break;
                case "save":
                    saveGame();
                    // todo save command
                    break;
                case "lo":
                case "load":
                    loadGame();
                    // todo load command
                    break;
                case "x":
                case "exit":
                    view.exitView(player.getName());
                    userInput.close();
                    return;
                case "ins":
                case "inspect":
                    inspectItem();
                    // todo: inspect an item in the room or inventory
                    break;
                case "look":
                case "look around":
                case "explore":
                case "exp":
                    exploreRoom();
                    break;
                case "west":
                case "w":
                    moveToRoom("west");
                    break;
                case "east":
                case "e":
                    moveToRoom("east");
                    break;
                case "north":
                case "n":
                    moveToRoom("north");
                    break;
                case "south":
                case "s":
                    moveToRoom("south");
                    break;
                case "pickup":
                case "p":
                    pickupItem();
                    break;
                case "drop":
                case "d":
                    dropItem();
                    break;
                case "solve puzzle":
                case "solve":
                    solvePuzzle();
                    break;
                // todo: for testing functions [ put any function you want to test here to test in-game ]
                case "test":
                    fetchJsonToItem("Dynamite");
                    break;

                default:
                    view.error("Invalid command try typing it correctly or type 'h' for help");
                    break;
            }
        }
    }

    // loadCheck
    public boolean gameCheck() {
        return !rooms.isEmpty();
    }

    // todo: puzzle commands

    // todo: monster encounter commands

    // shows main menu from view
    public void showMainMenu() {
        view.showMenu();
    }


    // todo: sets the health of the player
    public void setPlayerHealth() {
        throw new UnsupportedOperationException();
    }

    // todo: gets the health of the player
    public void getPlayerHealth() {
        throw new UnsupportedOperationException();
    }

    // todo: sets the player Inventory
    public void setPlayerInventory() {
        throw new UnsupportedOperationException();
    }

    // todo: addToPlayerInventory(), adds an item from a room to user inventory

    // todo: picks up an item from the room
    public void pickUpItem() {
        throw new UnsupportedOperationException();
    }

    // todo: equips an item from the players inventory
    public void equipItem() {
        throw new UnsupportedOperationException();
    }

    // todo: unequips an item from the player
    public void unEquipItem() {
        throw new UnsupportedOperationException();
    }

    // todo: leaves the monster encounter
    public void flee() {
        throw new UnsupportedOperationException();
    }

    // todo: inspects item that is in the room or in the players inventory
    // inspects item that is in the room or in the players inventory
    public void inspectItem() {
        view.showInventory(player);
        view.notifier(rooms.get(player.getCurrentRoom()).itemsToString());

        view.notifier("What [item] would you like to [inspect]: ");
        String itemName = userInput.nextLine();

        // inventory
        for (Item playerItem : player.getInventory()) {
            if (playerItem.getName().equals(itemName)) {
                view.notifier(playerItem.toString());
                view.notifier(playerItem.getDescription());
                return;
            }
        }

        // current room
        for (Item roomItem : rooms.get(player.getCurrentRoom()).getItems()) {
            if (roomItem.getName().equals(itemName)) {
                view.notifier(roomItem.toString());
                view.notifier(roomItem.getDescription());
                return;
            }
        }

        // if item is not found return not found
        view.notifier("That item does not seem to exist in your inventory or in the room! \n try again!");
    }

    // todo: sets Rooms when loading a game
    public void setRooms() {
        throw new UnsupportedOperationException();
    }

    // todo: get rooms
    public HashMap<Integer, Room> getRooms() {
        return this.rooms;
    }

    // todo: get room number from player
    public int getCurrentRoomNumber() {
        return player.getCurrentRoom();
    }

    // todo: set room number into player
    public void setCurrentRoomNumber() {
        throw new UnsupportedOperationException();
    }

    // moves a player into a room
    public void moveToRoom(String direction) {
        // check if the room is locked
        if (rooms.get(player.getCurrentRoom()).checkLocked(direction)) {
            view.error("The room is locked, you cannot enter/ maybe solve a [puzzle] or defeat a [monster]");
            return;
        }
        // check if the player can go in that direction
        else if (!rooms.get(player.getCurrentRoom()).checkDirection(direction)) {
            view.error("You can't go that way!!");
            return;
        }
        // change player current room
        player.setCurrentRoom(rooms.get(player.getCurrentRoom()).getExits().get(direction));

        // set room to visited as the player is leaving the room
        rooms.get(player.getCurrentRoom()).setVisited(true);

        // display to user
        view.showRoom(rooms.get(player.getCurrentRoom()));
    }


    // shows ALL the information from the room: items, puzzle, title, monsters, room number.
    public void exploreRoom() {
        view.showRoom(rooms.get(player.getCurrentRoom()));
    }

    // todo: gets the player name
    public String getPlayerName() {
        throw new UnsupportedOperationException();
    }

    // todo: sets the player name
    public void SetPlayerName() {
        throw new UnsupportedOperationException();
    }

    // N/A
    public void updateView() {
        throw new UnsupportedOperationException();
    }

    // todo: saves game into an .txt file
    public void saveGame() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // player
        mapper.writeValue(Paths.get("saveFiles/userData.json").toFile(), player);

        // rooms
        mapper.writeValue(Paths.get("saveFiles/roomData.json").toFile(), rooms);

    }

    // todo: loads the game from a .txt file
    public void loadGame() {
        loadJsonToRoom("saveFiles/userData.json", "saveFiles/roomData.json");
    }

    // todo: starts a new game
    // load the default room values into the room object
    public void newGame() throws IOException {
        // generate random stats values for player
        randomStatGenerator(player);

        newJsonToRoom("rooms.json", "items.json", "puzzles.json", "monsters.json");
    }

    // todo: puzzles, monsters
    // turns the JSON files and reads the information into game Objects and sets the gameController's room to this
    // author: Joseph Ongchangco
    public void newJsonToRoom(String roomPathName, String itemPathName, String puzzlePathName, String monsterPathName) throws IOException {
        HashMap<Integer, Room> tempRoomsHashMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        // rooms
        File roomJSON = new File(roomPathName);

        // items
        File itemJSON = new File(itemPathName);

        // puzzles
        File puzzleJSON = new File(puzzlePathName);

        // monsters
        File monsterJSON = new File(monsterPathName);

        JsonNode rootRooms = mapper.readTree(roomJSON);
        JsonNode rootItems = mapper.readTree(itemJSON);
        JsonNode rootPuzzles = mapper.readTree(puzzleJSON);
        JsonNode rootMonster = mapper.readTree(monsterJSON);

        // iterator ; roomJSON to room object(s)
        for (JsonNode roomJson : rootRooms) {
            // temporary room
            try {
                Room temp = mapper.treeToValue(roomJson, Room.class);
                tempRoomsHashMap.put(temp.getRoomID(), temp);
            } catch (Exception Ignored) {
            }


            // assign values to temp room object
//            temp.setRoomID(roomJson.get("roomID").asInt());
//            temp.setDescription(roomJson.get("description").toString().replace("\"", ""));
//
//            // room exits
//            JsonNode exits = roomJson.get("exits");
//            for (JsonNode exitIter : exits) {
//                if (exitIter.has("west")) {
//                    temp.addExits("west", exitIter.get("west").asInt());
//                }
//                if (exitIter.has("north")) {
//                    temp.addExits("north", exitIter.get("north").asInt());
//                }
//                if (exitIter.has("east")) {
//                    temp.addExits("east", exitIter.get("east").asInt());
//                }
//                if (exitIter.has("south")) {
//                    temp.addExits("south", exitIter.get("south").asInt());
//                }
//            }
//
//            // locked rooms
//            if (roomJson.get("locked") != null) {
//                ArrayList<Integer> tempLocked = new ArrayList<>();
//                for (JsonNode locked : roomJson.get("locked")) {
//                    tempLocked.add(locked.asInt());
//                }
//                // add locked rooms to temporary room object
//                temp.setLockedExits(tempLocked);
//            }

            // add the temporary room object to Map

        }
        // todo: monsterJSON to item object(s)

        for (JsonNode monsterJson : rootMonster) {
            Monster tempMonster = new Monster();


            // basic monster attributes
            tempMonster.setName(monsterJson.get("name").toString().replace("\"", ""));
            tempMonster.setDescription(monsterJson.get("desc").toString().replace("\"", ""));


            if (!monsterJson.get("drops").asBoolean()) {
                tempMonster.setItemDropName(monsterJson.get("drops").toString().replace("\"", ""));
            }

            // generate random stats values for monster
            randomStatGenerator(tempMonster);


            // place monster into a room
            Random r = new Random();
            int startRoom = monsterJson.get("rangeStart").asInt();
            int endRoom = monsterJson.get("rangeEnd").asInt();
            int roomPlacement = r.nextInt(endRoom - startRoom);

            try{
                tempRoomsHashMap.get(roomPlacement).getMonsters().add(tempMonster);
            }
            catch (Exception ignored){}
        }

        // items
        for (JsonNode itemJson : rootItems) {
            Item item = new baseItem();

            // cast to proper item type
            // for testing --> System.out.println(itemJson.get("type").toString().replace("\"", ""));

            if (itemJson.get("type").toString().replace("\"", "").equals("weapon")) {
                item = mapper.treeToValue(itemJson, WeaponItem.class);
            } else if (itemJson.get("type").toString().replace("\"", "").equals("equip")) {
                item = mapper.treeToValue(itemJson, EquipItem.class);
            } else if (itemJson.get("type").toString().replace("\"", "").equals("puzzle")) {
                item = mapper.treeToValue(itemJson, PuzzleItem.class);
            }
            try {
                rooms.get(item.getRoomNumber()).addItems(item);
            } catch (Exception ignored) {
            }

        }

        // puzzle json to puzzle Object
        for (JsonNode puzzleJson : rootPuzzles) {
            Puzzle tempPuzzle = mapper.treeToValue(puzzleJson, Puzzle.class);

            // place puzzle into room
            try {
                tempRoomsHashMap.get(tempPuzzle.getRoomNumber()).setPuzzle(tempPuzzle);
            } catch (Exception ignored) {
            }

        }

        // set the game room to the generated Map the method made from JSON values
        rooms = tempRoomsHashMap;
    }

    // todo: loadJsonToRoom
    // loads save
    public void loadJsonToRoom(String playerPath, String roomPaths) {
        ObjectMapper mapper = new ObjectMapper();
    }

    // returns an item from items.json based on the item name
    public Item fetchJsonToItem(String itemName) throws IOException {
        Item tempItem = new baseItem();
        ObjectMapper itemMap = new ObjectMapper();

        // items
        File itemJSON = new File("items.json");
        JsonNode rootItems = itemMap.readTree(itemJSON);

        if (!rootItems.has(itemName)) {
            view.notifier("Item does not Exist");
            return null;
        }

        // read values into item
        JsonNode item = rootItems.get(itemName);
        if (item.get("type").toString().replace("\"", "").equals("weapon")) {
            tempItem = itemMap.treeToValue(item, WeaponItem.class);
        } else if (item.get("type").toString().replace("\"", "").equals("equip")) {
            tempItem = itemMap.treeToValue(item, EquipItem.class);
        } else if (item.get("type").toString().replace("\"", "").equals("puzzle")) {
            tempItem = itemMap.treeToValue(item, PuzzleItem.class);
        }

        return tempItem;
    }

    //todo: solve puzzle, when user types in "solve puzzle", this method should automatically grab the item remove it and set puzzle in the room to solved
    public void solvePuzzle() {
        view.notifier("What item would you like to use to solve this puzzle? ");

        int currentRoom = player.getCurrentRoom();
        if (rooms.get(currentRoom).getPuzzle().getSolution().equalsIgnoreCase(userInput.nextLine())) {
            player.use(userInput.nextLine());
            rooms.get(currentRoom).getPuzzle().setSolved(true);
            if (!rooms.get(currentRoom).getPuzzle().getRoomUnlock().isEmpty()) {
                rooms.get(currentRoom).getLockedExits().clear();
                rooms.get(currentRoom).getPuzzle().getRoomUnlock().remove(0);
            }
        } else {
            view.notifier("This item is not the correct answer.");
        }
    }

    // get puzzle, returns a puzzle object
    public Puzzle getPuzzle() {
        int currentRoom = player.getCurrentRoom();
        return (rooms.get(currentRoom).getPuzzle());
    }

    public void pickupItem() {
        view.notifier(rooms.get(player.getCurrentRoom()).itemsToString());
        if (rooms.get(player.getCurrentRoom()).getItems().isEmpty()) {
            return;
        }

        view.notifier("What [item] would you like to pick up in the room:");

        // get input from user
        view.notifier(player.pickupItem(rooms.get(player.getCurrentRoom()), userInput.nextLine()));
    }


    public void dropItem() {
        view.notifier(player.inventoryToString());
        if (player.getInventory().isEmpty()) {
            return;
        }

        view.notifier("What [item] would you like to pick up in the room:");

        // get input from user
        view.notifier(player.drop(rooms.get(player.getCurrentRoom()), userInput.nextLine()));
    }

    public void useItem() {
        view.notifier(player.inventoryToString());
        if (player.getInventory().isEmpty()) {
            return;
        }

        view.notifier("What [item] would you like to consume up in the room:");

        // get input from user
        view.notifier(player.use(userInput.nextLine()));
    }

    // player and monster get random stats
    public void randomStatGenerator(Entity entity) {
        Random random = new Random();
        int health = 0;
        int attack = 0;
        int defense = 0;

        int randomStatGenerator = (int) ((Math.random()) * (100 - 50) + 50);

        for (int i = 0; i <= randomStatGenerator; i++) {
            // generates a value from 1-3, the stats should be around even
            int randomAllocation = (int) ((Math.random()) * (4 - 1) + 1);

            switch (randomAllocation) {
                case 1:
                    health += 1;
                    break;
                case 2:
                    attack += 1;
                    break;
                case 3:
                    defense += 1;
                    break;
            }
        }
        entity.setHealth(health);
        entity.setAttack(attack);
        entity.setDefense(defense);
    }

    interface lambda {
        int getRoomNum(String dir);
    }
}