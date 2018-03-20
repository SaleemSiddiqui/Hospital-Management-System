/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Saleem
 */
public class DisplayAllPatS {
    
    private final TableView<PatientS> table = new TableView<>();
    private ObservableList<PatientS> data= FXCollections.observableArrayList();
    
    public DisplayAllPatS() throws IOException{
        PatientS p= new PatientS();
        this.data= p.Display();
    }
    
    public void start(){
        final Stage st= new Stage();
        Group root= new Group();
        Scene sce=new Scene(root,800,500);
        Button exit = new Button("Back");
        exit.setPrefHeight(30);
        exit.setPrefWidth(150);
        exit.setLayoutX(325);
        exit.setLayoutY(450);
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PatientDetS sd= new PatientDetS();
                sd.start();
                st.close();
            }
        });
        
        TableColumn idcol = new TableColumn("Id#");
        idcol.setMinWidth(30);
        idcol.setCellValueFactory(new PropertyValueFactory<>("i"));
       
        TableColumn namecol = new TableColumn("Name");
        namecol.setMinWidth(100);
        namecol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
        TableColumn phonecol = new TableColumn("Phone #");
        phonecol.setMinWidth(100);
        phonecol.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        
        TableColumn agecol = new TableColumn("Age");
        agecol.setMinWidth(30);
        agecol.setCellValueFactory(new PropertyValueFactory<>("Age"));
        
        TableColumn specol = new TableColumn("Department");
        specol.setMinWidth(150);
        specol.setCellValueFactory(new PropertyValueFactory<>("Depart"));
        
        TableColumn gencol = new TableColumn("Gender");
        gencol.setMinWidth(40);
        gencol.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        
        table.setLayoutX(105);
        table.setLayoutY(100);
        table.setMinSize(350, 200);
        table.setMaxHeight(300);
        table.setItems(data);
        table.getColumns().addAll(idcol, namecol, gencol, agecol, phonecol, specol);
        
        
        Image img= new Image("File:project.jpg");
        ImageView im= new ImageView(img);
        root.getChildren().addAll(im,table);
        root.getChildren().addAll(exit);
        st.setMaximized(false);
        st.initStyle(StageStyle.UNDECORATED);
        st.setMaxHeight(500);
        st.setMaxWidth(800);
        st.setScene(sce);
        st.show();
    }
    
}
