package application.Events;

import application.Board;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class MouseClickedEvent implements EventHandler<MouseEvent>
{
    @Override
    public void handle(MouseEvent mouseEvent)
    {
        if (mouseEvent.getButton() == MouseButton.SECONDARY)
        {
            MouseEnteredEvent.toggleSpray();
        }
        ((Rectangle)mouseEvent.getSource()).setFill(Board.currentColor);
    }
}
