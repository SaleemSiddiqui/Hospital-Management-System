/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Saleem
 */
public class DoctorS {
    private  String Name;
    private  int DoctorID;
    private  long PhoneNumber;
    private  String Spciality;
    private  String Gender;
    private  int age;
    
    DoctorS(){
        this.Name= "";
        this.DoctorID= 0;
        this.Gender= "";
        this.Spciality="";
        this.PhoneNumber=0;
        this.age=0;
    }
    
   DoctorS(String na,long ph,String special,int ag,String gend,int id){
        this.Name= na;
        this.DoctorID= id;
        this.Gender= gend;
        this.Spciality=special;
        this.PhoneNumber= ph;
        this.age=ag;
    }

    public String getName() {
        return Name;
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public String getSpciality() {
        return Spciality;
    }

    public String getGender() {
        return Gender;
    }

    public int getAge() {
        return age;
    }
    
    public ObservableList<DoctorS> Display() throws IOException{
        FileHandler fh =new FileHandler();
        ObservableList<DoctorS> data= FXCollections.observableArrayList();
        fh.openAsReaderForDoctor();
        
        AddDoctor obj = new AddDoctor();
        while(true){
            DoctorS d= new DoctorS();
            obj=(AddDoctor)fh.getDoctor();
            if(obj==null){
                d=null;
                System.out.println("Not found");
                break;
            }
            
            d.Name= obj.getName();
            d.DoctorID= obj.getDoctorID();
            d.Gender= obj.getGender();
            d.Spciality=obj.getSpciality();
            d.PhoneNumber= obj.getPhoneNumber();
            d.age=obj.getAge();
            data.add(d);
        }
        return data;
    }
    
}
