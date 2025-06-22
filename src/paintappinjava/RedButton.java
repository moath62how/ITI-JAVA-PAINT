package paintappinjava;

import java.awt.event.ActionEvent;

/**
 *
 * @author KING1
 */
class RedButton extends ColorsButtons {

    public RedButton(String text) {
        super(text);
        setOpaque(true);
        setBorderPainted(false);
        this.addActionListener((ActionEvent e) -> {
            BodyCanvas.isErasingSelected = false;
            BodyCanvas.isRedClicked = true;
            BodyCanvas.isBlueClicked = false;
            BodyCanvas.isGreenClicked = false;
        });
    }
}
