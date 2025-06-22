package CustomEvents;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import paintappinjava.BodyCanvas;

/**
 *
 * @author moath
 */
public class OpenImageActionListner implements ActionListener {

    private JPanel drawingPanel;

    public OpenImageActionListner(JPanel panel) {
        this.drawingPanel = panel;
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        FileNameExtensionFilter pngFilter = new FileNameExtensionFilter("PNG Images", "png");
        fileChooser.setFileFilter(pngFilter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                BufferedImage backgroundImage = ImageIO.read(selectedFile);

                Graphics g = drawingPanel.getGraphics();

                g.drawImage(backgroundImage, 0, 0, drawingPanel.getWidth(), drawingPanel.getHeight(), null);
                drawingPanel.repaint();
                BodyCanvas.backgroundImage = ImageIO.read(selectedFile);;
            } catch (Exception ex) {

                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to load image", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }
}
