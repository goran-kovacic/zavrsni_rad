/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package printApp;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import printApp.controller.Controller;
import printApp.controller.PartController;
import printApp.controller.PrintJobController;
import printApp.controller.ProjectController;
import printApp.model.Part;
import printApp.model.PrintJob;
import printApp.model.Project;
import printApp.util.HibernateUtil;
import printApp.util.InitialInsert;
import printApp.util.PrintAppException;

/**
 *
 * @author AMD
 */
public class Start {

    public static void main(String[] args) throws PrintAppException {

        // HibernateUtil.getSession();
        // new InitialInsert();
        
        PrintJobController pc = new PrintJobController();
        
        PrintJob p = new PrintJob();
        
        p.setVolume(BigDecimal.valueOf(0));
        
        pc.setEntitet(p);
        
        try {
            pc.create();
        } catch (PrintAppException ex) {
            System.out.println(ex.getMessage());
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
