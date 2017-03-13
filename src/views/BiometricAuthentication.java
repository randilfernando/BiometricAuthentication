/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.MainFrameController;
import javax.swing.UIManager;
import model.SaveUsers;
import views.MainFrame;

/**
 *
 * @author Randil Fernando
 */
public class BiometricAuthentication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        //for look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        MainFrameController mainFrameController = new MainFrameController(new MainFrame());
        mainFrameController.control();
        
        String fileName = "Users.ser";
        
        SaveUsers.load(fileName);
    }
    
}
