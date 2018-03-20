/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saleem
 */
public class PatientMethodList extends Patient{
    
    
    @Override
    public void AddPatientToFile() {
        FileHandler fh=new FileHandler();
        try{
        fh.OpenAsWriterForPatient();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        try{
        fh.WriteLineToFile(this.toString());
        }catch(IOException e)
        {
            System.out.println("null");
        }
        try{
        fh.CloseFilesWriter();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        
    }

    @Override
    public Patient SearchPatientByName(String name) {
        FileHandler fh= new FileHandler();
        Patient p= new PatientMethodList();
        try{
        fh.openAsReaderForPatient();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        while(true)
        {
        try{
            p=this.BreakAttributes(fh.ReadLineFromFile());
        }catch(IOException e)
        {
            System.out.println("error");
        }
        if(p.getName().equals(name))
        {
            System.out.println("found....!!!!");
            try {
                System.out.println(p.show());
            } catch (IOException ex) {
            }
            break;
        }else
            if(p==null){
                System.out.println("not found....!!!!");
                p=null;
                break;
            }
        }
        return p;
    }

    @Override
    public Patient SearchPatientById(int n) {
        FileHandler fh= new FileHandler();
        Patient p= new PatientMethodList();
        try{
        fh.openAsReaderForPatient();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        while(true)
        {
        try{
            p=this.BreakAttributes(fh.ReadLineFromFile());
        }catch(IOException e)
        {
            System.out.println("error");
        }
        if(p.id==n)
        {
            System.out.println("found....!!!!");
            try {
                System.out.println(p.show());
            } catch (IOException ex) {
            }
            break;
        }else
            if(p==null){
                System.out.println("not found....!!!!");
                return null;
            }
        }
        return p;
    }

    @Override
    public Patient SearchPatientByPhoneNumber(long num) {
        FileHandler fh= new FileHandler();
        Patient p= new PatientMethodList();
        try{
        fh.openAsReaderForPatient();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        while(true)
        {
        try{
            p=this.BreakAttributes(fh.ReadLineFromFile());
        }catch(IOException e)
        {
            System.out.println("error");
        }
        if(p.getPhoneNumber()==num)
        {
            System.out.println("found....!!!!");
            try {
                System.out.println(p.show());
            } catch (IOException ex) {
            }
            break;
        }else
            if(p==null){
                System.out.println("not found....!!!!");
                p=null;
                break;
            }
        }
        return p;
    }

    @Override
    public void DisplayAllPatient() {
        FileHandler fh= new FileHandler();
        Patient p= new PatientMethodList();
        try{
        fh.openAsReaderForPatient();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        while(true)
        {
            try{
                p=this.BreakAttributes(fh.ReadLineFromFile());
        }catch(IOException e)
        {
            System.out.println("error");
        }
            if(p==null)
            {
                break;
            }
            try {
                System.out.println(p.show());
            } catch (IOException ex) {
                
            }
        }
        try{
            fh.CloseFilesReader();
        }catch(IOException e)
        {
            System.out.println("error");
        }
    }    

    @Override
    public void SortPatientByName() {
        
        Patient[] arr= new Patient[10];
        FileHandler fh= new FileHandler();
        Patient p= new PatientMethodList();
        int i=0;
        try{
        fh.openAsReaderForPatient();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        while(true)
        {
            try{
                p=this.BreakAttributes(fh.ReadLineFromFile());
        }catch(IOException e)
        {
            System.out.println("error");
        }
            if(p==null)
            {
                break;
            }
            else{
            try {
                arr[i]=(Patient)p.clone();
                i++;
            } catch (CloneNotSupportedException ex) {
                System.out.println("Clone can not be form");
            }
            }
        }
        try{
            fh.CloseFilesReader();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        Patient temp;
        int val;
        for(int m=0;m<i-1;m++){
        for(int l=m+1;l<i;l++){
            //System.out.println(arr[l]);
            
            val= arr[m].getName().compareTo(arr[l].getName());
                    if(val>0)
                    {
                        temp=arr[m];
                        arr[m]=arr[l];
                        arr[l]=temp;
                    }    
        }
        }
        for(int k=0;k<i;k++){
            try {
                System.out.println(arr[k].show());
            } catch (IOException ex) {
                System.out.println("error");
            }
        }
    }

    @Override
    public void SortPatientById() {
    Patient[] arr= new Patient[10];
        FileHandler fh= new FileHandler();
        Patient p= new PatientMethodList();
        int i=0;
        try{
        fh.openAsReaderForPatient();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        while(true)
        {
            try{
                p=this.BreakAttributes(fh.ReadLineFromFile());
        }catch(IOException e)
        {
            System.out.println("error");
        }
            if(p==null)
            {
                break;
            }
            else{
            try {
                arr[i]=(Patient)p.clone();
                i++;
            } catch (CloneNotSupportedException ex) {
                System.out.println("Clone can not be form");
            }
            }
        }
        try{
            fh.CloseFilesReader();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        Patient temp;
        int val;
        for(int m=0;m<i-1;m++){
        for(int l=m+1;l<i;l++){
            //System.out.println(arr[l]);
            
            val= arr[m].getName().compareTo(arr[l].getName());
                    if(val>0)
                    {
                        temp=arr[m];
                        arr[m]=arr[l];
                        arr[l]=temp;
                    }    
        }
        }
        for(int k=0;k<i;k++){
            try {
                System.out.println(arr[k].show());
            } catch (IOException ex) {
                System.out.println("error");
            }
        }}
    

    @Override
    public void SortPatientByPhoneNumber() {
    Patient[] arr= new Patient[10];
        FileHandler fh= new FileHandler();
        Patient p= new PatientMethodList();
        int i=0;
        try{
        fh.openAsReaderForPatient();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        while(true)
        {
            try{
                p=this.BreakAttributes(fh.ReadLineFromFile());
        }catch(IOException e)
        {
            System.out.println("error");
        }
            if(p==null)
            {
                break;
            }
            else{
            try {
                arr[i]=(Patient)p.clone();
                i++;
            } catch (CloneNotSupportedException ex) {
                System.out.println("Clone can not be form");
            }
            }
        }
        try{
            fh.CloseFilesReader();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        Patient temp;
        for(int m=0;m<i-1;m++){
        for(int l=m+1;l<i;l++){
            
                    if(arr[m].getPhoneNumber()>arr[l].getPhoneNumber())
                    {
                        temp=arr[m];
                        arr[m]=arr[l];
                        arr[l]=temp;
                    }    
        }
        }
        for(int k=0;k<i;k++){
            try {
                System.out.println(arr[k].show());
            } catch (IOException ex) {
                System.out.println("error");
            }
        }
    }

    @Override
    public void SortPatientByDepart() {
        Patient[] arr= new Patient[10];
        FileHandler fh= new FileHandler();
        Patient p= new PatientMethodList();
        int i=0;
        try{
        fh.openAsReaderForPatient();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        while(true)
        {
            try{
                p=this.BreakAttributes(fh.ReadLineFromFile());
        }catch(IOException e)
        {
            System.out.println("error");
        }
            if(p==null)
            {
                break;
            }
            else{
            try {
                arr[i]=(Patient)p.clone();
                i++;
            } catch (CloneNotSupportedException ex) {
                System.out.println("Clone can not be form");
            }
            }
        }
        try{
            fh.CloseFilesReader();
        }catch(IOException e)
        {
            System.out.println("error");
        }
        Patient temp;
        for(int m=0;m<i-1;m++){
        for(int l=m+1;l<i;l++){
            
                    if(arr[m].getDepart().equals(arr[l].getDepart()))
                    {
                        temp=arr[m];
                        arr[m]=arr[l];
                        arr[l]=temp;
                    }    
        }
        }
        for(int k=0;k<i;k++){
            try {
                System.out.println(arr[k].show());
            } catch (IOException ex) {
                System.out.println("error");
            }
        }
     
    }    
    
    @Override
    public  Patient BreakAttributes(String line){ //    to convert string line into attributes of doctor
        
        if(line==null)
            return null;
        String name="", gender="",dep="";
        int id=0,age=0,d_id=0;
        long phone=0;
        char c;
        int i=0;
        
        while(true){
                    c=line.charAt(i);
                    if(c == ' '){
                        break;
                    }
                    name+=c;
                    i++;
                    
        }
        c='*';
        i++;
        while(true){
                    
                    c=line.charAt(i);
                    if(c == ' '){
                        break;
                    }
                    gender+=c;
                    i++;
                    
        }
        c='*';
        i++;
        while(true){
                    c=line.charAt(i);
                    if(c == ' '){
                        break;
                    }
                    
                    phone=phone*10;
                    phone+=c-48;
                    i++;
                    
        }
        c='*';
        i++;
        while(true){
                    c=line.charAt(i);
                    if(c == ' '){
                        break;
                    }
                    
                    age=age*10;
                    age+=c-48;
                    i++;
                    
        }
        c='*';
        i++;
        while(true){
                    
                    c=line.charAt(i);
                    if(c == ' '){
                        break;
                    }
                    dep+=c;
                    i++;
                    
        }
        c='*';
        i++;
        while(true){
                    c=line.charAt(i);
                    if(c == ' '){
                        break;
                    }
                    
                    d_id=d_id*10;
                    d_id+=c-48;
                    i++;
                    
        }
        i++;
        while(true){
                    c=line.charAt(i);
                    if(c == '*'){
                        break;
                    }
                    
                    id=id*10;
                    id+=c-48;
                    i++;
                    
        }
        Patient p=new PatientMethodList();
        p.setAge(age);
        p.setPhoneNumber(phone);
        p.setName(name);
        p.setId(id);
        p.setGender(gender);
        p.setDepart(dep);
        p.setDoctorKey(d_id);
        return p;
    }
    
    @Override
    public void RecomendDoctor(String s){
        try{
        FileHandler fh= new FileHandler();
        fh.openAsReaderForDoctor();
        AddDoctor obj = new AddDoctor();
        while(true){
            if(s=="Unknown")
                break;
            obj=(AddDoctor)fh.getDoctor();
            if(obj==null){
                break;
            }
            if(s.equals(obj.getSpciality()))
            {
                System.out.println(obj.toString());
            }
            
        }
        fh.CloseFilesReader();
        }
        catch(IOException e){
            
        }
        
    }
    
    @Override
    public void ListOFDoctorSpecialization(){
        System.out.println("1 Accident and emergency (A&E)");
        System.out.println("2 Diagnostic imaging");
        System.out.println("3 Ear nose and throat (ENT)");
        System.out.println("4 General surgery");
        System.out.println("5 Unknown");
    }
 
    @Override
    public void setUid() {
        FileHandler fh= new FileHandler();
        try {
            fh.openAsReaderForPatient();
        } catch (IOException ex) {
            System.out.println("error");
        }
         Patient p= new PatientMethodList();
         
         while(true){
            try {
                p=this.BreakAttributes(fh.ReadLineFromFile());
            } catch (IOException ex) {
                System.out.println("error");
            }
         if(p==null){
             break;
         }
         }
        try {
            fh.CloseFilesReader();
        } catch (IOException ex) {
            System.out.println("error");
        }
     }
    
    @Override
    public void DisplaySortingOption(){
        System.out.println("1 Sort By Name");
        System.out.println("2 Sort By Id");
        System.out.println("3 Sort By PhoneNumber");
        System.out.println("5 Back");
    }
    
    @Override
    public void Display(){
        System.out.println("1: Add");
        System.out.println("2: Search");
        System.out.println("3: Sort");
        System.out.println("4: DisplayAllPatient");
        System.out.println("5: Delete Patient");
        System.out.println("6: Back");
    }
    
    @Override
    public void SearchOption(){
        System.out.println("1: by name");
        System.out.println("2; by id");
        System.out.println("3: by phone");
        System.out.println("4: back");
    }
    
    @Override
    public void GetUserInput(){
        Scanner sn= new Scanner(System.in);
        System.out.println("Enter Name");
        this.setName(sn.next());
        System.out.println("Enter Gender");
        this.setGender(sn.next());
        System.out.println("Enter Age");
        this.setAge(sn.nextInt());
        System.out.println("Enter Phone Number");
        this.setPhoneNumber(sn.nextLong());
        this.id++;  
        String[ ] arr =new String[ ]{"Accident_and_emergency_(A&E)","Diagnostic_imaging","Ear_nose_and_throat_(ENT)","General_surgery","Unknown"};
        System.out.println("Do you Want To choose doctor Yes or No");
        String s=sn.next();
        switch (s){
            case "yes":
            case "Yes":
            case "YES":
                this.ListOFDoctorSpecialization();
                int i=sn.nextInt();
                this.setDepart(arr[i-1]);
                this.RecomendDoctor(arr[i-1]);
                if(arr[i-1]!="Unknown")
                {
                System.out.println("Enter the Id of Doctor you choose");
                int k=sn.nextInt();
                this.setDoctorKey(k);
                }
                else{
                    this.setDoctorKey(0);
                }
                break;
            default:
                break;
        }
        
    }
    
    @Override
    public void DeletePatientData(int id){
        Patient p = null;
        FileWriter ff=null;
        System.out.println("Deleting......");
        FileHandler fh= new FileHandler();
        try {
            fh.openAsReaderForPatient();
            ff= new FileWriter("tem.txt");
        } catch (IOException ex) {
        }
        
        String ss=" ";
        while(true){
            try {
                ss=fh.ReadLineFromFile();
            } catch (IOException ex) {
            }
            if(ss==null){
                System.out.println("not found");
                break;
            }
           p=(Patient)this.BreakAttributes(ss);
         if(p.getId()==id)
         {
             continue;
         }
            System.out.println(p);
            try {
                ff.write(ss+"\n");
            } catch (IOException ex) {
            }
        }
        try {
            ff.close();
            fh.CloseFilesReader();
            File f1=new File("Patient.txt");
            File f2= new File("tem.txt");
            f1.delete();
            f2.renameTo(f1);
        } catch (IOException ex) {
        }
        System.out.println("done");   
    }
}
