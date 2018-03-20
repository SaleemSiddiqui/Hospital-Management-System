/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.io.*;

/**
 *
 * @author Waqas Hussain Ali
 */
public class FileHandler { 
 
    FileReader fr;
    FileWriter fw;
    BufferedReader br;
    BufferedWriter bw;
     
    FileHandler(){
        this.fw=null;
        this.bw=null;
        this.fr=null;
        this.br=null;
    }
   
    public AddDoctor getDoctor() throws FileNotFoundException, IOException{
        AddDoctor obj=new AddDoctor();
        BreakAttributes ab= new BreakAttributes();
        obj= (AddDoctor)ab.DoctorsAttributes(this.ReadLineFromFile());
        return obj; 
    }
    
    private int ConvertStringtoInt(String det){
        int num=0;
        for(int i=0;i<det.length();i++)
        {
            num=num+(int)det.charAt(i);
            num=num*10;
        }
        return num;    
    }
    
     public void openAsWrtierForDoctor()  throws IOException{
         this.fw=new FileWriter("Doctor.txt",true);
         this.bw=new BufferedWriter( this.fw);
     }
     
     public void openAsReaderForDoctor()  throws IOException{
          this.fr= new FileReader("Doctor.txt");
          this.br = new BufferedReader(this.fr);
     }
     
     public void OpenAsWriterForPatient() throws IOException{
         this.fw= new FileWriter("Patient.txt",true);
         this.bw= new BufferedWriter(fw);
     }
     
     public void openAsReaderForPatient()  throws IOException{
          this.fr= new FileReader("Patient.txt");
          this.br = new BufferedReader(this.fr);
     }
     
     public void CloseFilesWriter() throws IOException{
          this.bw.close();
          this.fw.close();
     }
     
     public void CloseFilesReader() throws IOException{
          this.br.close();
          this.fr.close();
     }
     
     public String ReadLineFromFile() throws IOException{
         return this.br.readLine();
     }
     
     public void WriteLineToFile(String line) throws IOException{
          this.bw.write(line+"*\n");
     }
    
     public void setid() throws IOException{
         this.openAsReaderForDoctor();
         AddDoctor ad=new AddDoctor();
         BreakAttributes ab= new BreakAttributes();
         while(true){
         ad= (AddDoctor)ab.DoctorsAttributes(this.ReadLineFromFile());
         if(ad==null){
             break;
         }
         }
         this.CloseFilesReader();
     }
}
