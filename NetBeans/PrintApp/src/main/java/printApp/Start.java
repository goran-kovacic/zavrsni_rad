/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package printApp;

import com.github.javafaker.Faker;
import java.util.Locale;
import printApp.util.HibernateUtil;
import printApp.util.InitialInsert;

/**
 *
 * @author AMD
 */
public class Start {

    public static void main(String[] args) {
        
       // HibernateUtil.getSession();
        
       new InitialInsert();
       
        
    }
}
