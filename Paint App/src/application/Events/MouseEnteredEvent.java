package application.Events;

import application.Board;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MouseEnteredEvent implements EventHandler<MouseEvent>
{
    private Group overlay;
    public static boolean isSprayOn;
    public MouseEnteredEvent(Group overlay)
    {
//        super(boxes);
        this.overlay = overlay;
        MouseEnteredEvent.isSprayOn = false;
    }

    private void createRectangles(int colIndex, int rowIndex)
    {
        Rectangle rectLeft = new Rectangle();
        rectLeft.setFill(Color.rgb(199, 199, 199));
        rectLeft.setOpacity(0.4);
        rectLeft.setWidth(colIndex * Board.cellSize + colIndex + 1);
        rectLeft.setHeight(Board.cellSize);
        rectLeft.setX(0);
        rectLeft.setY(rowIndex * Board.cellSize + rowIndex + 1);

        //Right rectangle
        Rectangle rectRight = new Rectangle();
        rectRight.setFill(Color.rgb(199, 199, 199));
        rectRight.setOpacity(0.4);
        rectRight.setWidth((14-colIndex) * Board.cellSize + 14 - colIndex + 1);
        rectRight.setHeight(Board.cellSize);
        rectRight.setX((colIndex+1) * Board.cellSize + colIndex + 1);
        rectRight.setY(rowIndex * Board.cellSize + rowIndex + 1);

        //Bottom rectangle
        Rectangle rectBottom = new Rectangle();
        rectBottom.setFill(Color.rgb(199, 199, 199));
        rectBottom.setOpacity(0.4);
        rectBottom.setWidth(Board.cellSize);
        rectBottom.setHeight((14-rowIndex+1) * Board.cellSize + 14 - rowIndex + 1);
        rectBottom.setX(colIndex * Board.cellSize + colIndex + 1);
        rectBottom.setY((rowIndex+1) * Board.cellSize + rowIndex + 1);

        //Top rectangle
        Rectangle rectTop = new Rectangle();
        rectTop.setFill(Color.rgb(199, 199, 199));
        rectTop.setOpacity(0.4);
        rectTop.setWidth(Board.cellSize);
        rectTop.setHeight(rowIndex * Board.cellSize + rowIndex + 1);
        rectTop.setX(colIndex * Board.cellSize + colIndex + 1);
        rectTop.setY(0);

        Platform.runLater(() -> overlay.getChildren().addAll(rectLeft, rectRight, rectBottom, rectTop));
    }

    public static void toggleSpray()
    {
        if (!MouseEnteredEvent.isSprayOn)
        {
            MouseEnteredEvent.isSprayOn = true;
        }
        else
        {
            MouseEnteredEvent.isSprayOn = false;
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent)
    {
        if (MouseEnteredEvent.isSprayOn)
        {
            ((Rectangle)mouseEvent.getSource()).setFill(Board.currentColor);

        }
        Rectangle box = ((Rectangle)mouseEvent.getSource());
        int colIndex = GridPane.getColumnIndex(box);
        int rowIndex = GridPane.getRowIndex(box);
        createRectangles(colIndex, rowIndex);

    }
}
