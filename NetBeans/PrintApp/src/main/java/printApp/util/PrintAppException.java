/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printApp.util;

/**
 *
 * @author AMD
 */
public class PrintAppException extends Exception{
    
    private String message;

    public PrintAppException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }       
    
}
