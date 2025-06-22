package CustomEvents;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author KING1
 */
public class SaveAction implements ActionListener {

    private JPanel drawingPanel;

    public SaveAction(JPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            BufferedImage image = new BufferedImage(drawingPanel.getWidth(), drawingPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g = image.createGraphics();
            drawingPanel.paint(g);
            g.dispose();

            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                ImageIO.write(image, "png", file);
                JOptionPane.showMessageDialog(null, "Image saved successfully!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
