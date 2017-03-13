/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import javax.swing.JOptionPane;
import views.AuthUser;

/**
 *
 * @author Randil Fernando
 */
public class Authenticate {
    
    private static final float ERROR = (float) 0.2;
    
    public static void auth(Request request){
        
        for(int i=0;i<12;i++){
            User minUser=null;
            float minRatio=1000;
            for(User user: SaveUsers.usersList){
                if (!(user.rejected)){
                    float request_ratio=calRatio(user.dimentions[i], request.dimentions[i]);
                    if(request_ratio>ERROR){
                        user.rejected=true;
                    }else if(request_ratio<minRatio){
                        minRatio=request_ratio;
                        minUser=user;
                    }  
                }   
            }
            if(minUser!=null){
                minUser.score++;
            }
        }
        
        int score=-1;
        User maxUser=null;
        for(User user: SaveUsers.usersList){
            if(score<user.score && !user.rejected){
                score=user.score;
                maxUser=user;
            }
        }
        
        SaveUsers.usersList.stream().map((user) -> {
            user.score=0;
            return user;
        }).forEachOrdered((user) -> {
            user.rejected=false;
        });
        
        if(maxUser!=null){
            AuthUser authUser = new AuthUser();
            authUser.setDetails(maxUser);
            authUser.setLocationRelativeTo(null);
            authUser.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Access Denied","",JOptionPane.ERROR_MESSAGE);
        }     
    }
    
    public static float calRatio(float request_value, float user_value) {
        return Math.abs(round((user_value - request_value)/request_value,3));
    }
    
    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
