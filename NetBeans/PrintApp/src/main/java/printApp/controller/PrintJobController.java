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
    public void create() throws PrintAppException {
        super.create();
        entitet.getPrinter().setFepCount(entitet.getPrinter().getFepCount() + 1);
        entitet.getPrinter().setPrinterTime((entitet.getPrinter().getPrinterTime()) + (entitet.getPrintTime()));
        
        

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
    
    public List<PrintJob> readBySuccessfulPrint(){
//        return session.createQuery("from PrintJob p where p.result=true").list();
        
        return session.createQuery("from PrintJob p where p.result=true", PrintJob.class).list();
    }
    
    public List<PrintJob> readByFailedPrint(){
        return session.createQuery("from PrintJob p where p.result=false", PrintJob.class).list();
    }

    @Override
    protected void controlCreate() throws PrintAppException {

        controlVolume();
        controlPrintTime();
        controlMaterial();
        controlPrinter();
        controlPart();
    }

    @Override
    protected void controlUpdate() throws PrintAppException {
        controlVolume();
        controlPrintTime();
        controlMaterial();
        controlPrinter();
        controlPart();
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
            throw new PrintAppException("""
                                        Volume must be a positive number!
                                        If writing decimals use period as separator.""");
        }

    }

    private void controlPrintTime() throws PrintAppException {
        if (entitet.getPrintTime() == null) {
            return;
        }

        if (entitet.getPrintTime() <= 0) {
            throw new PrintAppException("Print time must be a positive integer number!");
        }

    }

    private void controlMaterial() throws PrintAppException {
        if (entitet.getMaterial() == null) {
            throw new PrintAppException("Select resin!");
        }
    }

    private void controlPart() throws PrintAppException{
        if(entitet.getPart() == null){
            throw new PrintAppException("Select part!");
        }
    }

    private void controlPrinter() throws PrintAppException{
        if(entitet.getPrinter() == null){
            throw new PrintAppException("Select a printer!");
        }
    }

}
