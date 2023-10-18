/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printApp.controller;

import java.util.List;
import printApp.model.Project;
import printApp.util.PrintAppException;

/**
 *
 * @author AMD
 */
public class ProjectController extends Controller<Project> {

    @Override
    public List<Project> read() {
        return session.createQuery("from Project", Project.class).list();
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
        controlDate();
    }

    @Override
    protected void controlDelete() throws PrintAppException {

    }

    private void controlName() throws PrintAppException {

        if (entitet.getProjectName() == null) {
            throw new PrintAppException("Project name must be defined!");
        }
        if (entitet.getProjectName().isEmpty()) {
            throw new PrintAppException("Project name cannot be emtpy!");
        }

        
        
        
    }
    
    private void appendName(){
        List<Project> list = session.createQuery("from Project p where p.projectName like :condition",Project.class)
                .setParameter("condition", entitet.getProjectName()+ "%")
                .list(); 
        
        if(list!=null && !list.isEmpty()){
            entitet.setProjectName(entitet.getProjectName()+ " (" + (list.size()) + ")");
        }
    }

    private void controlDate() throws PrintAppException {

        if (entitet.getCompletionDate() == null) {
            return;
        }

        if (entitet.getCreationDate().after(entitet.getCompletionDate())) {
            throw new PrintAppException("Completion date cannot be earlier than the creation date");
        }

    }

}
