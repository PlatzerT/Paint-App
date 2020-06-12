package application.Color;

import application.Board;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ColorPalette extends VBox implements EventHandler<MouseEvent>
{
    private ArrayList<ColorRectangle> colors;
    private final double COLOR_RECT_HEIGHT = 50;

    public ColorPalette()
    {
        initColors();
        setupListeners();
        createVBox();
        fillVBox();
    }

    private void createVBox()
    {
        setSpacing(15);
        setPadding(new Insets(50));
    }

    private void setupListeners()
    {
        for (int i = 0; i < colors.size(); i++)
        {
            colors.get(i).setOnMouseClicked(this);
        }
    }

    private void initColors()
    {
        colors = new ArrayList<>();
        colors.add(new ColorRectangle(Color.RED, COLOR_RECT_HEIGHT));
        colors.add(new ColorRectangle(Color.BLUE, COLOR_RECT_HEIGHT));
        colors.add(new ColorRectangle(Color.GREEN, COLOR_RECT_HEIGHT));
        colors.add(new ColorRectangle(Color.YELLOW, COLOR_RECT_HEIGHT));
    }

    private void fillVBox()
    {
        for (int i = 0; i < colors.size(); i++)
        {
            getChildren().add(colors.get(i));
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent)
    {
        Board.currentColor = ((ColorRectangle)mouseEvent.getSource()).getColor();
    }
}
