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
 * @author Waqas Hussain Ali
 */
public class Hospital {
    
    Hospital(){
        
    }
        public void Display() throws IOException, CloneNotSupportedException{
         
            while(true){//infinte loop to repeat process again and again
            System.out.println("1 DOctor");     //options that are display
            System.out.println("2 patient");
            System.out.println("3 exit");
            //Scanner for user input
            Scanner sn=new Scanner(System.in);
            int n;
            n=sn.nextInt();
            if(n==1)
            {
                Doctor d=new Doctor();      //if one so you want to go in doctor data
                d.Display();    //display for doctor methods
            }else
            if (n==2){
                Patient p= new PatientMethodList();     //to create patient for its option use
                int a=0;
                while(true)
                {
                p.Display();            //display patient method option
                a=sn.nextInt(); 
                switch(a){
                    case 1:
                        File f= new File("Patient.txt");
                        if(f.exists())   //if file exist so set up the id of doctor to create new doctor
                        {
                            p.setUid();
                        }
                        p.GetUserInput();// taking input for patient details
                        p.AddPatientToFile();   //adding patient to file
                        break;
                    case 2:
                        p.SearchOption();   //showing searching option
                        int h=sn.nextInt();
                        if(h==1)
                        {
                            System.out.println("Enter Name");
                            p=p.SearchPatientByName(sn.next());
                        }
                        if(h==2)
                        {
                            System.out.println("Enter id");
                            p=p.SearchPatientById(sn.nextInt());
                        }
                        if(h==3)
                        {
                            System.out.println("Enter number");
                            p=p.SearchPatientByPhoneNumber(sn.nextLong());
                        }
                        break;
                    case 3:
                        p.DisplaySortingOption();   
                        int m=sn.nextInt();
                        switch(m){
                            case 1:
                                p.SortPatientByName();
                                break;
                            case 2:
                                p.SortPatientById();
                                break;
                            case 3:
                                p.SortPatientByPhoneNumber();
                                break;
                            default:
                                break;
                                
                        }
                        break;
                    case 4:
                        p.DisplayAllPatient();
                        break;
                    case 5:
                        System.out.println("Enter id of patient");
                        p.DeletePatientData(sn.nextInt());
                        break;
                    default:
                        break;
                }
                if(a>5){
                    break;
                }
                }
            }
            else{
                System.out.println("Leaving....!!!1");
                break;
            }
            
            }
        }
    
}
