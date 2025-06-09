/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller1.game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.OptionPaneUI;

/**
 *
 * @author cxz03
 */
public class GameNotification extends JDialog {
    
    private JLabel label[];
    private JLabel icon;
    private JButton button;
    
    public GameNotification(String[] msgs) {
        // Set up the message and put it on a JPanel
        label = new JLabel[msgs.length];
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        for (int i = 0; i < label.length; i++) {
            label[i] = new JLabel(msgs[i]);
            label[i].setAlignmentX(CENTER_ALIGNMENT);
            labelPanel.add(label[i]);
        }
        // Set up the button and icon
        button = new JButton("Aceptar");
        icon = new JLabel(UIManager.getIcon("OptionPane.informationIcon"));
        // Mount the JDialog
        this.setLayout(new BorderLayout());
        this.add(labelPanel, BorderLayout.CENTER);
        this.add(button, BorderLayout.SOUTH);
        this.add(icon, BorderLayout.WEST);
    }
    
    public JButton getButton() {
        return button;
    }   
}
