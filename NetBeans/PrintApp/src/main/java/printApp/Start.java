/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package printApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import printApp.controller.ProjectController;
import printApp.model.Part;
import printApp.model.Project;
import printApp.util.HibernateUtil;
import printApp.util.InitialInsert;
import printApp.util.PrintAppException;
import printApp.view.SplashScreen;

/**
 *
 * @author AMD
 */
public class Start {

    
    
    

    public static void main(String[] args) throws PrintAppException {

         //  HibernateUtil.getSession();
         //   new InitialInsert();
        new SplashScreen().setVisible(true);
        
       
        
        

    }

    private static void inputDate() {

        ProjectController pc = new ProjectController();
        Project p = new Project();
        p.setProjectName("kontrola datum");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String dateInString = "2023-08-15";

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
