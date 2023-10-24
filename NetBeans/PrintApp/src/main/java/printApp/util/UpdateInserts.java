/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printApp.util;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;
import printApp.model.Material;
import printApp.model.Part;
import printApp.model.PrintJob;
import printApp.model.Printer;
import printApp.model.Project;
import printApp.view.PrintJobFrame;

/**
 *
 * @author AMD
 */
public class UpdateInserts {

    private Session session;
    private List<Project> projects;
    private List<Printer> printers;
    private List<Material> materials;
    private List<PrintJob> printJobs;
    private List<Part> parts;

    public UpdateInserts() {

        session = HibernateUtil.getSession();

        session.getTransaction().begin();

        updatePrinters();
        updatePrintJob();
        updateParts();
        updateProjects();

        session.getTransaction().commit();

    }

    private void updateProjects() {

        List<Project> projects = session.createQuery("from Project", Project.class).list();

        for (Project p : projects) {
            int tpt = 0;
            int tpc = 0;
            p.setTotalPrintCount(tpc);

            BigDecimal cost = BigDecimal.ZERO;

            List<Part> parts = p.getParts();
            for (Part pt : parts) {

                if (pt.getPrintTime() != 0) {
                    tpc++;
                    tpt = tpt + pt.getPrintTime();
                }

                cost = cost.add(pt.getCost());
//                tpt = pt.getPrintTime();
            }
            p.setTotalPrintCount(tpc);
            p.setTotalPrintTime(tpt);
            p.setTotalCost(cost);
            session.merge(p);

        }

    }

    private void updateParts() {

        List<Part> parts = session.createQuery("from Part", Part.class).list();

        for (Part p : parts) {
            int printerTime = 0;
            BigDecimal cost = BigDecimal.ZERO;
            List<PrintJob> printJobs = p.getPrintJobs();
            for (PrintJob pj : printJobs) {
                if (pj.isResult()) {
                    cost = cost.add(pj.getCost());
                    printerTime += pj.getPrintTime();
                }

            }
            p.setCost(cost);
            p.setPrintTime(printerTime);
            session.merge(p);
        }

    }

    private void updatePrinters() {

        List<Printer> printers = session.createQuery("from Printer", Printer.class).list();

        for (Printer p : printers) {

            int fepCount = p.getPrintJobs().size();
            p.setFepCount(fepCount);

            int printerTime = 0;
            List<PrintJob> printJobs = p.getPrintJobs();
            for (PrintJob pj : printJobs) {
                printerTime += pj.getPrintTime();
            }
            p.setPrinterTime(printerTime);

            session.merge(p);

        }

    }

    private void updatePrintJob() {

        List<PrintJob> printJobs = session.createQuery("from PrintJob", PrintJob.class).list();

        for (PrintJob pj : printJobs) {

            BigDecimal cpu = pj.getMaterial().getCostPerUnit();
            BigDecimal volume = pj.getVolume().divide(BigDecimal.valueOf(1000));
            pj.setCost(cpu.multiply(volume));

            session.merge(pj);
        }

    }

}
