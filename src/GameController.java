import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import org.json.simple.JSONObject;

public class GameController {
    private Player player;
    private PlayerView view;
    private HashMap<Integer, Room> rooms = new HashMap<>();
    private Scanner userInput;

	/*
	author: Joseph Ongchangco

	 */

    // sets up constructor, default constructor for main class
    public GameController(Player player, PlayerView view) {
        this.player = player;
        this.view = view;
        userInput = new Scanner(System.in);
    }

    // todo: main menu commands, separates the commands from the main menus 2 commands which are new/load game
    public void mainMenuCommands(){
        // show main menu
        view.showMenu();
        throw new UnsupportedOperationException();
    }


    // todo: commands
    // author: Joseph Ongchangco
    public void commands() {
        // show main menu
        view.showMenu();

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
                    // todo new game()
                    break;
                case "save":
                    // todo save command
                    break;
                case "lo":
                case "load":
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
                default:
                    view.invalidCommand();
                    break;

            }
        }
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
//        String itemName = userInput.nextLine();

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

    // todo: move player to another room
    public void moveToRoom() {
        throw new UnsupportedOperationException();
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
    public void saveGame() {
        throw new UnsupportedOperationException();
    }

    // todo: loads the game from a .txt file
    public void loadGame() {

        throw new UnsupportedOperationException();
    }

    // todo: starts a new game
    // load the default room values into the room object
    public void newGame() {
        



        throw new UnsupportedOperationException();
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
}