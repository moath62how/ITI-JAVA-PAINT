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
public class EraserButton extends ColorsButtons {

    public EraserButton(String text) {
        super(text);
        setOpaque(true);
        setBorderPainted(false);
        this.addActionListener((ActionEvent e) -> {
            BodyCanvas.isErasingSelected = true;
            BodyCanvas.isRedClicked = false;
            BodyCanvas.isBlueClicked = false;
            BodyCanvas.isGreenClicked = false;
        });
    }
}
