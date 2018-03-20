/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author ADMIN
 */

public class DeleteDoctor {
    
    DeleteDoctor(){
        
    }

    public AddDoctor delete(int id) throws IOException{
        
        //Scanner s=new Scanner(System.in);
        //System.out.println("enter id to delete");
        //int id= s.nextInt();
        AddDoctor d=null;
        SearchDoctor sd= new SearchDoctor();
        sd.SearchDoctorByID(id);
        System.out.println("Deleting.....!!!!");
        FileHandler fh= new FileHandler();
        fh.openAsReaderForDoctor();
        FileWriter fww= new FileWriter("temp.txt"); 
        String ss=" ";
        while(true){
            ss=fh.ReadLineFromFile();
            if(ss==null){
                break;
            }
            AddDoctor add=new AddDoctor();
         BreakAttributes ab= new BreakAttributes();
         add= (AddDoctor)ab.DoctorsAttributes(ss);
         if(add.getDoctorID()==id)
         {
             continue;
         }
            System.out.println(ss);
            fww.write(ss+"\n");
        }
        
        fww.close();
        fh.CloseFilesReader();
        File f1=new File("Doctor.txt");
        File f2= new File("temp.txt");
            f1.delete();
            f2.renameTo(f1);
        System.out.println("done");   
        return d;
    }
    
    
    
}
