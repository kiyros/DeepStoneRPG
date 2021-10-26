import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/*
put this in run configurations to work
 --module-path "\path\to\javafx-sdk-15.0.1\lib" --add-modules javafx.controls,javafx.fxml
*/
public class JavaFxAssignment extends Application {
    public void start(Stage primaryStage) {
        //showgridpane_showgridpaneexample
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // Place nodes in the pane
        pane.add(new Label("First Name"), 0, 0);
        pane.add(new TextField(), 1, 0);
        pane.add(new Label("Last Name"), 0, 1);
        pane.add(new TextField(), 1, 1);
        pane.add(new Label("Email Address"), 0, 2);
        pane.add(new TextField(), 1, 2);

        pane.add(new Button("Add To Mailing List"), 2, 3);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Mailing List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    ;

    public static void main(String[] args) {
        launch(args);
    }

}