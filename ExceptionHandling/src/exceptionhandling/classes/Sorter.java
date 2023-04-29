/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *
 * @author Issac
 */
public  class Sorter { 
    
    public static void sort(ArrayList<Container> containers, ArrayList<Container> sortedContainers)
    {
        String[] shortNames = new String[containers.size()];
        for(int i = 0; i < containers.size(); i++)
        {
            shortNames[i] = containers.get(i).getShortName();
            
        }
        shortNames = Stream.of(shortNames)
                    .sorted()
                    .toArray(String[]::new);
        
        
         for(int i = 0; i < shortNames.length; i++)
        {
            for(int j = 0; j < shortNames.length; j++)
            {
                   if(shortNames[i].equals(containers.get(j).getShortName()))
                   {
                       sortedContainers.add(containers.get(j));
                   }
            }
        }
        
       
    }
    
}

