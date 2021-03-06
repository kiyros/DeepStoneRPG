public class PlayerView {

    // main menu Screen
    public void showMenu() {
        // Text art for the game, main menu Screen
        System.out.println("\n" +
                "██████╗░███████╗███████╗██████╗░░██████╗████████╗░█████╗░███╗░░██╗███████╗   ██████╗░██████╗░░██████╗░\n" +
                "██╔══██╗██╔════╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝██╔══██╗████╗░██║██╔════╝   ██╔══██╗██╔══██╗██╔════╝░\n" +
                "██║░░██║█████╗░░█████╗░░██████╔╝╚█████╗░░░░██║░░░██║░░██║██╔██╗██║█████╗░░   ██████╔╝██████╔╝██║░░██╗░\n" +
                "██║░░██║██╔══╝░░██╔══╝░░██╔═══╝░░╚═══██╗░░░██║░░░██║░░██║██║╚████║██╔══╝░░   ██╔══██╗██╔═══╝░██║░░╚██╗\n" +
                "██████╔╝███████╗███████╗██║░░░░░██████╔╝░░░██║░░░╚█████╔╝██║░╚███║███████╗   ██║░░██║██║░░░░░╚██████╔╝\n" +
                "╚═════╝░╚══════╝╚══════╝╚═╝░░░░░╚═════╝░░░░╚═╝░░░░╚════╝░╚═╝░░╚══╝╚══════╝   ╚═╝░░╚═╝╚═╝░░░░░░╚═════╝░");

        System.out.println("---------------------------->>>>");
        System.out.println("-- New game --");
        System.out.println("-- Load game --");
        System.out.println("---------------------------->>>>");
    }

    // nextCommand
    // tells the user that the program is waiting for the next command
    public void nextCommand() {
        System.out.println("Type in [h]elp if you don't know what to do");
        System.out.println("What is your next command: ");
    }

    public void showRoom(Room room){
        System.out.println(room);
    }

    // when the user exits the game, this message will pop up
    public void exitView(String playerName) {
        System.out.println("\n" +
                "████████╗██╗░░██╗░█████╗░███╗░░██╗██╗░░██╗░██████╗  ███████╗░█████╗░██████╗░\n" +
                "╚══██╔══╝██║░░██║██╔══██╗████╗░██║██║░██╔╝██╔════╝  ██╔════╝██╔══██╗██╔══██╗\n" +
                "░░░██║░░░███████║███████║██╔██╗██║█████═╝░╚█████╗░  █████╗░░██║░░██║██████╔╝\n" +
                "░░░██║░░░██╔══██║██╔══██║██║╚████║██╔═██╗░░╚═══██╗  ██╔══╝░░██║░░██║██╔══██╗\n" +
                "░░░██║░░░██║░░██║██║░░██║██║░╚███║██║░╚██╗██████╔╝  ██║░░░░░╚█████╔╝██║░░██║\n" +
                "░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚═╝╚═════╝░  ╚═╝░░░░░░╚════╝░╚═╝░░╚═╝\n" +
                "\n" +
                "██████╗░██╗░░░░░░█████╗░██╗░░░██╗██╗███╗░░██╗░██████╗░\n" +
                "██╔══██╗██║░░░░░██╔══██╗╚██╗░██╔╝██║████╗░██║██╔════╝░\n" +
                "██████╔╝██║░░░░░███████║░╚████╔╝░██║██╔██╗██║██║░░██╗░\n" +
                "██╔═══╝░██║░░░░░██╔══██║░░╚██╔╝░░██║██║╚████║██║░░╚██╗\n" +
                "██║░░░░░███████╗██║░░██║░░░██║░░░██║██║░╚███║╚██████╔╝\n" +
                "╚═╝░░░░░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝╚═╝░░╚══╝░╚═════╝░");
        System.out.println("Thank you for playing our game " + playerName + " ~ Team Avengers");
    }

    // invalid command input, shows this message
    public void error(String errorMessage){
        System.out.println("[error]: \n"+ errorMessage);
    }

    // invalid command input, shows this message
    public void notifier(String action){
        System.out.println(action);
    }


    // locked room, display to the user,
    public void lockedRoom(){
        System.out.println("The room is locked, you cannot enter/ maybe solve a [puzzle] or defeat a [monster]");
    }

    // help command. prints to console only
    public void getHelp() { //by: Jawwad Qureshi
        System.out.println("\n ----- HELP -----" +
                "\n : n or new or new game to begin a new game" +
                "\n : l or lo or load or load game to load a game" +
                "\n : h or help to get help" +
                "\n : save to save the game" +
                "\n : x or exit to exit the game" +
                "\n : ins or inspect to inspect an item in the room or inventory" +
                "\n : exp or explore or look or look around to explore the room" +
                "\n : w or west to travel west" +
                "\n : e or east to travel east" +
                "\n : n or north to travel north" +
                "\n : s or south to travel south" +
                "\n : p or pickup to pick up an item" +
                "\n : health or hp to see current health" +
                "\n : stats to see all player stats" +
                "\n : engage to begin fight with a monster in the room" +
                "\n : end or close to end the game" +
                "\n : equip to equip items" +
                "\n : unequip to remove equipped items" +
                "\n " +
                "\n ONLY DURING FIGHT SEQUENCE" +
                "\n : fight to do an attack on the monster" +
                "\n : back to leave the fight and disengage" +
                "\n : inspect or inspect monster to get the monster's stats\n" +
                "---------------------------------\n");
    }

    // show players inventory
    public void showInventory(Player player){
        System.out.println(player.inventoryToString());
    }

    //shows equipment inventory - Jawwad Qureshi
    public void showEquipment(Player player) { System.out.println(player.equipmentToString());}
}
