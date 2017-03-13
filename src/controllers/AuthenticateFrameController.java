/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.Authenticate;
import model.Request;
import views.AuthenticateFrame;

/**
 *
 * @author Randil Fernando
 */
public class AuthenticateFrameController {
    private final AuthenticateFrame frame;

    public AuthenticateFrameController(AuthenticateFrame frame) {
        this.frame = frame;
    }
    
    public void control(){
        this.frame.getjButton1().addActionListener((ActionEvent e) -> {
            authenticate();
        });
        this.frame.setVisible(true);
    }
    
    private void authenticate(){
        try{
            float palm_width = Float.parseFloat(this.frame.getPalmWidthText().getText());
                float palm_length = Float.parseFloat(this.frame.getPalmLengthText().getText());
                float thumb_width = Float.parseFloat(this.frame.getThumbWidthText().getText());
                float thumb_length = Float.parseFloat(this.frame.getThumbLengthText().getText());
                float index_width = Float.parseFloat(this.frame.getIndexWidthText().getText());
                float index_length = Float.parseFloat(this.frame.getIndexLengthText().getText());
                float middle_width = Float.parseFloat(this.frame.getMiddleWidthText().getText());
                float middle_length = Float.parseFloat(this.frame.getMiddleLengthText().getText());
                float ring_width = Float.parseFloat(this.frame.getRingWidthText().getText());
                float ring_length = Float.parseFloat(this.frame.getRingLengthText().getText());
                float small_width = Float.parseFloat(this.frame.getSmallWidthText().getText());
                float small_length = Float.parseFloat(this.frame.getSmallLengthText().getText());
        
            Request authRequest = new Request(palm_width, palm_length, thumb_width, thumb_length, index_width, index_length, middle_width, middle_length, ring_width, ring_length, small_width, small_length);
        
            Authenticate.auth(authRequest);
        
            this.frame.dispose();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in input", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
