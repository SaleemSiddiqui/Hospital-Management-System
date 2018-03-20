/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Waqas Hussain Ali
 */
public class Doctor{
     
     AddDoctor add=new AddDoctor();
     SearchDoctor sd=new SearchDoctor();
     Scanner sn=new Scanner(System.in);
    int n;    
    Doctor(){
        
    }
    
    public void Display() throws IOException, CloneNotSupportedException{
        FileHandler fh= new FileHandler();
        fh.setid();
        while(true){
        System.out.println("1 add");
        System.out.println("2 search");
        System.out.println("3 delete");
            System.out.println("4 back");
            
        n=sn.nextInt();
        
            if(n==1)
        {
                 fh.setid();
                 add.DoctorsDetails();
                 add.AddDoctorTOFIle();
                 
        }
        else
        if(n==2){
            
            sd.Display();
            int k=sn.nextInt();
            if(k==1)
            {
                System.out.println("enter Name of Doctor");
                String name=sn.next();
                add=sd.SearchDoctorByNAme(name);
                System.out.println(add);
            }
            else if(k==2){
                System.out.println("enter id of Doctor");
                int id=sn.nextInt();
                add=sd.SearchDoctorByID(id);
                System.out.println(add);
            }
            else if(k==3)
            {
                System.out.println("enter phone Number of Doctor");
                long phone=sn.nextLong();
                add=sd.SearchDoctorByPhoneNumber(phone);
                System.out.println(add);
            }
        }else
        if(n==3){
            DeleteDoctor dd= new DeleteDoctor();
            System.out.println("Enter id");
            dd.delete(sn.nextInt());
        }
        else{
            break;
        }
        
        }
    }
    
    
}
