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
        System.out.println("Thank you for playing our game " + playerName + " ~ Team Avengers");
    }

    // invalid command input, shows this message
    public void invalidCommand(){
        System.out.println("Invalid command try typing it correctly or type 'h' for help");
    }

    // show players inventory
    public void showInventory(Player player){
        System.out.println(player.inventoryToString());
    }

}
