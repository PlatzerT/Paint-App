package application;

import application.Color.ColorPalette;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public final int size = 400;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();
        Board board = new Board(size);
        group.getChildren().add(board);
        group.getChildren().add(board.getOverlay());
        primaryStage.setTitle("PAINT");
        primaryStage.setScene(new Scene(group));
        primaryStage.setOnCloseRequest(e ->
        {
            System.exit(0);
        });
        primaryStage.show();

        colorPickingStage();
    }

    public void colorPickingStage()
    {
        Stage stage = new Stage();
        ColorPalette colorPalette = new ColorPalette();
        stage.setScene(new Scene(colorPalette));
        stage.setTitle("COLOR PICKER");
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
