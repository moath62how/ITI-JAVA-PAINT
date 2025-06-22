package paintappinjava;

import javax.swing.JCheckBox;

public class FilledCheckBox extends JCheckBox {

    public FilledCheckBox(String text) {
        super(text);

        addActionListener(e -> {
            BodyCanvas.isFilledSelected = isSelected();
        });
    }
}
