/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Saleem
 */
public class PatientDetS {

    PatientDetS(){
        
    }
    
    
    void start() {
        
        final Stage stDoc= new Stage();
        Group root= new Group();
        Scene sDoc = new Scene(root,800,500);
        Group ButtonGroup= new Group();
        
        Button AddDoc = new Button("Add Patient");
        AddDoc.setPrefHeight(50);
        AddDoc.setPrefWidth(100);
        AddDoc.setLayoutX(150);
        AddDoc.setLayoutY(200);
        AddDoc.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                AddPatientS ad= new AddPatientS();
                stDoc.close();
                ad.start();
               
            }
        });
        Button SearchDoc = new Button("Search Patient");
        SearchDoc.setPrefHeight(50);
        SearchDoc.setPrefWidth(100);
        SearchDoc.setLayoutX(150+130);
        SearchDoc.setLayoutY(200);
        SearchDoc.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               SearchPatS sd= new SearchPatS();
               sd.start();
               stDoc.close();
            }
        });
        Button RemoveDoc = new Button("Remove Patient");
        RemoveDoc.setPrefHeight(50);
        RemoveDoc.setPrefWidth(100);
        RemoveDoc.setLayoutX(150+260);
        RemoveDoc.setLayoutY(200);
        RemoveDoc.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               DelPatS ds= new DelPatS();
               ds.start();
               stDoc.close();
            }
        });
        Button DisplayDoc = new Button("Display Patients");
        DisplayDoc.setPrefHeight(50);
        DisplayDoc.setPrefWidth(100);
        DisplayDoc.setLayoutX(150+390);
        DisplayDoc.setLayoutY(200);
        DisplayDoc.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               DisplayAllPatS ds = null;
                try {
                    ds = new DisplayAllPatS();
                } catch (IOException ex) {
                    Logger.getLogger(ScenesForDoctor.class.getName()).log(Level.SEVERE, null, ex);
                }
               ds.start();
               stDoc.hide();
            }
        });
        
        Button Back = new Button("Back");
        Back.setPrefHeight(30);
        Back.setPrefWidth(150);
        Back.setLayoutX(600);
        Back.setLayoutY(400);
        Back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ScenesForProject sr = new ScenesForProject();
                stDoc.hide();
                sr.start();
            }
        });
        Image img= new Image("File:project.jpg");
        ImageView im= new ImageView(img);
        root.getChildren().add(im);
        root.getChildren().add(AddDoc);
        root.getChildren().add(Back);
        root.getChildren().add(SearchDoc);
        root.getChildren().add(RemoveDoc);
        root.getChildren().add(DisplayDoc);
        stDoc.setMaximized(false);
        stDoc.initStyle(StageStyle.UNDECORATED);
        stDoc.setMaxHeight(500);
        stDoc.setMaxWidth(800);
        stDoc.setScene(sDoc);
        stDoc.show();
    }
    
}
