/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package printApp;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import printApp.controller.Controller;
import printApp.controller.ProjectController;
import printApp.model.Project;
import printApp.util.HibernateUtil;
import printApp.util.InitialInsert;
import printApp.util.PrintAppException;

/**
 *
 * @author AMD
 */
public class Start {

    public static void main(String[] args) {
        
       // HibernateUtil.getSession();
        
       // new InitialInsert();
      /* 
        ProjectController pc = new ProjectController();
        
        Project p = new Project();
        p.setProjectName("prvi preko kontrola");
        
        pc.setEntitet(p);
        
        try {
            pc.create();
        } catch (PrintAppException ex) {
            System.out.println(ex.getMessage());
        }
        */
           
       
      
    }
}
