/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.File;

/**
 *
 * @author Issac
 */
public class Container {
    private final String id;
    private final String shortName;
    private final String longName;
    
   public Container(String id, String shortName, String longName)
    {
        this.id = id;
        this.shortName = shortName;
        this.longName = longName;
    }
    
    public String getShortName()
    {
        return this.shortName;
    }
    public String getLongName()
    {
        return this.longName;
    }
    public String getID()
    {
        return this.id;
    }
    public String writeContainer()
    {
        String content = "";
        content += "CONTAINER UUID=\""+ this.id + "\"\n";
        content += "\t<SHORT-NAME>"+this.shortName+"</SHORT-NAME>\n";
        content += "\t<LONG-NAME>"+this.longName+"</LONG-NAME>\n";
        content += "</CONTAINER>\n";
        
        return content;
    }
    
    
    
    
}
