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
         
            while(true){
            System.out.println("1 DOctor");
            System.out.println("2 patient");
            System.out.println("3 exit");
            Scanner sn=new Scanner(System.in);
            int n;
            n=sn.nextInt();
            if(n==1)
            {
                Doctor d=new Doctor();
                d.Display();
            }else
            if (n==2){
                Patient p= new PatientMethodList();
                int a=0;
                while(true)
                {
                p.Display();
                a=sn.nextInt();
                switch(a){
                    case 1:
                        File f= new File("Patient.txt");
                        if(f.exists())
                        {
                            p.setUid();
                        }
                        p.GetUserInput();
                        p.AddPatientToFile();
                        break;
                    case 2:
                        p.SearchOption();
                        int h=sn.nextInt();
                        if(h==1)
                            p=p.SearchPatientByName(sn.next());
                        if(h==2)
                            p=p.SearchPatientById(sn.nextInt());
                        if(h==3)
                            p=p.SearchPatientByPhoneNumber(sn.nextLong());
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
                            case 4:
                                p.SortPatientByDepart();
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
