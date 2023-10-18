/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printApp.controller;

import java.util.List;
import org.hibernate.Session;
import printApp.model.Entitet;
import printApp.util.HibernateUtil;
import printApp.util.PrintAppException;

/**
 *
 * @author AMD
 */
public abstract class Controller<T extends Entitet> {
    
    protected T entitet;
    protected Session session;
    public abstract List<T> read();
    protected abstract void controlCreate() throws PrintAppException;
    protected abstract void controlUpdate() throws PrintAppException;
    protected abstract void controlDelete() throws PrintAppException;
    
    
    public Controller(){
        session = HibernateUtil.getSession();
    }
    
    public void create() throws PrintAppException{
        controlNull();
        entitet.setId(null);
        controlCreate();
        persist();
    }
           
    public void update() throws PrintAppException{
        controlNull();
        controlUpdate();
        persist();
    }
    
    public void delete() throws PrintAppException{
        controlNull();
        controlDelete();
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
        
    }
    
    private void persist(){
        session.beginTransaction();
        session.persist(entitet);
        session.getTransaction().commit();
    }

    private void controlNull() throws PrintAppException{
        if(entitet==null){
            throw new PrintAppException("Entity is null");
        }        
    }
    
    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    public void refresh(){
        if(entitet!=null){
            session.refresh(entitet);
        }
    }
    
}
