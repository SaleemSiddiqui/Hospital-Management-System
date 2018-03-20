/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project;
package project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import static javafx.scene.layout.BorderStroke.THICK;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Saleem
 */
public class ScenesForProject {

    public void start() {
        final Stage mStage = new Stage();
        Button DoctorClass = new Button();
        Image imgDc= new Image("File:doctor.png");
        ImageView imdc= new ImageView(imgDc);
        imdc.setFitHeight(200);
        imdc.setFitWidth(200);
        
        //DoctorClass.setBackground(Background.EMPTY);
        DoctorClass.setGraphic(imdc);
        DoctorClass.setPrefHeight(200);
        DoctorClass.setPrefWidth(200);
        DoctorClass.setLayoutX(120);
        DoctorClass.setLayoutY(130);
        DoctorClass.setText("Doctor");
        DoctorClass.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ScenesForDoctor sd=new ScenesForDoctor();
                mStage.hide();
                sd.start();
                System.out.println("doctor");
            }
        });
        
        
        Button PatientClass = new Button("Patient");
        Image imgpc= new Image("File:pat.png");
        ImageView impc= new ImageView(imgpc);
        impc.setFitHeight(200);
        impc.setFitWidth(200);
        //PatientClass.setBackground(Background.EMPTY);
      
        PatientClass.setGraphic(impc);
        PatientClass.setPrefHeight(200);
        PatientClass.setPrefWidth(200);
        PatientClass.setLayoutX(470);
        PatientClass.setLayoutY(130);
        PatientClass.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                PatientDetS p= new PatientDetS();
                p.start();
                mStage.hide();
                System.out.println("patient");
            }
        });
        
        Button Exit = new Button("Exit");
        Exit.setPrefHeight(30);
        Exit.setPrefWidth(230);
        Exit.setLayoutX(470);
        Exit.setLayoutY(130+250);
        Exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mStage.close();
                System.out.println("exit....");
            }
        });
        int x=800,y=500;
        Image img= new Image("File:project.jpg");
        ImageView im= new ImageView(img);
        im.setFitHeight(y);
        im.setFitWidth(x);
        mStage.initStyle(StageStyle.UNDECORATED);
        Pane root= new Pane();
        root.getChildren().add(im);
        root.getChildren().add(Exit);
        root.getChildren().add(DoctorClass);
        root.getChildren().add(PatientClass);
        
        
        Scene scene1 = new Scene(root, x, y);
        mStage.setMaximized(false);
        mStage.setMaxHeight(y);
        mStage.setMaxWidth(x);
        mStage.setTitle("Hello World!");
        mStage.setScene(scene1);
        mStage.show();
    }
   
}
