/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paintappinjava;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author moath
 */
public abstract class ColorsButtons extends JButton {

    public ColorsButtons(String text) {
        super(text);
        setOpaque(true);
        setBorderPainted(false);
        this.addActionListener((ActionEvent e) -> {

        });
    }
}
