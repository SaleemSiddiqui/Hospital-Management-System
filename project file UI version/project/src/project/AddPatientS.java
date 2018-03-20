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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Saleem
 */
public class AddPatientS {
    
    AddPatientS(){
        
    }
    
    public void start(){
        final Stage st= new Stage();
        Group root= new Group();
        Scene sce=new Scene(root,800,500);
        final Button addbut = new Button("Add Doctor");
        final Button back = new Button("Back");
        final TextField nameText= new TextField();
        Label nameLab= new Label("Name:");
        nameLab.setLayoutX(130);
        nameLab.setLayoutY(130);
        nameLab.setPrefHeight(30);
        nameLab.setPrefWidth(50);
        nameText.setPrefSize(350, 20);
        nameText.setLayoutX(185);
        nameText.setLayoutY(130);
        final TextField NicText= new TextField();
        Label NicLab= new Label("Nic #:");
        NicLab.setLayoutX(130);
        NicLab.setLayoutY(130+40);
        NicLab.setPrefHeight(30);
        NicLab.setPrefWidth(50);
        NicText.setPrefSize(350, 20);
        NicText.setLayoutX(185);
        NicText.setLayoutY(130+40);
        final TextField ageText= new TextField();
        final Label ageLab= new Label("Age:");
        ageLab.setLayoutX(130);
        ageLab.setLayoutY(130+40+40);
        ageLab.setPrefHeight(30);
        ageLab.setPrefWidth(50);
        ageText.setPrefSize(350, 20);
        ageText.setLayoutX(185);
        ageText.setLayoutY(130+40+40);
        final ToggleGroup group = new ToggleGroup();
        final RadioButton button1 = new RadioButton("Male");
       final  RadioButton button2 = new RadioButton("Female");
        button1.setToggleGroup(group);
        button2.setToggleGroup(group);
        button1.setLayoutX(185);
        button1.setLayoutY(130+40+40+40);
        button1.setSelected(true);
        button2.setLayoutX(185+70);
        button2.setLayoutY(130+40+40+40);
        final Label genLab= new Label("Gender:");
        genLab.setLayoutX(130);
        genLab.setLayoutY(130+40+40+35);
        genLab.setPrefHeight(30);
        genLab.setPrefWidth(50);
        final Label depLab= new Label("Depart:");
        depLab.setLayoutX(130);
        depLab.setLayoutY(130+40+40+35+40);
        depLab.setPrefHeight(30);
        depLab.setPrefWidth(70);
        final ComboBox opt=new ComboBox();
        opt.setPrefSize(350, 20);
        opt.getItems().addAll("Accident_and_emergency_(A&E)","Diagnostic_imaging","Ear_nose_and_throat_(ENT)","General_surgery","Unknown");
        opt.setLayoutX(185);
        opt.setLayoutY(130+40+40+40+40);
        final TextField phText= new TextField();
        final Label phLab= new Label("Phone #:");
        phLab.setLayoutX(130);
        phLab.setLayoutY(130+40+40+40+40+40);
        phLab.setPrefHeight(30);
        phLab.setPrefWidth(50);
        phText.setPrefSize(350, 20);
        phText.setLayoutX(185);
        phText.setLayoutY(130+40+40+40+40+40);
        final Label ageL= new Label();
        final  Label phL= new Label();
        final Label depL= new Label();
        final Label nicL= new Label();
        final Label nameL= new Label();
        final Label gendL= new Label();
        ageL.setVisible(false);
        ageL.setPrefSize(350, 20);
        ageL.setLayoutX(185);
        ageL.setLayoutY(130+40+40+5);
        phL.setVisible(false);
        phL.setPrefSize(350, 20);
        phL.setLayoutX(185);
        phL.setLayoutY(130+40+40+40+40+40+5);
        depL.setVisible(false);
        depL.setPrefSize(350, 20);
        depL.setLayoutX(185);
        depL.setLayoutY(130+40+40+40+40);
        nicL.setVisible(false);
        nicL.setPrefSize(350, 20);
        nicL.setLayoutX(185);
        nicL.setLayoutY(130+40+5);
        nameL.setVisible(false);
        nameL.setPrefSize(350, 20);
        nameL.setLayoutX(185);
        nameL.setLayoutY(130+5);
        gendL.setVisible(false);
        gendL.setPrefSize(350, 20);
        gendL.setLayoutX(185);
        gendL.setLayoutY(130+40+40+40);
        addbut.setPrefHeight(30);
        addbut.setPrefWidth(150);
        addbut.setLayoutX(600);
        addbut.setLayoutY(400);
        addbut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nameText.setVisible(false);
                NicText.setVisible(false);
                ageText.setVisible(false);
                opt.setVisible(false);
                phText.setVisible(false);
                addbut.setVisible(false);
                button1.setVisible(false);
                button2.setVisible(false);
                ageL.setText(ageText.getText());
                phL.setText(phText.getText());
                RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
                String toogleGroupValue = selectedRadioButton.getText();
                gendL.setText(toogleGroupValue);
                nameL.setText(nameText.getText());
                nicL.setText(NicText.getText());
                depL.setText(opt.getValue().toString());
                ageL.setVisible(true);
                phL.setVisible(true);
                gendL.setVisible(true);
                nameL.setVisible(true);
                nicL.setVisible(true);
                depL.setVisible(true);
                ageL.setTextFill(Color.BLUE);
                phL.setTextFill(Color.BLUE);
                gendL.setTextFill(Color.BLUE);
                nameL.setTextFill(Color.BLUE);
                nicL.setTextFill(Color.BLUE);
                depL.setTextFill(Color.BLUE);
                FileHandler fh= new FileHandler();
                Patient add= new PatientMethodList();
                        add.setUid();
                        add.setAge(Integer.parseInt(ageText.getText()));
                        add.setGender(toogleGroupValue);
                        add.setName(nameText.getText());
                        add.setPhoneNumber(Long.parseLong(phText.getText()));
                        add.setDepart(opt.getValue().toString());
                        add.AddPatientToFile();
                
                back.setVisible(true);
            }
        });
        back.setPrefHeight(30);
        back.setPrefWidth(150);
        back.setLayoutX(600);
        back.setLayoutY(400);
        back.setVisible(false);
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PatientDetS sd= new PatientDetS();
                sd.start();
                st.close();
            }
        });
        Image img= new Image("File:project.jpg");
        ImageView im= new ImageView(img);
        root.getChildren().addAll(im,phText,phLab,back,ageL,phL,gendL,nameL,nicL,depL);
        root.getChildren().addAll(addbut,nameText,nameLab,NicText,NicLab,ageText,ageLab,button1,button2,genLab,opt,depLab);
        
        st.setMaximized(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.setMaxHeight(500);
        st.setMaxWidth(800);
        st.setScene(sce);
        st.show();
    }
   
    
}
