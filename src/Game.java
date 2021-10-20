public class Game {

	// todo: run main code here
	public static void main(String[] args) {
		Player player = new Player();
		PlayerView view = new PlayerView();
		GameController game = new GameController(player, view);

		game.showMainMenu();

		// todo: room initialization for loading game and making a starting a new game

	}
}