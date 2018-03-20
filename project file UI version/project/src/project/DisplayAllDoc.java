/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.io.IOException;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Saleem
 */
public class DisplayAllDoc {
    
    private final TableView<DoctorS> table = new TableView<>();
    private  ObservableList<DoctorS> data= FXCollections.observableArrayList(
    new DoctorS("Saleem",315249630,"Unknown",21,"Male",1));
     
    public DisplayAllDoc() throws IOException{
        DoctorS d= new DoctorS();
        this.data=d.Display();
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
                ScenesForDoctor sd= new ScenesForDoctor();
                sd.start();
                st.close();
            }
        });
        
        TableColumn idcol = new TableColumn("Id#");
        idcol.setMinWidth(30);
        idcol.setCellValueFactory(new PropertyValueFactory<>("DoctorID"));
       
        TableColumn namecol = new TableColumn("Name");
        namecol.setMinWidth(100);
        namecol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
        TableColumn phonecol = new TableColumn("Phone #");
        phonecol.setMinWidth(100);
        phonecol.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        
        TableColumn agecol = new TableColumn("Age");
        agecol.setMinWidth(30);
        agecol.setCellValueFactory(new PropertyValueFactory<>("age"));
        
        TableColumn specol = new TableColumn("Speciality");
        specol.setMinWidth(150);
        specol.setCellValueFactory(new PropertyValueFactory<>("Spciality"));
        
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