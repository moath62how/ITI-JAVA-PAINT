/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paintappinjava;

import CustomEvents.OpenImageActionListner;
import CustomEvents.SaveAction;
import CustomEvents.UndoButtonActionListner;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PaintAppInJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Paint in Java");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem saveMenuBtn = new JMenuItem("Save");
        JMenuItem openMenuBtn = new JMenuItem("Open");
        JButton undoBtn = new JButton("Undo");

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        BodyCanvas bodyPanel = new BodyCanvas(headerPanel);
        bodyPanel.setBorder(new LineBorder(Color.black));
        bodyPanel.setBackground(Color.WHITE);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        mainPanel.add(headerPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(bodyPanel, gbc);

        menu.add(saveMenuBtn);
        saveMenuBtn.addActionListener(new SaveAction(bodyPanel));
        openMenuBtn.addActionListener(new OpenImageActionListner(bodyPanel));
        undoBtn.addActionListener(new UndoButtonActionListner(bodyPanel));
        menu.add(openMenuBtn);
        menuBar.add(menu);
        menuBar.add(undoBtn);
        mainFrame.add(mainPanel);
        mainFrame.setJMenuBar(menuBar);
        mainFrame.setSize(800, 500);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
