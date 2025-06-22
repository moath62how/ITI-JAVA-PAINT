/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DrawingElements;

import java.awt.*;

public class Rectangle {

    public boolean isFilled;
    public int x1, y1, x2, y2;
    public Color color;

    public Rectangle(int x1, int y1, int x2, int y2, Color color, boolean isFilled) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.isFilled = isFilled;
    }

}
