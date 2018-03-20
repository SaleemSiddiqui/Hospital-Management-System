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
public class AddDoctor implements Cloneable {

    private String Name;
    static int DoctorID=0;
    private long PhoneNumber;
    private String Spciality;
    private String Gender;
    private int age;
    
    public AddDoctor(){
        
    }
    
    public AddDoctor(String na,long ph,String Special,String gender,int ag){
        this.Name=na;
        this.PhoneNumber=ph;
        this.Gender=gender;
        this.Spciality=Special;
        this.age=ag;
        this.DoctorID++;
    }

    public String getSpciality() {
        return Spciality;
    }

    public void setSpciality(String Spciality) {
        this.Spciality = Spciality;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public  int getDoctorID() {
        return DoctorID;
    }

    public  void setDoctorID(int DoctorID) {
        AddDoctor.DoctorID = DoctorID;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void DoctorsDetails(){
        
        Scanner sn= new Scanner(System.in);
        System.out.println("Enter Name \n");
        this.Name=sn.next();
        this.DoctorID+=1;
        System.out.println("Enter Doctor's PhoneNumber \n");
        this.PhoneNumber=sn.nextLong();
        System.out.println("Enter Gender");
        this.Gender=sn.next();
        System.out.println("Enter age");
        this.age=sn.nextInt();
        String[ ] arr =new String[ ]{"Accident_and_emergency_(A&E)","Diagnostic_imaging","Ear_nose_and_throat_(ENT)","General_surgery","Unknown"};
        for(int i=0;i<arr.length;i++){
            System.out.println(i+1+" "+arr[i]);
        }
        int k=sn.nextInt();
        this.Spciality=arr[k-1];
        
    }
    
    public void AddDoctorTOFIle() throws CloneNotSupportedException , IOException{

        FileHandler fh= new FileHandler();
        fh.openAsWrtierForDoctor();
        AddDoctor obj = new AddDoctor();
        obj=(AddDoctor) this.clone();
        System.out.println(obj.toString());
        fh.WriteLineToFile(this.toString());
        fh.CloseFilesWriter();
        
    }
    
    @Override
    public String toString(){
        return this.Name +" "+this.PhoneNumber+" "+this.Gender+" "+this.age+" "+this.Spciality+" "+this.DoctorID;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    
    public void display(){
        System.out.println(this.Name);
        System.out.println(this.PhoneNumber);
        System.out.println(this.getDoctorID());
    }
  
}
