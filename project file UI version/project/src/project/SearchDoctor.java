/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;

/**
 *
 * @author Waqas Hussain Ali
 */
public class SearchDoctor {

    SearchDoctor(){
        
    }
    public void Display(){
        System.out.println("1SearchByName");
        System.out.println("2SearchBy ID");
        System.out.println("3SearchByPhoneNumber");
    }
    public AddDoctor SearchDoctorByNAme(String name) throws IOException{
        FileHandler fh =new FileHandler();
        fh.openAsReaderForDoctor();
       String obje="";
       char c;
        AddDoctor obj = new AddDoctor();
        while(true){
            obj=(AddDoctor)fh.getDoctor();
            
            if(obj==null){
                System.out.println("Not found");
                return obj;
            }
            System.out.println("check if");
            if(name.equals(obj.getName())==true)
            {
                System.out.println("found");
                return obj;
            }
        }
    }
    public AddDoctor SearchDoctorByID(int id) throws IOException{
        FileHandler fh =new FileHandler();
        fh.openAsReaderForDoctor();
        AddDoctor obj = new AddDoctor();
        while(true){
            obj=(AddDoctor)fh.getDoctor();
            if(obj==null){
                System.out.println("Not found");
                return obj;
            }
            
            if(id==obj.getDoctorID())
            {
                System.out.println("found");
                return obj;
            }
            
        }
    }
    
    public AddDoctor SearchDoctorByPhoneNumber(long phone) throws IOException{
        FileHandler fh =new FileHandler();
        fh.openAsReaderForDoctor();
        AddDoctor obj = new AddDoctor();
        while(true){
            obj=(AddDoctor)fh.getDoctor();
            
            if(obj==null){
                System.out.println("Not found");
                return obj;
            }
            if(phone==obj.getPhoneNumber())
            {
                System.out.println("found");
                return obj;
            }
        }
    }
    
}
