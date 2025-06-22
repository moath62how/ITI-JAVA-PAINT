/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paintappinjava;

import java.awt.event.ActionEvent;

/**
 *
 * @author moath
 */
public class GreenButton extends ColorsButtons {

    public GreenButton(String text) {
        super(text);
        setOpaque(true);
        setBorderPainted(false);
        this.addActionListener((ActionEvent e) -> {
            BodyCanvas.isErasingSelected = false;
            BodyCanvas.isGreenClicked = true;
            BodyCanvas.isRedClicked = false;
            BodyCanvas.isBlueClicked = false;
        });
    }
}
