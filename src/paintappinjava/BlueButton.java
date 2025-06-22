package paintappinjava;

import java.awt.event.ActionEvent;

/**
 *
 * @author KING1
 */
class BlueButton extends ColorsButtons {

    public BlueButton(String text) {
        super(text);
        setOpaque(true);
        setBorderPainted(false);
        this.addActionListener((ActionEvent e) -> {
            BodyCanvas.isErasingSelected = false;
            BodyCanvas.isBlueClicked = true;
            BodyCanvas.isGreenClicked = false;
            BodyCanvas.isRedClicked = false;
        });
    }
}
