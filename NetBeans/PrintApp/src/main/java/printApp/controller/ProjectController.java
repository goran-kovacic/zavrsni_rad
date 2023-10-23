/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printApp.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import printApp.model.Part;
import printApp.model.PrintJob;
import printApp.model.Project;
import printApp.util.PrintAppException;

/**
 *
 * @author AMD
 */
public class ProjectController extends Controller<Project> {

    @Override
    public void delete() throws PrintAppException {
    
        PartController pc = new PartController();
        
        for(Part p : entitet.getParts()){
            p.setProject(null);
            pc.setEntitet(p);
            try {
                pc.update();
            } catch (Exception e) {
            }
        }
        
        
        super.delete(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public void deleteProjectPartPrintJob() throws PrintAppException{
        
        PartController pc = new PartController();
        ProjectController prc = new ProjectController();
              
        for(Part p : entitet.getParts()){
            
            pc.setEntitet(p);
            try {
                pc.delete();
            } catch (Exception e) {
            }
        }
        
        prc.setEntitet(getEntitet());
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
        
    }

    
    
    
    @Override
    public List<Project> read() {
        return session.createQuery("from Project", Project.class).list();
    }
    
    public List<Project> readByCompleted() {
        return session.createQuery("from Project where isCompleted = false", Project.class).list();
    }

    @Override
    protected void controlCreate() throws PrintAppException {
        controlName();
        appendName();
        controlDate();
    }

    @Override
    protected void controlUpdate() throws PrintAppException {
        controlName();
        controlDateUpdate();
    }

    @Override
    protected void controlDelete() throws PrintAppException {
//        if(!entitet.getParts().isEmpty()){
//            
//            PartController pc = new PartController();
//            
//            List<Part> list = new ArrayList<>();
//            
//            for(int i=0; i<entitet.getParts().size(); i++){
//                
//                pc.entitet.setProject(null);
//                
//                
//                
//                
//            }
//            
//            
//            
//        }
    }

    private void controlName() throws PrintAppException {

        if (entitet.getProjectName() == null) {
            throw new PrintAppException("Project name must be defined!");
        }
        if (entitet.getProjectName().isEmpty()) {
            throw new PrintAppException("Project name cannot be emtpy!");
        }

    }

    private void appendName() {
        List<Project> list = session.createQuery("from Project p where p.projectName like :condition", Project.class)
                .setParameter("condition", entitet.getProjectName() + "%")
                .list();

        if (list != null && !list.isEmpty()) {
            entitet.setProjectName(entitet.getProjectName() + " (" + (list.size()) + ")");
        }
    }

    private void controlDate() throws PrintAppException {

        try {
            if (entitet.getCreationDate().after(entitet.getCompletionDate())) {
                throw new PrintAppException("Completion date cannot be earlier than the creation date");
            }
        } catch (NullPointerException e) {

        }

        if (entitet.getCreationDate() == null && entitet.getCompletionDate() != null) {
            throw new PrintAppException("Please enter a creation date before entering the completion date.");
        }

    }

    private void controlDateUpdate() throws PrintAppException {

        if (entitet.getCreationDate() == null) {
            throw new PrintAppException("Creation date cannot be updated to null!");
        }

        if (entitet.getCompletionDate() == null) {
            return;
        }

        if (entitet.getCreationDate().after(entitet.getCompletionDate())) {
            throw new PrintAppException("Completion date cannot be earlier than the creation date");
        }

    }

}
