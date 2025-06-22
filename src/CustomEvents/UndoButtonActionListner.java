package CustomEvents;

import java.awt.event.*;
import paintappinjava.BodyCanvas;

public class UndoButtonActionListner implements ActionListener {

    BodyCanvas bc;

    public UndoButtonActionListner(BodyCanvas bc) {
        this.bc = bc;
        bc.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (BodyCanvas.traceStack.empty()) {
            return;
        }
        String str = BodyCanvas.traceStack.pop();
        switch (str) {
            case "Stroke" -> {
                BodyCanvas.strokes.remove(BodyCanvas.strokes.size() - 1);
                BodyCanvas.StrokesCount--;
                bc.repaint();

            }
            case "Rectangle" -> {
                BodyCanvas.rectangles.remove(BodyCanvas.rectangles.size() - 1);
                BodyCanvas.rectangleCount--;
                bc.repaint();

            }
            case "Oval" -> {
                BodyCanvas.ovals.remove(BodyCanvas.ovals.size() - 1);
                BodyCanvas.ovalCount--;
                bc.repaint();

            }
            case "Line" -> {
                BodyCanvas.lines.remove(BodyCanvas.lines.size() - 1);
                BodyCanvas.lineCount--;
                bc.repaint();

            }
        }
        bc.repaint();
    }
}
