package application.Events;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;

public class MouseExitEvent implements EventHandler<MouseEvent>
{
    private Group overlay;
    public MouseExitEvent(Group overlay)
    {
        this.overlay = overlay;
    }

    @Override
    public void handle(MouseEvent mouseEvent)
    {
        overlay.getChildren().clear();
    }
}
