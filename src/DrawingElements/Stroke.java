/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DrawingElements;

import CustomDataStructures.Pair;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author moath
 */
public class Stroke {

    public ArrayList<Pair<Integer, Integer>> arrayOfPoints;
    public Color color;

    public Stroke(ArrayList<Pair<Integer, Integer>> arrayOfPoints, Color color) {
        this.arrayOfPoints = arrayOfPoints;
        this.color = color;
    }
}
