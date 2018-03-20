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
    
     public void openAsWrtierForDoctor()  throws IOException{ //opening file writer for doctor
         this.fw=new FileWriter("Doctor.txt",true);
         this.bw=new BufferedWriter( this.fw);
     }
     
     public void openAsReaderForDoctor()  throws IOException{   // opening file reader for doctor
          this.fr= new FileReader("Doctor.txt");
          this.br = new BufferedReader(this.fr);
     }
     
     public void OpenAsWriterForPatient() throws IOException{ //opening file writer for patient
         this.fw= new FileWriter("Patient.txt",true);
         this.bw= new BufferedWriter(fw);
     }
     
     public void openAsReaderForPatient()  throws IOException{ //opening file reader for patient
          this.fr= new FileReader("Patient.txt");
          this.br = new BufferedReader(this.fr);
     }
     
     public void CloseFilesWriter() throws IOException{    //closing file writer
          this.bw.close();
          this.fw.close();
     }
     
     public void CloseFilesReader() throws IOException{     //closing file reader
          this.br.close();
          this.fr.close();
     }
     
     public String ReadLineFromFile() throws IOException{      //reading line from file
         return this.br.readLine();
     }
     
     public void WriteLineToFile(String line) throws IOException{   //writing line to file
          this.bw.write(line+"*\n");
     }
    
     public void setid() throws IOException{    //setting up id for doctor to create new one
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
