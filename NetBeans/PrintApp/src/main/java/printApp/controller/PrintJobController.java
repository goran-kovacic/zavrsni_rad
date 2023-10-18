/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printApp.controller;

import java.util.List;
import printApp.model.PrintJob;
import printApp.util.PrintAppException;

/**
 *
 * @author AMD
 */
public class PrintJobController extends Controller<PrintJob> {
    
    @Override
     public void create() throws PrintAppException{
        super.create();
        entitet.getPrinter().setFepCount(entitet.getPrinter().getFepCount()+1);
        
        PrinterController pc = new PrinterController();
        pc.setEntitet(entitet.getPrinter());
        try {
            pc.update();
        } catch (Exception e) {
        }
        
        
    }

    @Override
    public List<PrintJob> read() {
        return session.createQuery("from PrintJob", PrintJob.class).list();
    }

    @Override
    protected void controlCreate() throws PrintAppException {

        controlVolume();
        controlPrintTime();
    }

    @Override
    protected void controlUpdate() throws PrintAppException {
        controlVolume();
        controlPrintTime();
    }

    @Override
    protected void controlDelete() throws PrintAppException {

    }

    private void controlVolume() throws PrintAppException {

        if (entitet.getVolume() == null) {
            return;
        }

        if (entitet.getVolume().floatValue() > 2000f) {
            throw new PrintAppException("Volume cannot be greater than 2000mL");
        }

        if (entitet.getVolume().floatValue() <= 0f) {
            throw new PrintAppException("Volume must be a positive number!");
        }

    }

    private void controlPrintTime() throws PrintAppException {
        if (entitet.getPrintTime() == null) {
            return;
        }

        if (entitet.getPrintTime() <= 0) {
            throw new PrintAppException("Print time must be a positive number!");
        }

    }

}
