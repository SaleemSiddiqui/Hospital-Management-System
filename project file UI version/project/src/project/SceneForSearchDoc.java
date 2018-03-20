/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 *
 * @author Saleem
 */
public class SceneForSearchDoc {
    Stage sce= new Stage();
    Group root = new Group();
    Scene scene= new Scene(root,800,500);
    
    SceneForSearchDoc(){
        
    }
    
    public void start(){
        final TextField tx=new TextField();
        
        Button seabut=new Button("Search");
        Button back= new Button("Back");
        Label cont= new Label();
        final ComboBox opt=new ComboBox();
        cont.setText("Enter Content Here As You Choose in list");
        cont.setLayoutX(200);
        cont.setLayoutY(100);
        cont.setPrefSize(400, 20);
        tx.setPrefSize(430, 20);
        tx.setLayoutX(185);
        tx.setLayoutY(130);
        opt.setLayoutX(200);
        opt.setLayoutY(170);
        opt.setPrefSize(400, 20);
        opt.getItems().addAll("By Id","By Name","By Phone_Number");
        
        Label nameL= new Label("Name:");
        nameL.setLayoutX(185);
        nameL.setLayoutY(130+80);
        nameL.setPrefHeight(30);
        nameL.setPrefWidth(50);
        Label idL= new Label("Id#:");
        idL.setLayoutX(185+220);
        idL.setLayoutY(130+80);
        idL.setPrefHeight(30);
        idL.setPrefWidth(50);
        Label phL= new Label("Phone #:");
        phL.setLayoutX(185);
        phL.setLayoutY(130+40+80);
        phL.setPrefHeight(30);
        phL.setPrefWidth(50);
        Label ageL= new Label("Age:");
        ageL.setLayoutX(185+220);
        ageL.setLayoutY(130+40+80);
        ageL.setPrefHeight(30);
        ageL.setPrefWidth(50);
        Label genL= new Label("Gender:");
        genL.setLayoutX(185);
        genL.setLayoutY(130+40+40+80);
        genL.setPrefHeight(30);
        genL.setPrefWidth(50);
        Label depL= new Label("Depart:");
        depL.setLayoutX(185+220);
        depL.setLayoutY(130+40+40+80);
        depL.setPrefHeight(30);
        depL.setPrefWidth(70);
        

        //for value Label
        
        final Label naL= new Label("--");
        naL.setLayoutX(185+70);
        naL.setLayoutY(130+80);
        naL.setPrefHeight(30);
        naL.setPrefWidth(50+30);
        final Label idnL= new Label("--");
        idnL.setLayoutX(185+220+70);
        idnL.setLayoutY(130+80);
        idnL.setPrefHeight(30);
        idnL.setPrefWidth(50);
        final Label pL= new Label("--");
        pL.setLayoutX(185+70);
        pL.setLayoutY(130+40+80);
        pL.setPrefHeight(30);
        pL.setPrefWidth(50+50);
        final Label agL= new Label("--");
        agL.setLayoutX(185+220+70);
        agL.setLayoutY(130+40+80);
        agL.setPrefHeight(30);
        agL.setPrefWidth(50);
        final Label gendL= new Label("--");
        gendL.setLayoutX(185+70);
        gendL.setLayoutY(130+40+40+80);
        gendL.setPrefHeight(30);
        gendL.setPrefWidth(50+30);
        final Label deL= new Label("--");
        deL.setLayoutX(185+220+70);
        deL.setLayoutY(130+40+40+80);
        deL.setPrefHeight(30);
        deL.setPrefWidth(70+50);
        final Label NotFound= new Label("Not Found");
        NotFound.setLayoutX(185+150);
        NotFound.setLayoutY(130+40+80);
        NotFound.setPrefHeight(70);
        NotFound.setPrefWidth(200);
        NotFound.setStyle("-fx-border-color: white; -fx-border-width: 4;");
        NotFound.setFont(new Font(30));
        NotFound.setAlignment(Pos.CENTER);
        NotFound.setTextFill(Color.WHITE);
        NotFound.setVisible(false);
        seabut.setMaxWidth(70);
        seabut.setMaxHeight(20);
        seabut.setLayoutX(550);
        seabut.setLayoutY(100);
        seabut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String op= opt.getValue().toString();
                SearchDoctor sd= new SearchDoctor();
                AddDoctor ob=new AddDoctor();
                switch(op){
                    case "By Id":
                        int id=Integer.parseInt(tx.getText());
                        System.out.println(id);
               
                    try {
                        ob=sd.SearchDoctorByID(id);
                        if(ob==null)
                        {
                            NotFound.setVisible(true);
                        }else{
                            naL.setTextFill(Color.BLUE);
                            agL.setTextFill(Color.BLUE);
                            pL.setTextFill(Color.BLUE);
                            deL.setTextFill(Color.BLUE);
                            gendL.setTextFill(Color.BLUE);
                            idnL.setTextFill(Color.BLUE);
                            naL.setText(ob.getName());
                            agL.setText(String.valueOf(ob.getAge()));
                            pL.setText(String.valueOf(ob.getPhoneNumber()));
                            deL.setText(ob.getSpciality());
                            gendL.setText(ob.getGender());
                            idnL.setText(String.valueOf(ob.getDoctorID()));
                        }
                        System.out.println(ob);
                    } catch (IOException ex) {
                    }
                
                        break;
                    case "By Name":
                        String name=tx.getText();
                        System.out.println(name);
                        try {
                        ob=sd.SearchDoctorByNAme(name);
                        if(ob==null)
                        {
                            NotFound.setVisible(true);
                        }else{
                            naL.setTextFill(Color.BLUE);
                            agL.setTextFill(Color.BLUE);
                            pL.setTextFill(Color.BLUE);
                            deL.setTextFill(Color.BLUE);
                            gendL.setTextFill(Color.BLUE);
                            idnL.setTextFill(Color.BLUE);
                            naL.setText(ob.getName());
                            agL.setText(String.valueOf(ob.getAge()));
                            pL.setText(String.valueOf(ob.getPhoneNumber()));
                            deL.setText(ob.getSpciality());
                            gendL.setText(ob.getGender());
                            idnL.setText(String.valueOf(ob.getDoctorID()));
                        }
                        System.out.println(ob);
                    } catch (IOException ex) {
                    }
                        break;
                    case "By Phone_Number":
                        long ph=Long.parseLong(tx.getText());
                        System.out.println(ph);
                        try {
                        ob=sd.SearchDoctorByPhoneNumber(ph);
                        if(ob==null)
                        {
                            NotFound.setVisible(true);
                        }else{
                            naL.setTextFill(Color.BLUE);
                            agL.setTextFill(Color.BLUE);
                            pL.setTextFill(Color.BLUE);
                            deL.setTextFill(Color.BLUE);
                            gendL.setTextFill(Color.BLUE);
                            idnL.setTextFill(Color.BLUE);
                            naL.setText(ob.getName());
                            agL.setText(String.valueOf(ob.getAge()));
                            pL.setText(String.valueOf(ob.getPhoneNumber()));
                            deL.setText(ob.getSpciality());
                            gendL.setText(ob.getGender());
                            idnL.setText(String.valueOf(ob.getDoctorID()));
                        }
                        System.out.println(ob);
                    } catch (IOException ex) {
                    }
                        break;
                }

                System.out.println("searching....");
            }
        });
        back.setPrefHeight(30);
        back.setPrefWidth(150);
        back.setLayoutX(600);
        back.setLayoutY(400);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ScenesForDoctor sr = new ScenesForDoctor();
                sr.start();
                sce.close();
                
            }
        });
        Image img= new Image("File:project.jpg");
        ImageView im= new ImageView(img);
        root.getChildren().addAll(im,idL,nameL,genL,depL,phL,ageL,NotFound);
        root.getChildren().addAll(tx,seabut,cont,opt,back,naL,agL,deL,pL,gendL,idnL);
        sce.setMaximized(false);
        sce.initStyle(StageStyle.UNDECORATED);
        sce.setMaxHeight(500);
        sce.setMaxWidth(800);
        sce.setScene(scene);
        sce.show();
    }
    
}
