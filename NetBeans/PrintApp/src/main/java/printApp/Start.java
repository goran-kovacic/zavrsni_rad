/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package printApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import printApp.controller.MaterialController;
import printApp.controller.PrinterController;
import printApp.controller.ProjectController;
import printApp.model.Material;
import printApp.model.Printer;
import printApp.model.Project;
import printApp.util.PrintAppException;

/**
 *
 * @author AMD
 */
public class Start {

    public static void main(String[] args) throws PrintAppException {

        // HibernateUtil.getSession();
        // new InitialInsert();
        
        PrinterController pc = new PrinterController();
        Printer p = new Printer();
        /*
        p.setPrinterName("printer X");
        p.setManufacturer("elegoo");
        p.setPrinterTime(220);
        p.setFepCount(12);
        */
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
