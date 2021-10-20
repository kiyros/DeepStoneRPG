public class Game {
	public static void main(String[] args) {
		GameController game = new GameController(new Player(), new PlayerView());
		game.commands();
	}
}