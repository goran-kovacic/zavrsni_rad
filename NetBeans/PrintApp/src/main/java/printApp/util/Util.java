/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printApp.util;

import printApp.model.User;

/**
 *
 * @author AMD
 */
public class Util {
    
    public static final String APP_NAME= "3D Print App";
    public static User USER;
    
    
    public static String getUser(){
        return USER.getUserName();
    }
    
}
