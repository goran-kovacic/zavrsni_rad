/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printApp.controller;

import java.util.List;
import printApp.model.Printer;
import printApp.util.PrintAppException;

/**
 *
 * @author AMD
 */
public class PrinterController extends Controller<Printer> {

    @Override
    public List<Printer> read() {

        return session.createQuery("from Printer", Printer.class).list();

    }

    @Override
    protected void controlCreate() throws PrintAppException {

        controlName();
        appendName();

    }

    @Override
    protected void controlUpdate() throws PrintAppException {

        controlName();

    }

    @Override
    protected void controlDelete() throws PrintAppException {

    }

    private void controlName() throws PrintAppException {
        if (entitet.getPrinterName() == null) {
            throw new PrintAppException("Printer name must be defined!");
        }
        if (entitet.getPrinterName().isEmpty()) {
            throw new PrintAppException("Printer name cannot be emtpy!");
        }

        if (entitet.getManufacturer() == null) {
            throw new PrintAppException("Manufacturer name must be defined!");
        }
        if (entitet.getManufacturer().isEmpty()) {
            throw new PrintAppException("Manufacturer name cannot be emtpy!");
        }

    }
    
    private void appendName(){
        List<Printer> list = session.createQuery("from Printer p where p.printerName like :condition",Printer.class)
                .setParameter("condition", entitet.getPrinterName()+ "%")
                .list(); 
        
        if(list!=null && !list.isEmpty()){
            entitet.setPrinterName(entitet.getPrinterName()+ " (" + (list.size()) + ")");
        }
    }

}
