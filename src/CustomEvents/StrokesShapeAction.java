package CustomEvents;

import CustomDataStructures.Pair;
import DrawingElements.Stroke;
import java.awt.event.*;
import java.util.ArrayList;
import paintappinjava.BodyCanvas;
import static paintappinjava.BodyCanvas.MouseListener;
import static paintappinjava.BodyCanvas.MouseMotionListener;
import static paintappinjava.BodyCanvas.getSelectedColor;

public class StrokesShapeAction implements ActionListener {

    ArrayList<Stroke> Strokes = new ArrayList<>();
    ArrayList<Pair<Integer, Integer>> Points = new ArrayList<>();
    BodyCanvas bc;

    public StrokesShapeAction(BodyCanvas bc) {
        this.Strokes = BodyCanvas.strokes;
        this.Points = BodyCanvas.points;
        this.bc = bc;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (BodyCanvas.MouseListener != null) {
            bc.removeMouseListener(MouseListener);
            bc.removeMouseMotionListener(MouseMotionListener);
        }

        MouseListener = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                Points.add(new Pair<>(e.getX(), e.getY()));
                Strokes.add(new Stroke(new ArrayList<>(Points), getSelectedColor()));
                BodyCanvas.traceStack.add("Stroke");
                BodyCanvas.StrokesCount++;
                bc.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                Points.clear();
                bc.repaint();

            }
        };

        MouseMotionListener = new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                Points.add(new Pair<>(e.getX(), e.getY()));
                if (BodyCanvas.StrokesCount > Strokes.size()) {
                    BodyCanvas.StrokesCount = 0;
                }
                Strokes.set(BodyCanvas.StrokesCount, new Stroke(new ArrayList<>(Points), BodyCanvas.getSelectedColor()
                ));
                bc.repaint();
            }
        };

        bc.addMouseListener(MouseListener);

        bc.addMouseMotionListener(MouseMotionListener);
    }

}
