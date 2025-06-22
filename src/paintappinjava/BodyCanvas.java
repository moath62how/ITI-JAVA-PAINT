package paintappinjava;

import CustomDataStructures.Pair;
import CustomEvents.ClearAllAction;
import CustomEvents.LineShapeActionListener;
import CustomEvents.OvalShapeActionListener;
import CustomEvents.RectangleShapeActionListener;
import CustomEvents.StrokesShapeAction;
import DrawingElements.*;
import DrawingElements.Stroke;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.*;
import javax.swing.border.*;

public class BodyCanvas extends JPanel {

    public static Color getSelectedColor() {
        if (BodyCanvas.isRedClicked) {
            return (Color.red);
        } else if (BodyCanvas.isBlueClicked) {
            return (Color.BLUE);
        } else if (BodyCanvas.isGreenClicked) {
            return (Color.GREEN);
        } else if (BodyCanvas.isErasingSelected) {
            return (Color.WHITE);
        } else {
            return (Color.BLUE);
        }

    }

    public static boolean isBlueClicked;
    public static boolean isGreenClicked;
    public static boolean isRedClicked;
    public static boolean isErasingSelected;
    public static boolean isFilledSelected;

    public static MouseAdapter MouseListener;
    public static MouseMotionAdapter MouseMotionListener;

    public static BufferedImage backgroundImage;

    public static ArrayList<Line> lines = new ArrayList<>();
    public static int lineX1, lineY1, lineX2, lineY2;
    public static int lineCount = 0;

    public static ArrayList<DrawingElements.Oval> ovals = new ArrayList<>();
    public static int ovalX1, ovalY1, ovalX2, ovalY2;
    public static int ovalCount = 0;

    public static ArrayList<DrawingElements.Rectangle> rectangles = new ArrayList<>();
    public static int rectX1, rectY1, rectX2, rectY2;
    public static int rectangleCount = 0;

    public static ArrayList<Stroke> strokes = new ArrayList<>();
    public static ArrayList<Pair<Integer, Integer>> points = new ArrayList<>();
    public static ArrayList<Pair<Integer, Integer>> empty = new ArrayList<>();
    public static int StrokesCount = 0;

    public static Stack<String> traceStack = new Stack<>();

    BodyCanvas(JPanel headerPanel) {
        JPanel colorsSelectionpanel = new JPanel();

        RedButton redColorBtn = new RedButton("Red");
        GreenButton greenColorBtn = new GreenButton("Green");
        BlueButton blueColorBtn = new BlueButton("Blue");

        colorsSelectionpanel.add(redColorBtn);
        colorsSelectionpanel.add(blueColorBtn);
        colorsSelectionpanel.add(greenColorBtn);
        colorsSelectionpanel.setBorder(new LineBorder(Color.BLACK));

        lines.add(new DrawingElements.Line(0, 0, 0, 0, Color.WHITE));
        rectangles.add(new DrawingElements.Rectangle(0, 0, 0, 0, Color.WHITE, false));
        ovals.add(new DrawingElements.Oval(0, 0, 0, 0, Color.WHITE, false));
        empty.add(new Pair<>(0, 0));
        empty.add(new Pair<>(0, 0));
        strokes.add(new Stroke(new ArrayList<>(empty), Color.WHITE));

        JButton lineShapeBtn = new JButton("Line");
        JButton doodlingBtn = new JButton("Free Hand");
        JButton rectangleShapeBtn = new JButton("Rectangel");
        JButton ovalShapeBtn = new JButton("Oval");

        doodlingBtn.addActionListener(new StrokesShapeAction(this));
        lineShapeBtn.addActionListener(new LineShapeActionListener(this));
        ovalShapeBtn.addActionListener(new OvalShapeActionListener(this));
        rectangleShapeBtn.addActionListener(new RectangleShapeActionListener(this));

        JPanel shapesPanel = new JPanel();
        shapesPanel.add(doodlingBtn);
        shapesPanel.add(lineShapeBtn);
        shapesPanel.add(rectangleShapeBtn);
        shapesPanel.add(ovalShapeBtn);
        shapesPanel.setBorder(new LineBorder(Color.BLACK));

        JToolBar toolBar = new JToolBar("Tools");
        JButton clearButton = new JButton("clear all");
        EraserButton eraserButton = new EraserButton("Eraser");
        clearButton.addActionListener(new ClearAllAction(this));
        toolBar.add(eraserButton);
        toolBar.add(clearButton);
        toolBar.setBorder(new LineBorder(Color.BLACK));

        JPanel checkBoxGroup = new JPanel();
        checkBoxGroup.add(new FilledCheckBox("Filled"));

        headerPanel.add(shapesPanel);
        headerPanel.add(colorsSelectionpanel);
        headerPanel.add(toolBar);
        headerPanel.add(checkBoxGroup);
    }

    @Override

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
        }

        for (int i = 0; i < strokes.size(); i++) {
            Color c = strokes.get(i).color;
            g.setColor(c);
            for (int j = 0; j < strokes.get(i).arrayOfPoints.size() - 1; j++) {
                Integer x1 = strokes.get(i).arrayOfPoints.get(j).first;
                Integer y1 = strokes.get(i).arrayOfPoints.get(j).second;
                Integer x2 = strokes.get(i).arrayOfPoints.get(j + 1).first;
                Integer y2 = strokes.get(i).arrayOfPoints.get(j + 1).second;
                g.drawLine(x1, y1, x2, y2);
            }
        }

        for (int i = 0; i < rectangles.size(); i++) {
            g.setColor(rectangles.get(i).color);
            if (rectangles.get(i).isFilled) {
                g.fillRect(rectangles.get(i).x1, rectangles.get(i).y1, Math.abs(rectangles.get(i).x1 - rectangles.get(i).x2), Math.abs(rectangles.get(i).y1 - rectangles.get(i).y2));
            } else {
                g.drawRect(rectangles.get(i).x1, rectangles.get(i).y1, Math.abs(rectangles.get(i).x1 - rectangles.get(i).x2), Math.abs(rectangles.get(i).y1 - rectangles.get(i).y2));
            }

        }
        for (int i = 0; i < ovals.size(); i++) {
            g.setColor(ovals.get(i).color);
            if (ovals.get(i).isFilled) {
                g.fillOval(ovals.get(i).x1, ovals.get(i).y1, ovals.get(i).x2, ovals.get(i).y2);
            } else {
                g.drawOval(ovals.get(i).x1, ovals.get(i).y1, ovals.get(i).x2, ovals.get(i).y2);
            }
        }
        for (int i = 0; i < lines.size(); i++) {

            g.setColor(lines.get(i).color);
            g.drawLine(lines.get(i).x1, lines.get(i).y1, lines.get(i).x2, lines.get(i).y2);

        }

    }

}
