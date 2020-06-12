package application;

import application.Events.MouseClickedEvent;
import application.Events.MouseExitEvent;
import application.Events.MouseEnteredEvent;
import javafx.scene.Group;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

import javafx.scene.shape.*;

public class Board extends GridPane
{
    public static Color currentColor;
    private Group overlay;
    private final int CELLS = 14;
    public static double cellSize;
    public static double GAP = 1;
    private Rectangle[][] boxes;

    Board(int size)
    {
        setPrefSize(size, size);
        setHgap(Board.GAP);
        setVgap(Board.GAP);
        setStyle(
                "-fx-background-color: black;" +
                "-fx-border-color: black;"
        );
        Board.cellSize = (size / CELLS) + GAP * 4;
        boxes = new Rectangle[CELLS][CELLS];
        overlay = new Group();
        Board.currentColor = Color.GREEN;
        createGrid();
        initRectangles();
        setupListeners();
        fillGrid();
    }

    private void setupListeners()
    {
        for (int i = 0; i < CELLS; i++)
        {
            for (int j = 0; j < CELLS; j++)
            {
                boxes[i][j].setOnMouseClicked(new MouseClickedEvent());
                boxes[i][j].setOnMouseEntered(new MouseEnteredEvent(overlay));
                boxes[i][j].setOnMouseExited(new MouseExitEvent(overlay));
            }
        }
    }

    private void initRectangles()
    {
        for (int i = 0; i < CELLS; i++)
        {
            for (int j = 0; j < CELLS; j++)
            {
                boxes[i][j] = new Rectangle();
                boxes[i][j].setFill(Color.WHITE);
                boxes[i][j].setHeight(Board.cellSize);
                boxes[i][j].setWidth(Board.cellSize);
            }
        }
    }

    private void fillGrid()
    {
        for (int i = 0; i < CELLS; i++)
        {
            for (int j = 0; j < CELLS; j++)
            {
                add(boxes[i][j], j, i);
            }
        }
    }

    private void createGrid()
    {
        //Rows and columns
        for (int i = 0; i < CELLS; i++)
        {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / CELLS);
            getRowConstraints().add(row);

            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0 / CELLS);
            getColumnConstraints().add(col);
        }
    }

    public Group getOverlay()
    {
        return overlay;
    }
}
