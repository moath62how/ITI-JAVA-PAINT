package CustomEvents;

import DrawingElements.Line;
import java.awt.event.*;
import java.util.ArrayList;
import paintappinjava.BodyCanvas;

public class LineShapeActionListener implements ActionListener {

    ArrayList<Line> lines;
    int x1, y1, x2, y2;
    BodyCanvas bc;

    public LineShapeActionListener(BodyCanvas bc) {
        this.lines = BodyCanvas.lines;
        this.bc = bc;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (BodyCanvas.MouseListener != null) {
            bc.removeMouseListener(BodyCanvas.MouseListener);
            bc.removeMouseMotionListener(BodyCanvas.MouseMotionListener);
        }
        BodyCanvas.MouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                lines.add(new Line(x1, y1, x2, y2, BodyCanvas.getSelectedColor()));
                BodyCanvas.lineCount++;
                BodyCanvas.traceStack.add("Line");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();

                bc.repaint();
            }
        };

        BodyCanvas.MouseMotionListener = new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                if (BodyCanvas.lineCount > lines.size()) {
                    BodyCanvas.lineCount = 0;
                }
                lines.set(BodyCanvas.lineCount, new Line(x1, y1, x2, y2, BodyCanvas.getSelectedColor()));
                bc.repaint();
            }
        };

        bc.addMouseListener(BodyCanvas.MouseListener);
        bc.addMouseMotionListener(BodyCanvas.MouseMotionListener);
    }

}
