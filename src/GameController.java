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
                case "health":
                case "hp":
                    getPlayerHealth();
                    break;
                case "stats":
                    getStats();
                    break;
                case "engage":
                    fight();
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

    public void fight(){
        view.notifier("\nEntering fight with monster:\n");
        if (rooms.get(player.getCurrentRoom()).getMonsters().size() < 1) {
            view.notifier("No monsters found in the room \n\nExiting fight\n");
            return;
        }
        else {
            view.notifier("You've encountered " + rooms.get(player.getCurrentRoom()).getMonsters().get(0).getName());
            view.notifier("\nWhat do you do?");
            String fightCommand = userInput.nextLine().toLowerCase();
            while (player.getHealth() >= 0 && !(fightCommand.equalsIgnoreCase("back")) &&
                     rooms.get(player.getCurrentRoom()).getMonsters().get(0).getHealth() >= 0) {
                switch (fightCommand) {
                    case "fight":
                        view.notifier("You attack the monster!");
                        rooms.get(player.getCurrentRoom()).getMonsters().get(0).setHealth(rooms.get(player.getCurrentRoom()).getMonsters().get(0).getHealth() - player.getAttack());
                        view.notifier("Monsters health after the attack: " + rooms.get(player.getCurrentRoom()).getMonsters().get(0).getHealth());
                        if (rooms.get(player.getCurrentRoom()).getMonsters().get(0).getHealth() <= 0) {
                            break;
                        }
                        view.notifier("The monster retaliates!");
                        player.setHealth(player.getHealth() - rooms.get(player.getCurrentRoom()).getMonsters().get(0).getAttack());
                        view.notifier("Your current health: " + player.getHealth());
                        break;
                    case "back":
                        break;
                    case "health":
                    case "hp":
                        getPlayerHealth();
                        break;
                    case "stats":
                        getStats();
                        break;
                    case "h":
                    case "help":
                        view.getHelp();
                        break;

                }
                if (player.getHealth() <= 0) {
                    break;
                }

                if (rooms.get(player.getCurrentRoom()).getMonsters().get(0).getHealth() <= 0) {
                    break;
                }

                view.notifier("What do you do?");
                fightCommand = userInput.nextLine().toLowerCase();
            }
            if (player.getHealth() <= 0) {
                view.notifier("You cannot go on any further! Your health has dropped below 0.");
            }
            else if (rooms.get(player.getCurrentRoom()).getMonsters().get(0).getHealth() <= 0) {
                view.notifier("The monster has been defeated!\n");
                rooms.get(player.getCurrentRoom()).getMonsters().remove(0);
            }
        }
        view.notifier("\nExiting fight with monster:\n");
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
        view.notifier(player.getHealth() + " health points");
    }

    // displays current health, inventory, equipped items, attack damage, and defense stats
    public void getStats(){
        view.notifier("Current Stats: \n" + "- " + player.getHealth() + " health points \n- " + player.getInventory() + " in my inventory \n- " +
                player.getEquippedItem() + " weapon equipped \n- " + player.getAttack() + " attack damage \n- " + player.getDefense() + " defense");
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

        // display to user
        view.showRoom(rooms.get(player.getCurrentRoom()));

        // set room to visited as the player is leaving the room
        rooms.get(player.getCurrentRoom()).setVisited(true);
    }


    // shows ALL the information from the room: items, puzzle, title, monsters, room number.
    public void exploreRoom() {
        view.showRoom(rooms.get(player.getCurrentRoom()));
    }

    // todo: gets the player name
    public String getPlayerName() {
       return "My name is " + player.getName();
    }

    // todo: sets the player name
    public void SetPlayerName() {
        throw new UnsupportedOperationException();
    }

    // N/A
    public void updateView() {
        throw new UnsupportedOperationException();
    }

    // saves game
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
        player.setCurrentRoom(7);
        newJsonToRoom("rooms.json", "items.json", "puzzles.json", "monsters.json");

        // show the room that the player spawns in
        exploreRoom();
    }

    // todo: puzzles, monsters
    // turns the JSON files and reads the information into game Objects and sets the gameController's room to this
    // author: Joseph Ongchangco
    public void newJsonToRoom(String roomPathName, String itemPathName, String puzzlePathName, String monsterPathName) throws IOException {
        HashMap<Integer, Room> tempRoomsHashMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        // read files in
        JsonNode rootRooms = mapper.readTree(new File(roomPathName));
        JsonNode rootItems = mapper.readTree(new File(itemPathName));
        JsonNode rootPuzzles = mapper.readTree(new File(puzzlePathName));
        JsonNode rootMonster = mapper.readTree(new File(monsterPathName));

        // rooms
        for (JsonNode roomJson : rootRooms) {
            // temporary room
            try {
                Room temp = mapper.treeToValue(roomJson, Room.class);
                tempRoomsHashMap.put(temp.getRoomID(), temp);
            } catch (Exception ignored) {
            }
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

            try {
                tempRoomsHashMap.get(roomPlacement).getMonsters().add(tempMonster);
            } catch (Exception ignored) {
            }
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
            } else if (itemJson.get("type").toString().replace("\"", "").equals("misc")) {
                item = mapper.treeToValue(itemJson, PuzzleItem.class);
            }

            if (item.getRoomNumber() != null) {
                tempRoomsHashMap.get(item.getRoomNumber()).addItems(item);
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
    public void solvePuzzle() throws IOException {
        view.notifier("What item would you like to use to solve this puzzle? ");
        view.showInventory(player);
        String command = userInput.nextLine();
        String returnStatement = player.use(command);
        int currentRoom = player.getCurrentRoom();
        if (!returnStatement.equals("none") && getPuzzle().getSolution().equals(returnStatement)) {
            getPuzzle().setSolved(true);
            Item thing = fetchJsonToItem(getPuzzle().getItemReward());
            // rooms.get(currentRoom).getItems().add(thing);

            if (getPuzzle().getItemReward() != null) {
                rooms.get(currentRoom).getItems().add(thing);
                view.notifier("Reward Items dropped in dropped in room");

            }
            if (!rooms.get(currentRoom).getLockedExits().isEmpty()) {
                rooms.get(currentRoom).getLockedExits().clear();
                getPuzzle().getRoomUnlock().remove(0);
            }
        } else if (command.equals("leave")) {
            view.notifier("You have left the puzzle");
        } else {
            view.notifier("This item is not the correct answer. Or is not in your inventory ");
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
