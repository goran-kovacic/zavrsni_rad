/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package printApp;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import printApp.controller.MaterialController;
import printApp.controller.PrinterController;
import printApp.controller.ProjectController;
import printApp.controller.UserController;
import printApp.model.Material;
import printApp.model.Printer;
import printApp.model.Project;
import printApp.model.User;
import printApp.util.PrintAppException;
import printApp.view.Login;
import printApp.view.SplashScreen;

/**
 *
 * @author AMD
 */
public class Start {

    public static void main(String[] args) throws PrintAppException {

        // HibernateUtil.getSession();
        // new InitialInsert();
        
        new SplashScreen().setVisible(true);
            
        
    }
    
    private static void pw(){
        Argon2 argon2 = Argon2Factory.create();
        
        String hash = argon2.hash(10, 65536, 1, "admin".toCharArray());
        
        UserController oo = new UserController();
        User o = new User();
        o.setUserName("admin");
        o.setUserPassword(hash);
        
        oo.setEntitet(o);
        
        try {
            oo.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
}

    private static void inputDate() {

        ProjectController pc = new ProjectController();
        Project p = new Project();
        p.setProjectName("kontrola datum");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2023-08-15";

        try {            
            p.setCreationDate(sdf.parse("2023-08-15"));
        } catch (ParseException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {        
            p.setCompletionDate(sdf.parse("2023-09-15"));
        } catch (ParseException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }

        pc.setEntitet(p);

        try {
            pc.create();
        } catch (PrintAppException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
