/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;

public abstract class Patient implements Cloneable{
    private String Name;
    private String Gender;
    private int Age;
    static int id=0;
    private long PhoneNumber;
    private int DoctorKey;
    private String Depart;
    
    public Patient(){
        this.Age=0;
        this.Name="";
        this.PhoneNumber=0;
        this.Gender="";  
        this.Depart="";
    }
    public Patient(String nam,String gend,int age,long phone,String dep){
        this.Age=age;
        this.Name=nam;
        this.PhoneNumber=phone;
        this.Gender=gend;
        this.id++;
        this.Depart=dep;
    }
    
    public Patient(Patient p){
        this(p.Name,p.Gender,p.Age,p.PhoneNumber,p.Depart);
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public int getId() {
        return id;
    }

    public static void setId(int id) {
        Patient.id = id;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public int getDoctorKey() {
        return DoctorKey;
    }

    public void setDoctorKey(int DoctorKey) {
        this.DoctorKey = DoctorKey;
    }

    public String getDepart() {
        return Depart;
    }

    public void setDepart(String Depart) {
        this.Depart = Depart;
    }
    
    
    
    public String show() throws IOException{
        FileHandler fh =new FileHandler();
        fh.openAsReaderForDoctor();
        AddDoctor obj = new AddDoctor();
        while(true){
            if(this.DoctorKey==0){
                obj.setName("--");
                break;
            }
            obj=(AddDoctor)fh.getDoctor();
            if(this.DoctorKey==obj.getDoctorID())
            {
                break;
            }
            
        }
        String det="";
        det=this.Name+" "+this.Gender+" "+this.PhoneNumber+" "+this.Age+" "+this.Depart+" "+obj.getName()+" "+this.id;
        return det;
    
    }
    
    @Override
    public String toString(){
        return this.Name+" "+this.Gender+" "+this.PhoneNumber+" "+this.Age+" "+this.Depart+" "+this.DoctorKey+" "+this.id; 
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    
    @Override
    public boolean equals(Object obj){
        Patient p;
        p=(Patient) obj;
        if(p.Name==this.Name && p.Gender==this.Gender && p.Age==this.Age && p.PhoneNumber==this.PhoneNumber && p.Depart==this.Depart)
            return true;
        return false;
    }
    
    public abstract void AddPatientToFile();
    
    public abstract Patient SearchPatientByName(String name);
    
    public abstract Patient SearchPatientById(int n);
    
    public abstract Patient SearchPatientByPhoneNumber(long num);
    
    public abstract void DisplayAllPatient();
    
    public abstract void SortPatientByName();
    
    public abstract void SortPatientById();
    
    public abstract void SortPatientByPhoneNumber();
    
    public abstract void SortPatientByDepart();
    
    public abstract void DisplaySortingOption();
    
    public abstract void setUid();
    
    public abstract void ListOFDoctorSpecialization();
    
    public abstract void RecomendDoctor(String s);
    
    public abstract Patient BreakAttributes(String line);
    
    public abstract void Display();
    
    public abstract void SearchOption();
    
    public abstract void GetUserInput();
    
    public abstract void DeletePatientData(int id);
    
}
