package application.Color;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class ColorRectangle extends Rectangle
{
    private Color color;

    ColorRectangle(Color color, double size)
    {
        this.color = color;
        setFill(color);
        setHeight(size);
        setWidth(size);
    }

    public Color getColor()
    {
        return color;
    }
}
