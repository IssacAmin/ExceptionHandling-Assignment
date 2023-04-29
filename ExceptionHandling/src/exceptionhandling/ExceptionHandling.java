/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import classes.*;


/**
 *
 * @author Issac
 */
public class ExceptionHandling {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String filename = args[0];
        try{
            //first Exception 
            if(!filename.endsWith(".arxml")) {
                throw new InvalidFileException("Invalid File Type");
            } 
              
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            if(file.length() == 0)
                throw new EmptyFileException("Empty file ");
            
            ArrayList<Container> containerBuffer = new ArrayList<>();
            ArrayList<Container> containerSorted = new ArrayList<>();
            
           
            String constantPart= "";
            String tmp; 
            String id;
            String shortName = "";
            String longName = "";
            boolean notDone = true;
            while (scanner.hasNextLine()) {
                tmp = scanner.nextLine();
                
                if(tmp.contains("<CONTAINER"))
                {
                    notDone = false;
                    id = getStringBetweenTwoCharacters(tmp, "\"", "\"");
                   
                        tmp = scanner.nextLine();
                        if(tmp.contains("<SHORT-NAME>"))
                            shortName = getStringBetweenTwoCharacters(tmp, ">", "</SHORT-NAME>");
                        tmp = scanner.nextLine();
                        if(tmp.contains("<LONG-NAME>"))
                            longName = getStringBetweenTwoCharacters(tmp, ">", "</LONG-NAME>");
                    
                    containerBuffer.add(new Container(id, shortName, longName));
                }
                else if(notDone)
                    constantPart += tmp + "\n";
            
            }      
            Sorter.sort(containerBuffer, containerSorted);
            
            String newFileName = filename.substring(0, filename.lastIndexOf(".arxml")) + "_mod.arxml";
            FileWriter writer = new FileWriter(newFileName);
            writer.write(constantPart);
            for(int i = 0; i < containerSorted.size(); i++)
            {
                String temp = containerSorted.get(i).writeContainer();
                writer.write(temp);
            }
            writer.write("</AUTOSAR>");
            writer.close();
            
        }
        catch(InvalidFileException | EmptyFileException | FileNotFoundException e)
        {
            System.out.println(e);
        }

    }
    
     public static String getStringBetweenTwoCharacters(String input, String to, String from)
    {
        return input.substring(input.indexOf(to)+1, input.lastIndexOf(from));
    }
    
}


