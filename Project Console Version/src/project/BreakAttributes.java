/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Waqas Hussain Ali
 */

import java.lang.String;
public class BreakAttributes {

    BreakAttributes(){
        
    }
    
    public AddDoctor DoctorsAttributes(String line){
        AddDoctor obj=new AddDoctor();
        String Name="",gender="",special="";
        long phone=0;
        int id=0,i=0,age=0;
        char c;
        if(line==null)
        {
            return null;
        }
                while(true){
                    c=line.charAt(i);
                    if(c == ' '){
                        break;
                    }
                    Name+=c;
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
                    special+=c;
                    i++;
        }
        c=' ';
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
        obj.setName(Name);
        obj.setPhoneNumber(phone);
        obj.setDoctorID(id);
        obj.setAge(age);
        obj.setGender(gender);
        obj.setSpciality(special);
        //System.out.println(obj);
return obj;
    }

    
}
