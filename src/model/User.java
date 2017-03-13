/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Randil Fernando
 */
public class User implements Serializable {

    public String name;
    public String index_no;
    public int score;
    public boolean rejected = false;

    public float dimentions[] = new float[12];

    public User(String name, String index_no, float palm_width, float palm_length, float thumb_width, float thumb_length, float index_width, float index_length, float middle_width, float middle_length, float ring_width, float ring_length, float small_width, float small_length) {
        this.name = name;
        this.index_no = index_no;
        
        dimentions = new float[]{
            palm_width,
            palm_length,
            thumb_width,
            thumb_length,
            index_width,
            index_length,
            middle_width,
            middle_length,
            ring_width,
            ring_length,
            small_width,
            small_length
        };
    }
}
