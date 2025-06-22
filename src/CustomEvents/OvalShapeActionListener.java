/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomEvents;

import DrawingElements.*;
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
public class OvalShapeActionListener implements ActionListener {

    ArrayList<Oval> ovals;
    int ovalX1, ovalY1, ovalX2, ovalY2;
    BodyCanvas bc;

    public OvalShapeActionListener(BodyCanvas bc) {
        this.ovals = BodyCanvas.ovals;
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
                ovals.add(new Oval(ovalX1, ovalY1, ovalX2, ovalY2, BodyCanvas.getSelectedColor(), BodyCanvas.isFilledSelected));
                BodyCanvas.ovalCount++;
                BodyCanvas.traceStack.add("Oval");
                ovalX1 = e.getX();
                ovalY1 = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ovalX2 = e.getX();
                ovalY2 = e.getY();

                bc.repaint();
            }
        };
        BodyCanvas.MouseMotionListener = new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                ovalX2 = e.getX();
                ovalY2 = e.getY();
                if (BodyCanvas.ovalCount > ovals.size()) {
                    BodyCanvas.ovalCount = 0;
                }
                ovals.set(BodyCanvas.ovalCount, new Oval(ovalX1, ovalY1, ovalX2, ovalY2, BodyCanvas.getSelectedColor(), BodyCanvas.isFilledSelected));
                bc.repaint();
            }
        };

        bc.addMouseListener(BodyCanvas.MouseListener);
        bc.addMouseMotionListener(BodyCanvas.MouseMotionListener);

    }
}
