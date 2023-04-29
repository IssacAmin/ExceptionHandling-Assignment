/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Issac
 */
public class InvalidFileException extends Exception {
    
       public InvalidFileException(){}
    public InvalidFileException(String msg)
    {
        super(msg);
    }
}
