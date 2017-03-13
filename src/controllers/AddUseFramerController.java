/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.SaveUsers;
import model.User;
import views.AddUserFrame;

/**
 *
 * @author Randil Fernando
 */
public class AddUseFramerController {

    private final AddUserFrame frame;

    public AddUseFramerController(AddUserFrame frame) {
        this.frame = frame;
    }

    public void controll() {
        this.frame.getjButton1().addActionListener((ActionEvent e) -> {
            addNewUser();
        });
        this.frame.setVisible(true);
    }

    private void addNewUser() {
        String name = this.frame.getNameText().getText();
        
        String index_no = this.frame.getIndexNoText().getText();
        
        if ("".equals(name) || "".equals(index_no)) {
            JOptionPane.showMessageDialog(null, "No empty name or index no", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
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

                User user = new User(name, index_no, palm_width, palm_length, thumb_width, 
                thumb_length, index_width, index_length, middle_width, middle_length, 
                ring_width, ring_length, small_width, small_length);
                
                SaveUsers.usersList.add(user);
                String fileName = "Users.ser";
                SaveUsers.save(fileName);

                JOptionPane.showMessageDialog(null, "User added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearTextBoxes();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error in inputs", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void clearTextBoxes() {
        this.frame.getNameText().setText("");
        this.frame.getIndexNoText().setText("");
        this.frame.getPalmWidthText().setText("");
        this.frame.getPalmLengthText().setText("");
        this.frame.getThumbWidthText().setText("");
        this.frame.getThumbLengthText().setText("");
        this.frame.getIndexWidthText().setText("");
        this.frame.getIndexLengthText().setText("");
        this.frame.getMiddleWidthText().setText("");
        this.frame.getMiddleLengthText().setText("");
        this.frame.getRingWidthText().setText("");
        this.frame.getRingLengthText().setText("");
        this.frame.getSmallWidthText().setText("");
        this.frame.getSmallLengthText().setText("");
    }
}
