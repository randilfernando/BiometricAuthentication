/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import views.AddUserFrame;
import views.AuthenticateFrame;
import views.MainFrame;

/**
 *
 * @author Randil Fernando
 */
public class MainFrameController {
    private final MainFrame frame;

    public MainFrameController(MainFrame frame) {
        this.frame = frame;
    }

    public void control(){
        this.frame.getButtonAddUser().addActionListener((ActionEvent e) -> {
            getAddUserPage();
        });
        this.frame.getButtonAuthenticate().addActionListener((ActionEvent e) -> {
            getAuthenticatePage();
        });
        this.frame.getButtonExit().addActionListener((ActionEvent e) -> {
            exit();
        });
        
        this.frame.setVisible(true);
    }
    
    private void getAddUserPage(){
        AddUseFramerController addUserFrameController = new AddUseFramerController(new AddUserFrame());
        addUserFrameController.controll();
    }
    
    private void getAuthenticatePage(){
        AuthenticateFrameController authenticateFrameController = new AuthenticateFrameController(new AuthenticateFrame());
        authenticateFrameController.control();
    }
    
    private void exit(){
        this.frame.dispose();
    }
}
