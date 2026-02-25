package com.example.demojavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class FormController {
    @FXML
    private TextField txtNombre;

    @FXML
    private  TextField txtEmail;

    @FXML
    private TextField txtEdad;

    @FXML
    private Button button;

    @FXML
    private Label lblResultado;

    public void OnValidate(ActionEvent event){
        String nombre= txtNombre.getText() == null ?"": txtNombre.getText();
        String email = txtEmail.getText() == null ?"": txtEmail.getText();
        String edad = txtEdad.getText()== null ?"": txtEdad.getText();

        List<String> errores = new ArrayList<>();

        // validacion de campo nombre

        if (nombre.isBlank() || nombre.length()<3){
            errores.add("El nombre es requerido");

        }
        if (email.isBlank() || !email.contains("@") || !email.contains(".")){
            errores.add("El email es invalido");
        }
        int edadValido=0;
        try {
            edadValido=Integer.parseInt(edad);
            if (edadValido <= 0 || edadValido>120 ){
                System.out.println("edad fuera de rango");
            }

        }catch (Exception e){
            System.out.println("dato no numerico");
        }

        if (errores.isEmpty()){
            lblResultado.setText("El formulario es correcto");
            lblResultado.setStyle("-fx-text-fill: green;");
        }else {
            lblResultado.setText("Error de: "+String.join(", ", errores));
            lblResultado.setStyle("-fx-text-fill: red;");
        }
 }
}




