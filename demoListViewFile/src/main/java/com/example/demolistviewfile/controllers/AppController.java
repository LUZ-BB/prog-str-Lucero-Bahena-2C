package com.example.demolistviewfile.controllers;

import com.example.demolistviewfile.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {

    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAge;

    private ObservableList<String> data = FXCollections.observableArrayList();
    PersonService service= new PersonService();

    @FXML
    public void initialize(){
        listView.setItems(data);
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue,newValue)->{
                    String[] parts= newValue.split("-");
                    txtName.setText(parts[0]);
                    txtEmail.setText(parts[1]);
                    txtAge.setText(parts[2]);

                }
        );
        loadFromFile();
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    @FXML
    public void onAddPerson(){

        try{
            String name= txtName.getText();
            String email=txtEmail.getText();
            String age=txtAge.getText();
            service.addPerson(name,email,age);
            lblMsg.setText("usuario creado correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();
            loadFromFile();

        } catch (IOException e) {
            lblMsg.setText("es error de archivo" + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException e) {
            lblMsg.setText("es error de datos"+ e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");

        }
    }
    @FXML
    public void onUpdate(){
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            String name = txtName.getText();
            String email = txtEmail.getText();
            String age = txtAge.getText();
            service.updatePerson(index,name,email,age);
            loadFromFile();
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();
            lblMsg.setText("Se actualizo el registro correctamente");
        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo");

        }catch (IllegalArgumentException e){
            lblMsg.setText("Hubo un error con los datos"+e.getMessage());
        }
    }


    @FXML
    public void onDelete(){
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            String name = txtName.getText();
            String email = txtEmail.getText();
            String age = txtAge.getText();
            service.deletePerson(index);
            loadFromFile();
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();
            lblMsg.setText("Se elimino correctamente");
        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo");

        }catch (IllegalArgumentException e){
            lblMsg.setText("Hubo un error con los datos"+e.getMessage());
        }
    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadForListView();
            data.setAll(items);
            lblMsg.setText("Datos cargados correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText("Error: "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
}
