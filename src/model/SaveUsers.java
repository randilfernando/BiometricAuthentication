/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Randil Fernando
 * 
 */
public class SaveUsers {   
    public static ArrayList<User> usersList;
    
    // Serialize method 
    public static void save(String filename){
        try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file); 
            out.writeObject(usersList);
        }catch(IOException ex){
            System.out.println("Error Occurs");
            System.out.println(ex.getMessage());
        }
    }
    
    // Deserialize method
    public static void load(String filename){
        ArrayList<User> users = null;
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file); 
            users = (ArrayList<User>) in.readObject();
        }catch(IOException | ClassNotFoundException ex){
            System.out.println("Error Occurs");
            System.out.println(ex.getMessage());
        }        
        usersList = users;
    }
}
