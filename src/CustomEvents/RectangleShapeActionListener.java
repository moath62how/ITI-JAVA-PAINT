/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomEvents;

import DrawingElements.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import paintappinjava.BodyCanvas;

/**
 *
 * @author al_rehab
 */
public class RectangleShapeActionListener implements ActionListener {

    ArrayList<Rectangle> rectangles;
    int rectX1, rectY1, rectX2, rectY2;
    BodyCanvas bc;

    public RectangleShapeActionListener(BodyCanvas bc) {
        this.rectangles = BodyCanvas.rectangles;
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
                rectX1 = e.getX();
                rectY1 = e.getY();
                rectangles.add(new Rectangle(rectX1, rectY1, rectX2, rectY2, BodyCanvas.getSelectedColor(), BodyCanvas.isFilledSelected));
                BodyCanvas.traceStack.add("Rectangle");
                BodyCanvas.rectangleCount++;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                rectX2 = e.getX();
                rectY2 = e.getY();

                bc.repaint();
            }
        };
        BodyCanvas.MouseMotionListener = new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                rectX2 = e.getX();
                rectY2 = e.getY();
                if (BodyCanvas.rectangleCount > rectangles.size()) {
                    BodyCanvas.rectangleCount = 0;
                }
                rectangles.set(BodyCanvas.rectangleCount, new Rectangle(rectX1, rectY1, rectX2, rectY2, BodyCanvas.getSelectedColor(), BodyCanvas.isFilledSelected));
                bc.repaint();
            }
        };
        bc.addMouseListener(BodyCanvas.MouseListener);
        bc.addMouseMotionListener(BodyCanvas.MouseMotionListener);
    }
}
