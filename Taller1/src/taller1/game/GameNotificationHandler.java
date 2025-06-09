/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller1.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cxz03
 */
public class GameNotificationHandler implements ActionListener{
    private GameNotification notification;
    
    public GameNotificationHandler(GameNotification gameNotification) {
       this.notification =  gameNotification;
       notification.getButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if the user accept then closes the app
        notification.dispose();
        System.exit(0);
    }
}
