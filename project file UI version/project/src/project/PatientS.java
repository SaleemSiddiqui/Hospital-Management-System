/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Saleem
 */
public class PatientS {
    private String Name;
    private String Gender;
    private int Age;
    private int i;
    private long PhoneNumber;
    private String Depart;
    
     PatientS(){
        this.Age=0;
        this.Name="";
        this.PhoneNumber=0;
        this.Gender="";  
        this.Depart="";
        this.i=0;
    }
    
     PatientS(String nam,String gend,int age,long phone,String dep,int i){
        this.Age=age;
        this.Name=nam;
        this.PhoneNumber=phone;
        this.Gender=gend;
        this.i=i;
        this.Depart=dep;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setPhoneNumber(long PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setDepart(String Depart) {
        this.Depart = Depart;
    }
     
    public String getName() {
        return Name;
    }

    public String getGender() {
        return Gender;
    }

    public int getAge() {
        return Age;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public String getDepart() {
        return Depart;
    }
    
    public ObservableList<PatientS> Display() throws IOException{
        FileHandler fh= new FileHandler();
        ObservableList<PatientS> data= FXCollections.observableArrayList();
        Patient p= new PatientMethodList();
        
        fh.openAsReaderForPatient();
        while(true)
        {
            PatientS ps=new PatientS();
            p=p.BreakAttributes(fh.ReadLineFromFile());
            if(p==null)
            {
                break;
            }
             ps.setName(p.getName());
             ps.setAge(p.getAge());
             ps.setGender(p.getGender());
             ps.setPhoneNumber(p.getPhoneNumber());
             ps.setI(p.getId());
             ps.setDepart(p.getDepart());
             System.out.println(p.show());
             data.add(ps);
        }
            fh.CloseFilesReader();
            return data;
    }
 
}
