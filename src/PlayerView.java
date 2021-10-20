public class PlayerView {

    // main menu Screen
    public void showMenu() {
        // Text art for the game, main menu Screen
        System.out.println(" ________  _______   _______   ________  ________  _________  ________  ________   _______           ________  ________  ________     \n" +
                "|\\   ___ \\|\\  ___ \\ |\\  ___ \\ |\\   __  \\|\\   ____\\|\\___   ___\\\\   __  \\|\\   ___  \\|\\  ___ \\         |\\   __  \\|\\   __  \\|\\   ____\\    \n" +
                "\\ \\  \\_|\\ \\ \\   __/|\\ \\   __/|\\ \\  \\|\\  \\ \\  \\___|\\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\\\ \\  \\ \\   __/|        \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\___|    \n" +
                " \\ \\  \\ \\\\ \\ \\  \\_|/_\\ \\  \\_|/_\\ \\   ____\\ \\_____  \\   \\ \\  \\ \\ \\  \\\\\\  \\ \\  \\\\ \\  \\ \\  \\_|/__       \\ \\   _  _\\ \\   ____\\ \\  \\  ___  \n" +
                "  \\ \\  \\_\\\\ \\ \\  \\_|\\ \\ \\  \\_|\\ \\ \\  \\___|\\|____|\\  \\   \\ \\  \\ \\ \\  \\\\\\  \\ \\  \\\\ \\  \\ \\  \\_|\\ \\       \\ \\  \\\\  \\\\ \\  \\___|\\ \\  \\|\\  \\ \n" +
                "   \\ \\_______\\ \\_______\\ \\_______\\ \\__\\     ____\\_\\  \\   \\ \\__\\ \\ \\_______\\ \\__\\\\ \\__\\ \\_______\\       \\ \\__\\\\ _\\\\ \\__\\    \\ \\_______\\\n" +
                "    \\|_______|\\|_______|\\|_______|\\|__|    |\\_________\\   \\|__|  \\|_______|\\|__| \\|__|\\|_______|        \\|__|\\|__|\\|__|     \\|_______|\n" +
                "                                           \\|_________|                                                                               ");

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

    // when the user exits the game, this message will pop up
    public void exitView(String playerName) {
        System.out.println("Thank you for playing our game " + playerName + " ~ Team Avengers");
    }

    // invalid command input, shows this message
    public void invalidCommand(){
        System.out.println("Invalid command try typing it correctly or type 'h' for help");
        System.out.println("What is your next command: ");
    }

}
