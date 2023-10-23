/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printApp.util;

import com.github.javafaker.Faker;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import printApp.controller.PrintJobController;
import printApp.controller.PrinterController;
import printApp.controller.UserController;
import printApp.model.Material;
import printApp.model.Part;
import printApp.model.PrintJob;
import printApp.model.Printer;
import printApp.model.Project;
import printApp.model.User;

/**
 *
 * @author AMD
 */
public class InitialInsert {

    //private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private static final int NUMBER_OF_PROJECTS = 10;
    private static final int NUMBER_OF_PRINTERS = 5;
    private static final int NUMBER_OF_MATERIALS = 5;
    private static final int NUMBER_OF_PARTS = 20;
    private static final int NUMBER_OF_JOBS = 30;

    private Faker faker;
    private Session session;
    private List<Project> projects;
    private List<Printer> printers;
    private List<Material> materials;
    private List<PrintJob> printJobs;
    private List<Part> parts;

    public InitialInsert() {

        faker = new Faker();
        session = HibernateUtil.getSession();
        projects = new ArrayList<>();
        printers = new ArrayList<>();
        materials = new ArrayList<>();
        printJobs = new ArrayList<>();
        parts = new ArrayList<>();

        session.getTransaction().begin();

        createPrinters();
        creaeteMaterials();
        createProjects();
        createParts();
        createPrintJobs();

        //updatePrinters();

        session.getTransaction().commit();
        
        

        setPassword();
    }

    private void createProjects() {
        Project p;
        for (int i = 0; i < NUMBER_OF_PROJECTS; i++) {
            p = new Project();
            p.setProjectName(faker.starTrek().location());
            p.setProjectDescription(faker.lorem().paragraph(5));
            p.setCompleted(faker.bool().bool());

            try {
                Date startDate = dateFormat.parse("01/01/2023");
                Date endDate = dateFormat.parse("31/12/2023");

                p.setCreationDate(faker.date().between(startDate, endDate));
                p.setCompletionDate(faker.date().between(startDate, endDate));
            } catch (Exception e) {
            }
            
            p.setTotalCost(new BigDecimal(faker.number().numberBetween(10, 100)));
            p.setTotalPrintCount(faker.number().numberBetween(1, 10));
            p.setTotalPrintTime(faker.number().numberBetween(10, 100));

            session.persist(p);
            projects.add(p);
        }
    }

    private void creaeteMaterials() {
        Material m;
        for (int i = 0; i < NUMBER_OF_MATERIALS; i++) {
            m = new Material();
            m.setMaterialName(faker.starTrek().specie());
            m.setManufacturer(faker.space().planet());
            m.setCostPerUnit(new BigDecimal(faker.number().numberBetween(20, 100)));
            m.setBottomExposure(new BigDecimal(faker.number().numberBetween(10, 50)));
            m.setBottomLiftDistance(faker.number().numberBetween(4, 8));
            m.setBottomLiftSpeed(new BigDecimal(faker.number().numberBetween(1, 5)));
            m.setBottomRetractSpeed(new BigDecimal(faker.number().numberBetween(1, 10)));
            m.setCalibratedExposure(new BigDecimal(faker.number().numberBetween(1, 5)));
            m.setLayerHeight(new BigDecimal(faker.number().numberBetween(10, 100)));
            m.setLiftDistance(faker.number().numberBetween(4, 10));
            m.setLiftSpeed(new BigDecimal(faker.number().numberBetween(1, 10)));
            m.setLightOffDelay(new BigDecimal(faker.number().numberBetween(0, 2)));
            m.setRetractSpeed(new BigDecimal(faker.number().numberBetween(1, 10)));
            session.persist(m);
            materials.add(m);
        }
    }

    private void createPrinters() {
        Printer p;
        for (int i = 0; i < NUMBER_OF_PRINTERS; i++) {
            p = new Printer();
            p.setPrinterName(faker.starTrek().villain());
            p.setManufacturer(faker.space().planet());
            p.setPrinterTime(faker.number().numberBetween(10, 200));
            p.setFepCount(faker.number().numberBetween(5, 28));
            session.persist(p);
            printers.add(p);
        }
    }

    private void createPrintJobs() {
        PrintJob p;
        for (int i = 0; i < NUMBER_OF_JOBS; i++) {
            p = new PrintJob();
            p.setPrintTime(faker.number().numberBetween(1, 10));
            p.setResult(faker.bool().bool());
            p.setVolume(new BigDecimal(faker.number().numberBetween(0, 500)));
            p.setMaterial(materials.get(faker.number().numberBetween(0, NUMBER_OF_MATERIALS - 1)));
            p.setPart(parts.get(faker.number().numberBetween(0, NUMBER_OF_PARTS - 1)));
            p.setPrinter(printers.get(faker.number().numberBetween(0, NUMBER_OF_PRINTERS - 1)));
            session.persist(p);
            printJobs.add(p);
        }
    }

    private void createParts() {
        Part p;
        for (int i = 0; i < NUMBER_OF_PARTS; i++) {
            p = new Part();
            p.setPartName(faker.starTrek().character());
            p.setStlOriginal("C:\\" + faker.file().fileName());
            p.setStlSupported("C:\\" + faker.file().fileName());
            p.setSlicedFile("C:\\" + faker.file().fileName());
            p.setProject(projects.get(faker.number().numberBetween(0, NUMBER_OF_PROJECTS - 1)));
            
            p.setCost(new BigDecimal(faker.number().numberBetween(10, 100)));
            p.setPrintTime(faker.number().numberBetween(1, 10));
            
            
            session.persist(p);
            parts.add(p);
        }
    }

    private static void setPassword() {
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

    private void updatePrinters() {
        //List<PrintJob> l = session.createQuery("from PrintJob", PrintJob.class).list();
                     
        //PrinterController pc = new PrinterController();
                
       var p = new Printer();
       
       List<PrintJob> lp = p.getPrintJobs();
        
        
        for (PrintJob pj : lp) {
            
            int count = 0;
            
//            p.setFepCount(pj.getPrinter().setFepCount(count++));
            
            pj.getPrinter().setFepCount(count++);
           session.update(p);
           printers.add(p);
                   
            
        }
    }

}
