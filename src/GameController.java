import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class GameController {
    private Player player = new Player();
    private final PlayerView view;
    private HashMap<Integer, Room> rooms = new HashMap<>();
    private final Scanner userInput;

	/*
	author: Joseph Ongchangco

	 */

    // sets up constructor, default constructor for main class
    public GameController(Player player, PlayerView view) {
        this.player = player;
        this.view = view;
        userInput = new Scanner(System.in);
    }

    // todo: commands
    // author: Joseph Ongchangco
    public void commands() throws IOException, ParseException {
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
                    // todo: help command
                    break;
                case "new":
                case "new game":
                    newGame();
                    // todo new game()
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

    // todo: returns the player's inventory
    public void getPlayerInventory() {
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

    // todo: uses an item, most likely a consumable
    public void useItem() {
        throw new UnsupportedOperationException();
    }

    // todo: drops an item from the players inventory
    public void dropItem() {
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

        if (player.getInventory().toString().contains(itemName)) {
            for (Item playerItem : player.getInventory()) {
                if (playerItem.getName().equals(itemName)) {
                    view.notifier(playerItem.toString());
                    view.notifier(playerItem.getDescription());
                }
            }
        } else {
            System.out.println("nah");
        }


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

        // set room to visited as the player is leaving the room
        rooms.get(player.getCurrentRoom()).setVisited(true);

        switch (direction) {
            case "west":
                player.setCurrentRoom(rooms.get(player.getCurrentRoom()).getExits().get("west"));
                break;
            case "east":
                player.setCurrentRoom(rooms.get(player.getCurrentRoom()).getExits().get("east"));
                break;
            case "south":
                player.setCurrentRoom(rooms.get(player.getCurrentRoom()).getExits().get("south"));
                break;
            case "north":
                player.setCurrentRoom(rooms.get(player.getCurrentRoom()).getExits().get("north"));
                break;
        }
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
        List<Object> roomArray = List.of(rooms.values().toArray());

        mapper.writeValue(Paths.get("saveFiles/roomData.json").toFile(), roomArray);

    }

    // todo: loads the game from a .txt file
    public void loadGame() {
        loadSave("saveFiles/userData.json", "saveFiles/roomData.json");
    }

    // todo: starts a new game
    // load the default room values into the room object
    public void newGame() throws IOException {
        newJsonToRoom("rooms.json", "items.json", "puzzles.json");
    }

    // todo: items, puzzles, monsters
    // turns the JSON files and reads the information into game Objects and sets the gameController's room to this
    public void newJsonToRoom(String roomPathName, String itemPathName, String puzzlePathName) throws IOException {
        HashMap<Integer, Room> rooms = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        // rooms
        File roomJSON = new File(roomPathName);

        // items
        File itemJSON = new File(itemPathName);

        // puzzles
        File puzzleJson = new File(puzzlePathName);

        // monsters

        JsonNode rootRooms = mapper.readTree(roomJSON);
        JsonNode rootItems = mapper.readTree(itemJSON);
        JsonNode rootPuzzles = mapper.readTree(puzzleJson);

        // iterator ; roomJSON to room object(s)
        for (JsonNode roomJson : rootRooms) {
            // temporary room
            Room temp = new Room();

            // assign values to temp room object
            temp.setRoomID(roomJson.get("roomID").asInt());
            temp.setDescription(roomJson.get("description").toString().replace("\"", ""));

            // room exits
            JsonNode exits = roomJson.get("exits");
            for (JsonNode exitIter : exits) {
                if (exitIter.has("west")) {
                    temp.addExits("west", exitIter.get("west").asInt());
                }
                if (exitIter.has("north")) {
                    temp.addExits("north", exitIter.get("north").asInt());
                }
                if (exitIter.has("east")) {
                    temp.addExits("east", exitIter.get("east").asInt());
                }
                if (exitIter.has("south")) {
                    temp.addExits("south", exitIter.get("south").asInt());
                }
            }

            // locked rooms
            if (roomJson.get("locked") != null) {
                ArrayList<Integer> tempLocked = new ArrayList<>();
                for (JsonNode locked : roomJson.get("locked")) {
                    tempLocked.add(locked.asInt());
                }
                // add locked rooms to temporary room object
                temp.setLockedExits(tempLocked);
            }

            // add the temporary room object to Map
            rooms.put(temp.getRoomID(), temp);

            // todo: monsterJSON to item object(s)
        }


        // todo: itemJSON to item object(s)
        for (JsonNode itemJson : rootItems) {
            Item item = new MiscItem();

            // basic item attributes
            item.setName(itemJson.get("name").toString().replace("\"", ""));
            item.setDescription(itemJson.get("description").toString().replace("\"", ""));
            item.setType(itemJson.get("type").toString());


            // cast to proper item type
            if (itemJson.get("type").toString().equals("weapon")) {
                item = new WeaponItem();
                ((WeaponItem) item).setDamage(itemJson.get("damage").asInt());
            } else if (itemJson.get("type").toString().equals("equip")) {
                item = new EquipItem();
            } else if (itemJson.get("type").toString().equals("misc")) {
                item = new MiscItem();
            } else if (itemJson.get("type").toString().equals("puzzle")) {
                item = new PuzzleItem();
            }

            if (itemJson.get("room") != null) {
                rooms.get(itemJson.get("room").asInt()).addItems(item);
            }


        }


        // set the game room to the generated Map the method made from JSON values
        this.rooms = rooms;
        System.out.println(rooms.get(player.getCurrentRoom()));
    }

    // todo: loadSave
    // loads save
    public void loadSave(String playerPath, String roomPaths) {
        ObjectMapper mapper = new ObjectMapper();
    }

    /*
     todo: solve puzzle, when user types in "solve puzzle", this method should automatically grab the item remove it and set puzzle in the room to solved
     */
    public void solvePuzzle() {
        throw new UnsupportedOperationException();
    }

    // todo: gets puzzle object from where a player current is
    public void getPuzzle() {
        throw new UnsupportedOperationException();
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
}