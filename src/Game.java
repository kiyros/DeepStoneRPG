import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Game {
	public static void main(String[] args) throws IOException, ParseException {
		GameController game = new GameController(new Player("",0,""), new PlayerView());
		game.commands();
	}
}