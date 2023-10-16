/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printApp.controller;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import printApp.model.User;
import printApp.util.PrintAppException;

/**
 *
 * @author AMD
 */
public class UserController extends Controller<User>{
    
    

    @Override
    protected void controlCreate() throws PrintAppException {
      
    }

    @Override
    protected void controlUpdate() throws PrintAppException {
       
    }

    @Override
    protected void controlDelete() throws PrintAppException {
       
    }

    @Override
    public List<User> read() {
       return session.createQuery("from User", User.class).list();
    }
    
    public User login(String userName, String userPassword){
        
        User u;
        
        try {
            u = session.createQuery("from User u where u.userName=:userName", User.class)
                    .setParameter("userName", userName).getSingleResult();
            
            Argon2 argon2 = Argon2Factory.create();
            
            return argon2.verify(u.getUserPassword(), userPassword.toCharArray()) ? u :null;
            
        } catch (Exception e) {
            return null;
        }
        
    }
    
}
