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
public class PrintJobController extends Controller<PrintJob>{

    @Override
    public List<PrintJob> read() {
       return session.createQuery("from PrintJob", PrintJob.class).list();
    }

    @Override
    protected void controlCreate() throws PrintAppException {
       
        controlVolume();
        
    }

    @Override
    protected void controlUpdate() throws PrintAppException {
       
    }

    @Override
    protected void controlDelete() throws PrintAppException {
       
    }

    private void controlVolume() throws PrintAppException{
       
        if(entitet.getVolume().floatValue()>2000f){
            throw new PrintAppException("Volume cannot be greater than 2000mL");
        }
        
        if(entitet.getVolume().floatValue()<=0f){
              throw new PrintAppException("Volume must be a positive number!");
        }
        
    }
    
    
    
}
