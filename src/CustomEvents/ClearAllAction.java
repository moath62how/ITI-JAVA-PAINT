package CustomEvents;

import CustomDataStructures.Pair;
import DrawingElements.Stroke;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import paintappinjava.BodyCanvas;
import static paintappinjava.BodyCanvas.empty;
import static paintappinjava.BodyCanvas.lines;
import static paintappinjava.BodyCanvas.ovals;
import static paintappinjava.BodyCanvas.rectangles;
import static paintappinjava.BodyCanvas.strokes;

public class ClearAllAction implements ActionListener {

    BodyCanvas panel;

    public ClearAllAction(BodyCanvas panel) {

        this.panel = panel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.removeAll();
        BodyCanvas.strokes.clear();
        BodyCanvas.lines.clear();
        BodyCanvas.rectangles.clear();
        BodyCanvas.ovals.clear();
        empty.clear();
        BodyCanvas.backgroundImage = null;
        BodyCanvas.lineCount = 0;
        BodyCanvas.rectangleCount = 0;
        BodyCanvas.ovalCount = 0;
        BodyCanvas.StrokesCount = 0;

        lines.add(new DrawingElements.Line(0, 0, 0, 0, Color.WHITE));
        rectangles.add(new DrawingElements.Rectangle(0, 0, 0, 0, Color.WHITE, false));
        ovals.add(new DrawingElements.Oval(0, 0, 0, 0, Color.WHITE, false));
        empty.add(new Pair<>(0, 0));
        empty.add(new Pair<>(0, 0));
        strokes.add(new Stroke(new ArrayList<>(empty), Color.WHITE));

        panel.repaint();
    }

}
